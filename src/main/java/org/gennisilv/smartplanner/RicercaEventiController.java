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
import org.gennisilv.smartplanner.data.entity.Evento;
import org.gennisilv.smartplanner.data.entity.Utente;
import org.gennisilv.smartplanner.logic.EventoLogic;
import org.gennisilv.smartplanner.logic.UtenteLogic;
import org.gennisilv.smartplanner.utils.DataHolder;

import java.io.IOException;
import java.util.ArrayList;

public final class RicercaEventiController extends BarraController {
    private Stage stage;
    private Scene scene;
    @FXML
    private TextField evento;
    @FXML
    private FlowPane risultati;

    public void ricerca (ActionEvent e) throws IOException
    {
        Utente utente = UtenteLogic.returnLoggedInUser();
        ArrayList<Evento> eventi = EventoLogic.ricercaEvento(evento.getText(), utente.getEmail());

        if(!eventi.isEmpty()){
            ArrayList<Button> bottoni = new ArrayList<>();
            for(Evento evento : eventi) {
                Button button = new Button(evento.getNomeEvento());
                button.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        DataHolder.getIstanza().setInteger(evento.getCodiceEvento());
                        try {
                            switchToDettagliEvento(e);
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
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
    public void switchToDettagliEvento(ActionEvent e) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("dettagliEvento.fxml"));
        stage= (Stage) ((Node)e.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
