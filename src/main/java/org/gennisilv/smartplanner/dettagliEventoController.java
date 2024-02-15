package org.gennisilv.smartplanner;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import org.gennisilv.smartplanner.data.entity.Evento;
import org.gennisilv.smartplanner.logic.EventoLogic;
import org.gennisilv.smartplanner.utils.DataHolder;
import org.gennisilv.smartplanner.utils.DateConverter;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class dettagliEventoController extends barraController implements Initializable {
    @FXML
    private Label nome;
    @FXML
    private Label descrizione;
    @FXML
    private Label inizio;
    @FXML
    private Label fine;
    @FXML
    private Label data;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Evento evento = EventoLogic.getEvento(DataHolder.getIstanza().getInteger());

        nome.setText(nome.getText() + " " + evento.getNomeEvento());
        descrizione.setText(descrizione.getText() + " " + evento.getDescrizione());
        inizio.setText(inizio.getText() + " " + evento.getOrarioInizio());
        fine.setText(fine.getText() + " " + evento.getOrarioFine());
        data.setText(data.getText() + " " + DateConverter.toString(evento.getDataEvento()));
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
