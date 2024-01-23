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
        Utente utente= new Utente();
        utente.setEmail(emailReg.getText());
        utente.setPassword(passwordReg.getText());
        utente.setNome(nomeReg.getText());
        utente.setCognome(cognomeReg.getText());
        utente.setDataDiNascita(new GregorianCalendar(dataReg.getValue().getYear(),dataReg.getValue().getMonthValue()-1,dataReg.getValue().getDayOfMonth()));
        utente.setUsername(usernameReg.getText());
        UtenteDAO.doAddUtente(utente);

        sendUser(utente);

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

    //assegna l'utente a una variabile recuperabile in tutta l'applicazione
    private void sendUser(Utente utente){
        UserHolder userHolder = UserHolder.getIstanza();
        userHolder.setUtente(utente);
    }
}