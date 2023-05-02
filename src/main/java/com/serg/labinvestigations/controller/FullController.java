package com.serg.labinvestigations.controller;

import com.serg.labinvestigations.entity.InvestigationData;
import lombok.extern.slf4j.Slf4j;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.stereotype.Component;

@Slf4j
@FxmlView("/fxml/FullDialog.fxml")
@Component
public class FullController extends InvestigationDialogController {
    @Override
    protected void initInvestigationDataWithControls(InvestigationData investigationData) {
    }

    @Override
    public void fillControlsByInvestigationData(InvestigationData focusedItem) {
    }
}

