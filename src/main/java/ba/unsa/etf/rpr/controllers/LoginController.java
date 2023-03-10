package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.business.ClientManager;
import ba.unsa.etf.rpr.dao.ClientDaoSQLImpl;
import ba.unsa.etf.rpr.domain.Client;
import ba.unsa.etf.rpr.exceptions.ServiceException;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

import static javafx.scene.control.PopupControl.USE_COMPUTED_SIZE;
/**
 * Controller class for Login window
 */
public class LoginController {
    public TextField emailId;
    public PasswordField passwordId;
    public static Client currentClient;
    final private ClientManager cm = new ClientManager();
    /**
     * Implementing listener
     */
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
    /**
     * Login data check
     */
    public void loginAction(ActionEvent actionEvent) throws IOException, ServiceException {
        if(passwordId.getText().length()<8 || emailId.getText().isEmpty())
            return;
        Client cl = cm.searchByEmail(emailId.getText());
        if(cl == null){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Incorrect login data");
            alert.setHeaderText("Try again!");
            alert.show();
            return;
        }
        Client cl2 = cm.searchByPassword(passwordId.getText());
        if(cl2 == null){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Incorrect login data");
            alert.setHeaderText("Try again!");
            alert.show();
            return;
        }
        currentClient = cl;
        Stage stage2 = (Stage) passwordId.getScene().getWindow();
        stage2.close();
        Stage stage = new Stage();
        FXMLLoader l = new FXMLLoader(getClass().getResource("/FXML/home.fxml"));
        Parent root = l.load();
        HomeController hc = l.getController();
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
