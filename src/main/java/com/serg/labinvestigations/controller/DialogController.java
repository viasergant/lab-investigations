package com.serg.labinvestigations.controller;

import com.serg.labinvestigations.types.InvestigationType;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class DialogController {

    protected Stage stage;

    @FXML
    protected VBox dialog;

    @FXML
    public void initialize() {
        this.stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(new Scene(dialog));
        stage.setResizable(false);
        stage.setTitle(InvestigationType.getValueByType(this));
    }

    protected void closeDialog() {
        stage.close();
    }

    protected void init() {
    }

    public void show() {
        init();
        stage.showAndWait();
    }
}
