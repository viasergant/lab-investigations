package com.serg.labinvestigations.controller;

import com.serg.labinvestigations.entity.InvestigationData;
import com.serg.labinvestigations.service.InvestigationDataService;
import com.serg.labinvestigations.types.GenderType;
import com.serg.labinvestigations.types.InvestigationType;
import com.serg.labinvestigations.types.PatientType;
import com.serg.labinvestigations.ui.field.FxDatePickerConverter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.util.StringConverter;
import org.controlsfx.control.Notifications;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ReflectionUtils;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public abstract class InvestigationDialogController extends DialogController {
  private final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
  public Button saveBtn;
  public Button cancelBtn;
  @FXML
  public TextField name;
  @FXML
  public DatePicker datePicker;
  @FXML
  public TextField age;
  @FXML
  public TextField origin;
  @FXML
  public ComboBox gender;
  @FXML
  public ComboBox patientType;
  @FXML
  public TextArea details;
  @FXML
  public TextArea details1;
  @FXML
  public TextArea details2;
  @FXML
  public TextArea details3;
  @FXML
  public TextArea details4;
  @FXML
  public TextArea details5;
  @FXML
  public TextField field1;
  @FXML
  public TextField field2;
  @FXML
  public TextField field3;
  @FXML
  public TextField field4;
  @FXML
  public TextField field5;
  @FXML
  public TextField field6;
  @FXML
  public TextField field7;
  @FXML
  public TextField field8;
  @FXML
  public TextField field9;
  @FXML
  public TextField field10;
  @FXML
  public TextField field11;
  @FXML
  public TextField field12;
  @FXML
  public TextField field13;
  @FXML
  public TextField field14;
  @FXML
  public TextField field15;
  @FXML
  public TextField field16;
  @FXML
  public TextField field17;
  @FXML
  public TextField field18;
  @FXML
  public TextField field19;
  @FXML
  public TextField field20;
  @FXML
  public TextField field21;
  @FXML
  public TextField field22;
  @FXML
  public TextField field23;
  @FXML
  public TextField field24;
  @FXML
  public TextField field25;
  @FXML
  public TextField field26;
  @FXML
  public TextField field27;
  @FXML
  public TextField field28;
  @FXML
  public TextField field29;
  @FXML
  public TextField field30;
  @FXML
  public TextField field31;
  @FXML
  public TextField field32;
  @FXML
  public TextField field33;
  @FXML
  public TextField field34;
  @FXML
  public TextField field35;
  @FXML
  public TextField field36;
  @FXML
  public TextField field37;
  @FXML
  public TextField field38;
  @FXML
  public TextField field39;
  @FXML
  public TextField field40;
  @FXML
  public TextField field41;
  @FXML
  public TextField field42;
  @FXML
  public TextField field43;
  @FXML
  public TextField field44;
  @FXML
  public TextField field45;
  @FXML
  public TextField field46;
  @FXML
  public TextField field47;
  @FXML
  public TextField field48;
  @FXML
  public TextField field49;
  @FXML
  public TextField field50;
  @FXML
  public TextField field51;
  @FXML
  public TextField field52;
  @FXML
  public TextField field53;
  @FXML
  public TextField field54;
  @FXML
  public TextField field55;
  @FXML
  public TextField field56;
  @FXML
  public TextField field57;
  @FXML
  public TextField field58;
  @FXML
  public TextField field59;
  @FXML
  public TextField field60;
  @FXML
  public TextField field61;
  @FXML
  public TextField field62;
  @FXML
  public TextField field63;
  @FXML
  public TextField field64;
  @FXML
  public TextField field65;
  @FXML
  public TextField field66;
  @FXML
  public TextField field67;
  @FXML
  public TextField field68;
  @FXML
  public TextField field69;
  @FXML
  public TextField field70;
  @FXML
  public TextField field71;
  @FXML
  public TextField field72;
  @FXML
  public TextField field73;
  @FXML
  public TextField field74;
  @FXML
  public TextField field75;
  @FXML
  public TextField field76;
  @FXML
  public TextField field77;
  @FXML
  public TextField field78;
  @FXML
  public TextField field79;
  @FXML
  public TextField field80;
  @FXML
  public TextField field81;
  @FXML
  public TextField field82;
  @FXML
  public TextField field83;
  @FXML
  public TextField field84;
  @FXML
  public TextField field85;
  @FXML
  public TextField field86;
  @FXML
  public TextField field87;
  @FXML
  public TextField field88;
  @FXML
  public TextField field89;
  @FXML
  public TextField field90;
  @FXML
  public TextField field91;
  @FXML
  public TextField field92;
  @FXML
  public TextField field93;
  @FXML
  public TextField field94;
  @FXML
  public TextField field95;
  @FXML
  public TextField field96;
  @FXML
  public TextField field97;
  @FXML
  public TextField field98;
  @FXML
  public TextField field99;
  @FXML
  public TextField field100;
  @FXML
  public TextField field101;
  @FXML
  public TextField field102;
  @FXML
  public TextField field103;
  @FXML
  public TextField field104;
  @FXML
  public TextField field105;
  @FXML
  public TextField field106;
  @FXML
  public TextField field107;
  @FXML
  public TextField field108;
  @FXML
  public TextField field109;
  @FXML
  public TextField field110;

  protected InvestigationData selectedData;
  @Autowired
  protected InvestigationDataService investigationService;
  @Autowired
  protected MainController mainController;

  void initCommon() {
    ObservableList<PatientType> pt = FXCollections.observableArrayList(PatientType.values());
    patientType.setConverter(new StringConverter<PatientType>() {
      @Override
      public String toString(PatientType patientType) {
        return patientType.getDescription();
      }

      @Override
      public PatientType fromString(String s) {
        return PatientType.resolveFromString(s).orElse(null);
      }
    });
    patientType.setItems(pt);
    patientType.getSelectionModel().select(0);

    ObservableList<GenderType> gt = FXCollections.observableArrayList(GenderType.values());
    gender.setItems(gt);
    gender.setConverter(new StringConverter<GenderType>() {
      @Override
      public String toString(GenderType genderType) {
        return genderType.getDescription();
      }

      @Override
      public GenderType fromString(String s) {
        return GenderType.resolveFromString(s).orElse(null);
      }
    });
    gender.getSelectionModel().select(0);
    dialog.addEventFilter(KeyEvent.KEY_PRESSED, (KeyEvent event) ->
    {
      if (event.getCode() == KeyCode.ENTER) {
        KeyEvent newEvent
            = new KeyEvent(
            null,
            null,
            KeyEvent.KEY_PRESSED,
            "",
            "\t",
            KeyCode.TAB,
            event.isShiftDown(),
            event.isControlDown(),
            event.isAltDown(),
            event.isMetaDown()
        );

        Event.fireEvent(event.getTarget(), newEvent);
        event.consume();
      }
    });
    datePicker.setConverter(new StringConverter<LocalDate>() {
      @Override
      public String toString(LocalDate localDate) {
        if (localDate == null)
          return "";
        return dateTimeFormatter.format(localDate);
      }

      @Override
      public LocalDate fromString(String dateString) {
        if (dateString == null || dateString.trim().isEmpty())
          return null;
        try {
          return LocalDate.parse(dateString, dateTimeFormatter);
        } catch (Exception e) {
          //Bad date value entered
          return null;
        }
      }
    });
  }

  public InvestigationDialogController initNew() {
    selectedData = null;
    Date currentDate = new Date();
    Instant instant = currentDate.toInstant();
    LocalDate localDate = instant.atZone(ZoneId.systemDefault()).toLocalDate();
    datePicker.setValue(localDate);
    initCommon();
    init();
    return this;
  }

  protected void saveData(InvestigationData selectedData) {
    InvestigationData investigationData = (selectedData != null) ? selectedData : (new InvestigationData());
    investigationData.setName(name.getText());
    investigationData.setDate(LocalDate.parse(datePicker.getEditor().getText(), dateTimeFormatter));
    //investigationData.setDetails(details.getText());
    investigationData.setAge(age.getText());
    investigationData.setOrigin(origin.getText());
    investigationData.setPatientType(((PatientType) patientType.getSelectionModel().getSelectedItem()).name());
    investigationData.setGender(((GenderType) gender.getSelectionModel().getSelectedItem()).name());

    ReflectionUtils.doWithFields(InvestigationData.class, field -> {
      try {
        String name = field.getName();
        Node node = dialog.lookup("#" + name);
        String value = null;
        if (node instanceof TextField textField) {
          value = textField.getText();
          field.setAccessible(true);
          field.set(investigationData, value);
        }
        if (node instanceof TextArea textArea) {
          value = textArea.getText();
          field.setAccessible(true);
          field.set(investigationData, value);
        }
      } catch (Exception e) {
      }
    });
    investigationData.setInvestigationType(InvestigationType.getTypeByController(this));
    initInvestigationDataWithControls(investigationData);
    investigationService.save(investigationData);
    mainController.reloadData();
    Notifications.create()
        .title("Information")
        .text("Збережено!")
        .showInformation();
  }

  @Override
  protected void init() {
    String pattern = "dd/MM/yyyy";
    // Create the DateConverter
    FxDatePickerConverter converter = new FxDatePickerConverter();
    // Add the Converter to the DatePicker
    datePicker.setConverter(converter);
    //initCommon();
  }

  public void onCancel(ActionEvent actionEvent) {
    closeDialog();
  }

  protected void saveData() {
  }

  public void onSave(ActionEvent actionEvent) {
    saveData(selectedData);
    closeDialog();
  }

  protected abstract void initInvestigationDataWithControls(InvestigationData investigationData);

  public abstract void fillControlsByInvestigationData(InvestigationData focusedItem);

  public void fillCommonControls(InvestigationData focusedItem) {
    ReflectionUtils.doWithFields(InvestigationData.class, field -> {
      String name = field.getName();
      field.setAccessible(true);
      Object value = ReflectionUtils.getField(field, focusedItem);
      Node node = dialog.lookup("#" + name);
      if (node instanceof TextField textField) {
        textField.setText((String) value);
      }
      if (node instanceof TextArea textArea) {
        textArea.setText((String) value);
      }
    });

    name.setText(focusedItem.getName());
    datePicker.setValue(focusedItem.getDate());
    age.setText(focusedItem.getAge());
    try {
      gender.getSelectionModel().select(GenderType.valueOf(focusedItem.getGender()));
      patientType.getSelectionModel().select(PatientType.valueOf(focusedItem.getPatientType()));
    } catch (Exception e) {

    }
    if (details != null) {
      details.setText(focusedItem.getDetails());
    }
    selectedData = focusedItem;
  }
}
