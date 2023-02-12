package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.business.ServiceManager;
import ba.unsa.etf.rpr.domain.Service;
import ba.unsa.etf.rpr.exceptions.ServiceException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.Date;

public class ServicesController {
    public TableColumn<Service, Integer> IDColumn;
    public TableColumn<Service, String> Service_typeColumn;
    public TableColumn<Service, Integer> PriceColumn;
    public TableColumn<Service, Date> Start_timeColumn;
    public TableColumn<Service, Date> End_timeColumn;

    final private ServiceManager sm = new ServiceManager();
    public TableView serviceTable;

    public void initialize() throws ServiceException {
        ObservableList<Service> s = FXCollections.observableArrayList();
        s.addAll(sm.searchByClientId(LoginController.currentClient.getID()));
        IDColumn.setCellValueFactory(new PropertyValueFactory("ID"));
        Service_typeColumn.setCellValueFactory(new PropertyValueFactory("Service_type"));
        PriceColumn.setCellValueFactory(new PropertyValueFactory("Price"));
        Start_timeColumn.setCellValueFactory(new PropertyValueFactory("Start_time"));
        End_timeColumn.setCellValueFactory(new PropertyValueFactory("End_time"));
        serviceTable.setItems(s);
    }
}
