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
import org.gennisilv.smartplanner.logic.UtenteLogic;
import org.gennisilv.smartplanner.utils.UserHolder;

import java.io.IOException;
import java.time.LocalDate;
import java.util.GregorianCalendar;

public class registrazioneController extends barraController{
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private TextField nomeReg;
    @FXML
    private TextField cognomeReg;
    @FXML
    private TextField emailReg;
    @FXML
    private TextField usernameReg;

    @FXML
    private PasswordField passwordReg;
    @FXML
    private PasswordField confermapasswordReg;
    @FXML
    private DatePicker dataReg;




    //metodo che effettua la registrazione (acquisisce i valori e registra il nuovo utente)
    public void registrazione (ActionEvent e)throws IOException
    {
        String email = emailReg.getText();
        String password = passwordReg.getText();
        String nome = nomeReg.getText();
        String cognome = cognomeReg.getText();
        GregorianCalendar nascita = new GregorianCalendar(dataReg.getValue().getYear(),dataReg.getValue().getMonthValue()-1,dataReg.getValue().getDayOfMonth());
        String username = usernameReg.getText();

        /*
        CONTROLLI SUI CAMPI
         */


        UtenteLogic.registrazione(email,password,nome,cognome,nascita,username);

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
