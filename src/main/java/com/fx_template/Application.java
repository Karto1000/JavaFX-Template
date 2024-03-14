package com.fx_template;

import com.fx_template.data.Datasource;
import com.fx_template.data.MemoryDatasource;
import com.fx_template.data.SQLDataSource;
import com.fx_template.utils.StageBuilder;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Application extends javafx.application.Application {
    public static final Datasource datasource = new SQLDataSource();

    @Override
    public void start(Stage stage) throws IOException {
        // WITH LOGIN
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("login.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.getIcons().add(StageBuilder.icon);
        stage.setTitle("Login");
        stage.show();

        // WITHOUT LOGIN
//        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("main.fxml"));
//        Scene scene = new Scene(fxmlLoader.load());
//        stage.getIcons().add(StageBuilder.icon);
//        stage.setScene(scene);
//        stage.show();

    }

    public static void main(String[] args) {
        datasource.init();
        launch();
    }
}