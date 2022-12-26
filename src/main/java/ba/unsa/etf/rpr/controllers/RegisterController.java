package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.dao.ClientDaoSQLImpl;
import ba.unsa.etf.rpr.domain.Client;
import ba.unsa.etf.rpr.exceptions.ServiceException;
import javafx.event.ActionEvent;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class RegisterController {
    public TextField firstNameId;
    public TextField lastNameId;
    public TextField emailId;
    public TextField numberId;
    public PasswordField passwordId;

    public void registerAction(ActionEvent actionEvent) throws ServiceException {
        ClientDaoSQLImpl c = new ClientDaoSQLImpl();
        Client cl = new Client(1, firstNameId.getText(), lastNameId.getText(), numberId.getText(), emailId.getText(), passwordId.getText(), false);
        c.add(cl);
        Stage stage = (Stage) firstNameId.getScene().getWindow();
        stage.close();
    }
}
