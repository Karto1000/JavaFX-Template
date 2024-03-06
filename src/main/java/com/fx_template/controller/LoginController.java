package com.fx_template.controller;

import com.fx_template.Application;
import com.fx_template.utils.StageBuilder;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

import static com.fx_template.Application.datasource;

public class LoginController implements Initializable {
    @FXML
    private Button loginButton;

    @FXML
    private TextField usernameInput;

    @FXML
    private TextField passwordInput;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loginButton.setOnAction(action -> {
            if (datasource.users().login(usernameInput.getText(), passwordInput.getText())) {
                ((Stage) loginButton.getScene().getWindow()).close();

                Stage mainStage = StageBuilder.getStage("Main");
                FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("main.fxml"));

                try {
                    Scene scene = new Scene(fxmlLoader.load());
                    mainStage.setScene(scene);
                    mainStage.show();
                } catch (Exception e) {

                }
            }
        });
    }
}
