package com.serg.labinvestigations.controller;

import com.serg.labinvestigations.entity.InvestigationData;
import com.serg.labinvestigations.types.InvestigationType;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import lombok.extern.slf4j.Slf4j;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

@Slf4j
@FxmlView("/fxml/UrineDialog.fxml")
@Component
public class UrineController extends InvestigationDialogController {
    @Override
    protected void initInvestigationDataWithControls(InvestigationData investigationData) {
    }

    @Override
    public void fillControlsByInvestigationData(InvestigationData focusedItem) {
    }
}

