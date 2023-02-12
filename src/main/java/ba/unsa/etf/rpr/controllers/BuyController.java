package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.dao.ClientDaoSQLImpl;
import ba.unsa.etf.rpr.dao.ServiceDaoSQLImpl;
import ba.unsa.etf.rpr.domain.Client;
import ba.unsa.etf.rpr.domain.Service;
import javafx.fxml.FXML;
import ba.unsa.etf.rpr.exceptions.ServiceException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class BuyController {
    public ChoiceBox<String> cb;
    public TextField fn;
    public TextField ln;
    public TextField email;

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
        ClientDaoSQLImpl c = new ClientDaoSQLImpl();
        Client cl = c.searchByEmail(email.getText());
        LocalDate l = LocalDate.now();
        ZoneId defaultZoneId = ZoneId.systemDefault();
        Date date = Date.from(l.atStartOfDay(defaultZoneId).toInstant());
        LocalDate l2 =  LocalDate.now().plusDays(15);
        Date date2 = Date.from(l2.atStartOfDay(defaultZoneId).toInstant());
        ServiceDaoSQLImpl s = new ServiceDaoSQLImpl();
        Service ser = new Service(1, cb.getValue(), 123, date, date2, cl.getID());
        s.add(ser);
        cl.setPaid(true);
        Stage stage = (Stage) cb.getScene().getWindow();
        stage.close();
    }

    public void cancelAction(ActionEvent actionEvent) {
        Stage stage = (Stage) cb.getScene().getWindow();
        stage.close();
    }
}
