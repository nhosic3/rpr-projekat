package ba.unsa.etf.rpr.controllers;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class HomeController {
    public Label welcomeField;

    public void closeAction(ActionEvent actionEvent) {
        Stage stage = (Stage) welcomeField.getScene().getWindow();
        stage.close();
    }
}
