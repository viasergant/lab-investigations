package com.serg.labinvestigations.controller;

import com.serg.labinvestigations.entity.InvestigationData;
import com.serg.labinvestigations.service.InvestigationDataService;
import com.serg.labinvestigations.types.InvestigationType;
import com.serg.labinvestigations.ui.field.AutocompletionlTextField;
import jakarta.annotation.PostConstruct;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.KeyCode;
import lombok.extern.slf4j.Slf4j;
import net.rgielen.fxweaver.core.FxWeaver;
import net.rgielen.fxweaver.core.FxmlView;
import org.controlsfx.control.Notifications;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@Slf4j
@FxmlView("/fxml/MainController.fxml")
public class MainController {

    private static final String DELETE_CMD_ID = "deleteCmd";
    private static final int DELETE_COLUMN_WIDTH = 30;
    private static final int NAME_COLUMN_MIN_WIDTH = 300;

    private final String greeting;
    private final FxWeaver fxWeaver;
    private final InvestigationDataService investigationService;

    @FXML
    public DatePicker filterDateEnd;
    @FXML
    public DatePicker filterDateStart;
    @FXML
    public AutocompletionlTextField filterName;
    @FXML
    private TableView<InvestigationData> table;
    @FXML
    private Label label;

    private ObservableList<InvestigationData> data;
    private boolean tableInitialized = false;

    @FXML
    public void initialize() {
        if (!tableInitialized) {
            initializeTableColumns();
            tableInitialized = true;
        }
        reloadData();
    }

    private void initializeTableColumns() {
        TableColumn<InvestigationData, Date> dateColumn = new TableColumn<>("Дата");
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("dateFormatted"));

        TableColumn<InvestigationData, String> nameColumn = new TableColumn<>("ПІБ");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        nameColumn.setMinWidth(NAME_COLUMN_MIN_WIDTH);

        TableColumn<InvestigationData, InvestigationType> typeColumn = new TableColumn<>("Аналіз");
        typeColumn.setCellValueFactory(new PropertyValueFactory<>("investigationTypeValue"));

        TableColumn<InvestigationData, ImageView> deleteColumn = new TableColumn<>("");
        deleteColumn.setCellValueFactory(new PropertyValueFactory<>("deleteImage"));
        deleteColumn.setId(DELETE_CMD_ID);
        deleteColumn.setMaxWidth(DELETE_COLUMN_WIDTH);
        deleteColumn.setMinWidth(DELETE_COLUMN_WIDTH);

        table.getColumns().setAll(dateColumn, nameColumn, typeColumn, deleteColumn);
    }

    public MainController(@Value("${spring.application.demo.greeting}") String greeting,
                          FxWeaver fxWeaver,
                          InvestigationDataService investigationService) {
        this.greeting = greeting;
        this.fxWeaver = fxWeaver;
        this.investigationService = investigationService;
    }
    @SuppressWarnings("unchecked")
    @PostConstruct
    public void init() {
    }

    private void applyFilter(String name, LocalDate from, LocalDate to) {
        List<InvestigationData> investigationDataList = investigationService.findWithFilter(name, from, to);
        data = FXCollections.observableArrayList(investigationDataList);
        table.setItems(data);

        // Extract unique names for autocomplete
        filterName.getEntries().setAll(
            investigationDataList.stream()
                .map(InvestigationData::getName)
                .distinct()
                .collect(Collectors.toList())
        );
    }

    public void onApplyFilter() {
        String nameFilter = filterName.getText();
        LocalDate startDate = StringUtils.hasLength(filterDateStart.getEditor().getText())
                ? filterDateStart.getValue()
                : null;
        LocalDate endDate = StringUtils.hasLength(filterDateEnd.getEditor().getText())
                ? filterDateEnd.getValue()
                : null;

        applyFilter(nameFilter, startDate, endDate);
    }

    public void onClick(MouseEvent mouseEvent) {
        if (table.getItems().size() == 0 || table.getFocusModel().getFocusedCell().getTableColumn() == null) {
            return;
        }
        if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){
            TableView.TableViewFocusModel<InvestigationData> focusModel = table.getFocusModel();
            if (mouseEvent.getClickCount() == 2) {
                InvestigationDialogController dialogController =
                        (InvestigationDialogController) fxWeaver.loadController(focusModel.getFocusedItem().getInvestigationType().getDialogControllerClass());
                dialogController.initCommon();
                dialogController.fillCommonControls(focusModel.getFocusedItem());
                dialogController.fillControlsByInvestigationData(focusModel.getFocusedItem());
                dialogController.show();
            } else if (mouseEvent.getClickCount() == 1) {
                String id = table.getFocusModel().getFocusedCell().getTableColumn().getId();
                if ("deleteCmd".equals(id)) {
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("Confirmation Dialog");
                    alert.setHeaderText(null);
                    alert.setContentText("Ви дійсно хочете видалити рядок?");

                    Optional<ButtonType> result = alert.showAndWait();
                    if (result.get() == ButtonType.OK){
                        try {
                            investigationService.remove(focusModel.getFocusedItem());
                            reloadData();
                            Notifications.create()
                                    .title("Information")
                                    .text("Видалено!")
                                    .showInformation();
                        } catch (Exception e) {
                            alert = new Alert(Alert.AlertType.ERROR);
                            alert.setTitle("Error Dialog");
                            alert.setHeaderText("Помилка!");
                            alert.setContentText(e.getLocalizedMessage());
                            alert.showAndWait();
                        }
                    }
                }
            }
        }
    }

    public void reloadData() {
        onApplyFilter();
    }

    public void onKeyPressed(KeyEvent keyEvent) {
        if (keyEvent.getCode().getName().equalsIgnoreCase("enter")) {
            onApplyFilter();
        }
    }

    public void onCleanFilter(ActionEvent actionEvent) {
        filterDateStart.getEditor().setText("");
        filterDateEnd.getEditor().setText("");
        filterName.setText("");
        onApplyFilter();
    }

    public void onScrapingCreate(ActionEvent actionEvent) {
        fxWeaver.loadController(ScrapingController.class).initNew().show();
    }

    public void onBloodGeneralInvestigationCreate(ActionEvent actionEvent) {
        fxWeaver.loadController(BloodController.class).initNew().show();
    }

    public void onExcretaCreate(ActionEvent actionEvent) {
        fxWeaver.loadController(ExcretaController.class).initNew().show();
    }

    public void onUrineGeneralInvestigationCreate(ActionEvent actionEvent) {
        fxWeaver.loadController(UrineController.class).initNew().show();
    }

    public void onOakBhInvestigationCreate(ActionEvent actionEvent) {
        fxWeaver.loadController(OakBhController.class).initNew().show();
    }

    public void onCoprogramInvestigationCreate(ActionEvent actionEvent) {
        fxWeaver.loadController(CoprogramController.class).initNew().show();
    }

  public void onFullCreate(ActionEvent actionEvent) {
      fxWeaver.loadController(FullController.class).initNew().show();
  }
}