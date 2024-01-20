package org.gennisilv.smartplanner;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import org.gennisilv.smartplanner.data.Evento;
import org.gennisilv.smartplanner.data.EventoDAO;
import org.gennisilv.smartplanner.data.Utente;
import org.gennisilv.smartplanner.data.UtenteDAO;
import org.gennisilv.smartplanner.utils.UserHolder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public final class ricercaEventiController extends barraController{
    private Stage stage;
    private Scene scene;
    @FXML
    private TextField evento;
    @FXML
    private FlowPane risultati;

    public void ricerca (ActionEvent e) throws IOException
    {
        Utente utente = UserHolder.getIstanza().getUtente();
        ArrayList<Evento> eventi = EventoDAO.doRetrieveEventsByName(evento.getText(), utente.getEmail());

        if(!eventi.isEmpty()){
            ArrayList<Button> bottoni = new ArrayList<>();
            for(Evento evento : eventi) {
                Button button = new Button(evento.getNomeEvento());
                button.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        //temporaneo
                        try {
                            switchToHome(e);
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                        //switch alla pagina che mostra un evento con passaggio del nome dell'evento
                    }
                });

                bottoni.add(button);
            }
            boolean util = risultati.getChildren().addAll(bottoni);
        }
        else{
            Alert alert = new Alert(Alert.AlertType.INFORMATION,"Nessun evento trovato");
            alert.showAndWait();
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
