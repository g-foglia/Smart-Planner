package org.gennisilv.smartplanner;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.gennisilv.smartplanner.data.Evento;
import org.gennisilv.smartplanner.data.EventoDAO;
import org.gennisilv.smartplanner.data.UtenteDAO;

import java.io.IOException;
import java.util.List;

public final class ricercaEventiController extends barraController{
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private TextField ricerca;

    public void ricerca (ActionEvent e) throws IOException
    {
        Evento evento;
        String eventoRicercarto=ricerca.getText();
        //EventoDAO.doRetrieveEventsByName(eventoRicercarto);
        List<Evento> eventi=EventoDAO.doRetrieveEventsByName(eventoRicercarto);
        /*for (eventi)
        {}*/ //STAMPA
    }
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
    public void switchToAggiuntaEvento (ActionEvent e) throws IOException
    {
        super.switchToAggiuntaEvento(e);
    }
}
