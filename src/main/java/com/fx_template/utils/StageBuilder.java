package com.fx_template.utils;

import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.util.Objects;

public class StageBuilder {
    public final static Image icon = new Image(Objects.requireNonNull(StageBuilder.class.getResourceAsStream("/assets/placeholder24.png")));

    public static Stage getStage(String title) {
        Stage stage = new Stage();
        stage.setTitle(title);
        stage.getIcons().add(icon);
        return stage;
    }
}
