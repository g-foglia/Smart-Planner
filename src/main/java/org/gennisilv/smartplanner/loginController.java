package org.gennisilv.smartplanner;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.gennisilv.smartplanner.data.Utente;
import org.gennisilv.smartplanner.data.UtenteDAO;
import org.gennisilv.smartplanner.logic.UtenteLogic;
import org.gennisilv.smartplanner.utils.UserHolder;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

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

        if(login == -1){
            Alert alert = new Alert(Alert.AlertType.INFORMATION,"La combinazione di email e password è sbagliata");
            alert.showAndWait();
        }else{
            switchToHome(e);
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
