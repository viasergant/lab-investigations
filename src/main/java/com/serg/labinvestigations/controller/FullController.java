package com.serg.labinvestigations.controller;

import com.serg.labinvestigations.entity.InvestigationData;
import jakarta.annotation.PostConstruct;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Control;
import javafx.scene.control.Tab;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import lombok.extern.slf4j.Slf4j;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

@Slf4j
@FxmlView("/fxml/FullDialog.fxml")
@Component
public class FullController extends InvestigationDialogController {
    @FXML
    public Tab bloodTab;

    private void valueChangeListener(Control control) {

    }
    //@PostConstruct
    protected void init() {
        super.init();
        ReflectionUtils.doWithFields(InvestigationData.class, field -> {
            if (dialog == null) {
                return;
            }
            String name = field.getName();
            field.setAccessible(true);
            Node node = dialog.lookup("#" + name);
            if (node instanceof TextField textField) {
                textField.textProperty().addListener((observable, oldValue, newValue) -> {
                    valueChangeListener(textField);
                });
            }
            if (node instanceof TextArea textArea) {
                textArea.textProperty().addListener((observable, oldValue, newValue) -> {
                    valueChangeListener(textArea);
                });
            }
        });

    }

    @Override
    protected void initInvestigationDataWithControls(InvestigationData investigationData) {
    }

    @Override
    public void fillControlsByInvestigationData(InvestigationData focusedItem) {
    }
}

