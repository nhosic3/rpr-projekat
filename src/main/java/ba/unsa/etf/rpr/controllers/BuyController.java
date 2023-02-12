package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.dao.ServiceDaoSQLImpl;
import ba.unsa.etf.rpr.domain.Service;
import javafx.fxml.FXML;
import ba.unsa.etf.rpr.exceptions.ServiceException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;

public class BuyController {
    public ChoiceBox<String> cb;
    @FXML
    public void initialize() {
        ObservableList<String> l = FXCollections.observableArrayList();
        l.add("Angular");
        l.add("HTML/CSS/JS");
        l.add("Node");
        l.add("Photoshop");
        l.add("React");
        cb.getItems().addAll(l);
    }
    public void purchaseAction(ActionEvent actionEvent) throws ServiceException {

    }

    public void cancelAction(ActionEvent actionEvent) {
        Stage stage = (Stage) cb.getScene().getWindow();
        stage.close();
    }
}
