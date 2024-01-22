package org.gennisilv.smartplanner;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import org.gennisilv.smartplanner.data.Utente;
import org.gennisilv.smartplanner.data.UtenteDAO;
import org.gennisilv.smartplanner.utils.DateConverter;
import org.gennisilv.smartplanner.utils.UserHolder;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class areaUtenteController extends barraController implements Initializable{
    private Stage stage;
    private Scene scene;

    @FXML
    private  Label username;
    @FXML
    private Label email;
    @FXML
    private Label password;
    @FXML
    private Label nome;
    @FXML
    private Label cognome;
    @FXML
    private Label dataNascita;


    //cancella un utente ed effettua il logout
    public void cancellaUtente(ActionEvent event) throws IOException{
        UtenteDAO.doCancUtente(UserHolder.getIstanza().getUtente().getEmail());
        UserHolder userHolder = UserHolder.getIstanza();
        userHolder.setUtente(null);

        switchToHelloView(event);
    }

    //logout
    public void logout(ActionEvent event) throws IOException{

        UserHolder userHolder = UserHolder.getIstanza();
        userHolder.setUtente(null);

        switchToHelloView(event);
    }

    //inizializza le label per mostrare i dati dell'utente
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Utente utente = UtenteDAO.doRetrieveByEmail(UserHolder.getIstanza().getUtente().getEmail());

        username.setText(username.getText() + " " + utente.getUsername());
        email.setText(email.getText() + " " + utente.getEmail());
        password.setText(password.getText() + " " + utente.getPassword());
        nome.setText(nome.getText() + " " + utente.getNome());
        cognome.setText(cognome.getText() + " " + utente.getCognome());
        dataNascita.setText(dataNascita.getText() + " " + DateConverter.toString(utente.getDataDiNascita()));
    }

    public void switchToHelloView(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void switchTosettimanale(ActionEvent event) throws IOException {
        super.switchTosettimanale(event);
    }

    @Override
    public void switchToHome(ActionEvent e) throws IOException {
        super.switchToHome(e);
    }

    @Override
    public void switchToAreaUtente(ActionEvent e) throws IOException {
        super.switchToAreaUtente(e);
    }

    @Override
    public void switchToListaCalendari(ActionEvent e) throws IOException {
        super.switchToListaCalendari(e);
    }

    @Override
    public void switchToRicerca(ActionEvent e) throws IOException {
        super.switchToRicerca(e);
    }
    @Override
    public void switchToAggiuntaEvento (ActionEvent e) throws IOException
    {
        super.switchToAggiuntaEvento(e);
    }




}
