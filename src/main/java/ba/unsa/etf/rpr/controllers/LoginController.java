package ba.unsa.etf.rpr.controllers;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
public class LoginController {
    public TextField emailId;
    public PasswordField passwordId;
    public Button loginButtonId;

    @FXML
    public void initialize() {
        emailId.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String o, String n) {
                if(emailId.getText().isEmpty()){
                    emailId.getStyleClass().add("incorrectField");
                }
            }
        });
        passwordId.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String o, String n) {
                if(passwordId.getText().length()<8){
                    passwordId.getStyleClass().add("incorrectField");
                }
                else{
                    passwordId.getStyleClass().add("correctField");
                }
            }
        });
    }

    public void loginAction(ActionEvent actionEvent) {

    }
}