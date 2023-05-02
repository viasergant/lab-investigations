package com.serg.labinvestigations.stage;

import com.serg.labinvestigations.controller.MainController;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import net.rgielen.fxweaver.core.FxWeaver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class PrimaryStageInitializer implements ApplicationListener<StageReadyEvent> {
    private final FxWeaver fxWeaver;

    @Autowired
    public PrimaryStageInitializer(FxWeaver fxWeaver) {
        this.fxWeaver = fxWeaver;
    }

    @Override
    public void onApplicationEvent(StageReadyEvent event) {
        Stage stage = event.stage;
        Scene scene = new Scene(fxWeaver.loadView(MainController.class), 800, 600);
        stage.setScene(scene);
        stage.setMaximized(true);
        stage.getIcons().add(new Image(PrimaryStageInitializer.class.getResourceAsStream("/images/microscope.png")));
        stage.setTitle("Лабораторні дослідження");
        stage.show();
    }
}
