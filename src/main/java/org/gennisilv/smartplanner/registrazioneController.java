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
import org.gennisilv.smartplanner.data.Utente;
import org.gennisilv.smartplanner.data.UtenteDAO;
import org.gennisilv.smartplanner.logic.UtenteLogic;
import org.gennisilv.smartplanner.utils.UserHolder;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        if(!checkName(nome))
            if(!checkName(cognome))
                if(date(nascita))
                    if(checkEmail(email))
                        if(!formato(username))
                            if(lunghezza(password)){
                                UtenteLogic.registrazione(email,password,nome,cognome,nascita,username);
                                switchToHome(e);
                            }
                            else{
                                //passowrd troppo corta o troppo lunga
                                Alert alert = new Alert(Alert.AlertType.INFORMATION,"La passqord deve avere una lunghezza compresa tra gli 8 e i 30 caratteri");
                                alert.showAndWait();
                            }
                        else{
                            //formato username illegale
                            Alert alert = new Alert(Alert.AlertType.INFORMATION,"L'username non può contenere caratteri speciali");
                            alert.showAndWait();
                        }
                    else{
                        //email in formato errato
                        Alert alert = new Alert(Alert.AlertType.INFORMATION,"Inserisci una mail valida");
                        alert.showAndWait();
                    }
                else{
                    //utente troppo giovane
                    Alert alert = new Alert(Alert.AlertType.INFORMATION,"Per utilizzare l'applicazione devi avere almeno 16 anni");
                    alert.showAndWait();
                }
            else{
                //cognome che contiene numeri o caratteri speciali
                Alert alert = new Alert(Alert.AlertType.INFORMATION,"Il cognome non può contenere numeri o caratteri speciali");
                alert.showAndWait();
            }
        else{
            //nome che contiene numeri o caratteri speciali
            Alert alert = new Alert(Alert.AlertType.INFORMATION,"Il nome non può contenere numeri o caratteri speciali");
            alert.showAndWait();
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

    private boolean checkName(String nome){
        return Pattern.compile("[^a-zA-Z]").matcher(nome).find();
    }

    private boolean date(GregorianCalendar nascita){
        GregorianCalendar dataAttuale = new GregorianCalendar();
        dataAttuale.add(Calendar.YEAR, -16);

        return nascita.before(dataAttuale);
    }

    private boolean checkEmail(String email){
        String regex = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    private boolean formato(String username){
        return Pattern.compile("[^a-zA-Z0-9]").matcher(username).find();
    }

    private boolean lunghezza(String password){
        if(password.length()<8 || password.length()>30)
            return false;
        return true;
    }
}
