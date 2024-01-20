package org.gennisilv.smartplanner;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.gennisilv.smartplanner.data.Calendario;
import org.gennisilv.smartplanner.data.CalendarioDAO;
import org.gennisilv.smartplanner.data.Utente;
import org.gennisilv.smartplanner.utils.UserHolder;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class listaCalendariController extends barraController implements Initializable {
    private Stage stage;
    private Scene scene;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ArrayList<Calendario> calendari = CalendarioDAO.doRetrieveByUtente(UserHolder.getIstanza().getUtente().getEmail());

        /*
        stampa delle informazioni come nella lista di eventi cercati, con un bottone che faccia selezionare il calendario
         */
    }

    public void switchTosettimanale(ActionEvent e) throws IOException {
        super.switchTosettimanale(e);
    }
    public void switchToHome (ActionEvent e) throws IOException
    {
        super.switchToHome(e);
    }
    public void switchToAreaUtente (ActionEvent e) throws IOException
    {
        super.switchToAreaUtente(e);
    }
    public void switchToListaCalendari (ActionEvent e) throws IOException
    {
        super.switchToListaCalendari(e);
    }
    public void switchToAggiuntaEvento (ActionEvent e) throws IOException
    {
        super.switchToAggiuntaEvento(e);
    }
    public void switchToRicerca (ActionEvent e) throws IOException
    {
        super.switchToRicerca(e);
    }


}
