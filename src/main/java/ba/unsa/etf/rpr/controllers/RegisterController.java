package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.dao.ClientDaoSQLImpl;
import ba.unsa.etf.rpr.domain.Client;
import ba.unsa.etf.rpr.exceptions.ServiceException;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
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
        Client cl1 = c.searchByEmail(emailId.getText());
        if(cl1 != null){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Warning!");
            alert.setHeaderText("Try again!");
            alert.setContentText("This email is already used.");
            alert.show();
            return;
        }
        if(firstNameId.getText().isEmpty() || lastNameId.getText().isEmpty() || emailId.getText().isEmpty()
            || numberId.getText().isEmpty() || passwordId.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Warning!");
            alert.setHeaderText("Try again!");
            alert.setContentText("Text fields can't be empty.");
            alert.show();
            return;
        }
        Client cl = new Client(1, firstNameId.getText(), lastNameId.getText(), numberId.getText(), emailId.getText(), passwordId.getText());
        c.add(cl);
        Stage stage = (Stage) firstNameId.getScene().getWindow();
        stage.close();
    }
}
