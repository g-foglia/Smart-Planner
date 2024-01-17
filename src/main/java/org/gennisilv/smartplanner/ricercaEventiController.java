package org.gennisilv.smartplanner;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
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
    @FXML
    private TextField evento;
    @FXML
    private Button ricerca;
    @FXML
    private TextArea risultati;

    public void ricerca (ActionEvent e) throws IOException
    {
        List<Evento> eventi = EventoDAO.doRetrieveEventsByName(evento.getText());

        if(eventi.isEmpty()){
            risultati.setText("Nessun evento trovato");
        }
        else{
            for(Evento evento : eventi)
                risultati.setText(evento.getNomeEvento() + "\n");
        }

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
