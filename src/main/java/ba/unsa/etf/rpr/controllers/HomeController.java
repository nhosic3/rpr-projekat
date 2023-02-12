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
    public Button buyAngular;
    public Button buyHcj;
    public Button buyNode;
    public Button buyPs;
    public Button buyReact;

    public void buyAction(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();
        FXMLLoader l = new FXMLLoader(getClass().getResource("/FXML/buy.fxml"));
        Parent root = l.load();
        BuyController bc = l.getController();
        stage.setResizable(false);
        stage.setTitle("Buy");
        stage.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
        stage.show();
    }

    public void myServicesAction(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();
        FXMLLoader l = new FXMLLoader(getClass().getResource("/FXML/services.fxml"));
        Parent root = l.load();
        ServicesController sc = l.getController();
        stage.setResizable(false);
        stage.setTitle("My services");
        stage.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
        stage.show();
    }
}
