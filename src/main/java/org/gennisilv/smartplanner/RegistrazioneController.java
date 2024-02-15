package org.gennisilv.smartplanner;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.gennisilv.smartplanner.logic.UtenteLogic;

import java.io.IOException;
import java.time.LocalDate;
import java.util.GregorianCalendar;

public class RegistrazioneController extends BarraController {
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
        LocalDate data = dataReg.getValue();
        GregorianCalendar nascita = null;
        if(data != null) {
            nascita = new GregorianCalendar(data.getYear(),data.getMonthValue()-1,data.getDayOfMonth());
        }
        String username = usernameReg.getText();
        int esito = UtenteLogic.registrazione(email, password, nome, cognome, nascita, username) ;

        Alert alert;

        switch(esito){
            case 0:
                //tutto okay
                switchToHome(e);
                break;
            case 1:
                //passowrd troppo corta, troppo lunga o vuota
                alert = new Alert(Alert.AlertType.INFORMATION,"La password deve avere una lunghezza compresa tra gli 8 e i 30 caratteri");
                alert.showAndWait();
                break;
            case 2:
                //formato username illegale o vuoto
                alert = new Alert(Alert.AlertType.INFORMATION,"L'username è obbligatorio e non può contenere caratteri speciali");
                alert.showAndWait();
                break;
            case 3:
                //email in formato errato o vuota
                alert = new Alert(Alert.AlertType.INFORMATION,"Inserisci una mail valida");
                alert.showAndWait();
                break;
            case 4:
                //utente troppo giovane
                alert = new Alert(Alert.AlertType.INFORMATION,"Per utilizzare l'applicazione devi avere almeno 16 anni");
                alert.showAndWait();
                break;
            case 5:
                //cognome che contiene numeri, caratteri speciali, o è vuoto
                alert = new Alert(Alert.AlertType.INFORMATION,"Il cognome non può contenere numeri o caratteri speciali");
                alert.showAndWait();
                break;
            case 6:
                //nome che contiene numeri, caratteri speciali o è vuoto
                alert = new Alert(Alert.AlertType.INFORMATION,"Il nome non può contenere numeri o caratteri speciali");
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
