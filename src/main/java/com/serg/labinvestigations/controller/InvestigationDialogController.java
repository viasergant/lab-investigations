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
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.util.StringConverter;
import org.controlsfx.control.Notifications;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ReflectionUtils;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Date;

public abstract class InvestigationDialogController extends DialogController {
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
  }

  public InvestigationDialogController initNew() {
    selectedData = null;
    Date currentDate = new Date();
    Instant instant = currentDate.toInstant();
    LocalDate localDate = instant.atZone(ZoneId.systemDefault()).toLocalDate();
    datePicker.setValue(localDate);
    initCommon();
    return this;
  }

  protected void saveData(InvestigationData selectedData) {
    InvestigationData investigationData = (selectedData != null) ? selectedData : (new InvestigationData());
    investigationData.setName(name.getText());
    investigationData.setDate(datePicker.getValue());
    investigationData.setDetails(details.getText());
    investigationData.setAge(age.getText());
    investigationData.setOrigin(origin.getText());
    investigationData.setPatientType(((PatientType) patientType.getSelectionModel().getSelectedItem()).name());
    investigationData.setGender(((GenderType) gender.getSelectionModel().getSelectedItem()).name());

    ReflectionUtils.doWithFields(InvestigationData.class, field -> {
      try {
        String name = field.getName();
        Node node = dialog.lookup("#" + name);
        String value = null;
        if (node instanceof TextField) {
          value = ((TextField) node).getText();
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
      if (node instanceof TextField) {
        ((TextField) node).setText((String) value);
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
    details.setText(focusedItem.getDetails());
    selectedData = focusedItem;
  }
}
