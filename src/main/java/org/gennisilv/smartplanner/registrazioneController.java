package org.gennisilv.smartplanner;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.gennisilv.smartplanner.data.Utente;
import org.gennisilv.smartplanner.data.UtenteDAO;

import java.io.IOException;

public class registrazioneController extends barraController{
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private TextField nomeReg;
    private TextField cognomeReg;
    private TextField emailReg;
    private TextField usernameReg;

    private PasswordField passwordReg;
    private PasswordField confermapasswordReg;
    private DatePicker dataReg;




    //metodo che effettua la registrazione (acquisisce i valori e registra il nuovo utente)

    public void registrazione (ActionEvent e)throws IOException
    {
        Utente utente= new Utente();
        utente.setEmail(emailReg.getText());
        utente.setPassword(passwordReg.getText());
        utente.setNome(nomeReg.getText());
        utente.setCognome(cognomeReg.getText());
        utente.setUsername(usernameReg.getText());
        UtenteDAO.doAddUtente(utente);
        //passare utente all'app
        switchToHome(e);
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
