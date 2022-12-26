package ba.unsa.etf.rpr.controllers;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

import static javafx.scene.control.PopupControl.USE_COMPUTED_SIZE;

public class LoginController {
    public TextField emailId;
    public PasswordField passwordId;
    public Button loginButtonId;

    @FXML
    public void initialize() {
        passwordId.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String o, String n) {
                if(passwordId.getText().length()<8){
                    passwordId.getStyleClass().removeAll("correctField");
                    passwordId.getStyleClass().add("incorrectField");
                }
                else{
                    passwordId.getStyleClass().removeAll("incorrectField");
                    passwordId.getStyleClass().add("correctField");
                }
            }
        });
    }

    public void loginAction(ActionEvent actionEvent) throws IOException {
        if(passwordId.getText().isEmpty() || emailId.getText().isEmpty())
            return;
        Stage stage = new Stage();
        FXMLLoader l = new FXMLLoader(getClass().getResource("/FXML/home.fxml"));
        Parent root = l.load();
        HomeController hc = l.getController();
        hc.welcomeField.setText(hc.welcomeField.getText()+emailId.getText());
        stage.setTitle("Home");
        stage.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
        stage.show();
    }

    public void registerAction(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();
        FXMLLoader l = new FXMLLoader(getClass().getResource("/FXML/register.fxml"));
        Parent root = l.load();
        RegisterController rc = l.getController();
        stage.setResizable(false);
        stage.setTitle("Register");
        stage.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
        stage.show();
    }
}
