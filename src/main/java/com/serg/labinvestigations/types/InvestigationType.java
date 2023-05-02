package com.serg.labinvestigations.types;

import com.serg.labinvestigations.controller.*;

import java.util.Arrays;

public enum InvestigationType {
    SCRAPING("Соскоб", ScrapingController.class),
    URINE("Загальний аналіз сечі", UrineController.class),
    EXCRETA("Виділення", ExcretaController.class),
    BLOOD("Загальний аналіз крові", BloodController.class),
    OAK_BH("ОАК+БХ",OakBhController.class),
    COPROGRAM("Копрограма",CoprogramController.class);

    private final String value;
    private final Class<? extends DialogController> dialogControllerClass;

    InvestigationType(String value, Class<? extends DialogController> dialogControllerClass) {
        this.value = value;
        this.dialogControllerClass = dialogControllerClass;
    }

    public String getValue() {
        return value;
    }

    public Class<?> getDialogControllerClass() {
        return dialogControllerClass;
    }

    public static String getValueByType(Object dialogController) {
        return Arrays.stream(InvestigationType.class.getEnumConstants())
                .filter(e -> {
                    return e.getDialogControllerClass().isInstance(dialogController);
                })
                .findFirst()
                .map(e -> e.getValue())
                .orElse("");
    }
    public static InvestigationType getTypeByController(DialogController dialogController) {
        return Arrays.stream(InvestigationType.class.getEnumConstants())
                .filter(e -> {
                    return e.getDialogControllerClass().isInstance(dialogController);
                })
                .findFirst().get();
    }
}
