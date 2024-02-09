package org.gennisilv.smartplanner;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.gennisilv.smartplanner.logic.UtenteLogic;

import java.io.IOException;

public class loginController extends barraController {
    private Stage stage;
    private Scene scene;

    @FXML
    private TextField emailLogin;
    @FXML
    private PasswordField passwordLogin;


    //metodo che effettua il login (controllo di email e password per mezzo di UtenteDAO)
    public void login (ActionEvent e) throws IOException {
        int login = UtenteLogic.login(emailLogin.getText(), passwordLogin.getText());


        Alert alert;
        switch(login){
            case 0:
                switchToHome(e);
                break;
            case 1:
                alert = new Alert(Alert.AlertType.INFORMATION,"La combinazione di email e password è sbagliata");
                alert.showAndWait();
                break;
            case 2:
                alert = new Alert(Alert.AlertType.INFORMATION,"Il formato della mail non è corretto.");
                alert.showAndWait();
                break;
        }
    }

    public void switchToHome (ActionEvent e) throws IOException
    {
        Parent root = FXMLLoader.load(getClass().getResource("home.fxml"));
        stage= (Stage) ((Node)e.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToPaginaIniziale (ActionEvent e) throws IOException
    {
        Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        stage= (Stage) ((Node)e.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
