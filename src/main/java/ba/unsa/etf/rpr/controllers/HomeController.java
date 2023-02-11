package ba.unsa.etf.rpr.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

import static javafx.scene.control.PopupControl.USE_COMPUTED_SIZE;

public class HomeController {
    public Label welcomeField;

    public void closeAction(ActionEvent actionEvent) {
        Stage stage = (Stage) welcomeField.getScene().getWindow();
        stage.close();
    }

    public void buyAction(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();
        FXMLLoader l = new FXMLLoader(getClass().getResource("/FXML/buy.fxml"));
        Parent root = l.load();
        BuyController rc = l.getController();
        stage.setResizable(false);
        stage.setTitle("Buy");
        stage.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
        stage.show();
    }
}
