package org.gennisilv.smartplanner;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import org.gennisilv.smartplanner.data.entity.Impegno;
import org.gennisilv.smartplanner.logic.ListaLogic;
import org.gennisilv.smartplanner.utils.DataHolder;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class dettagliImpegnoController extends barraController implements Initializable {
    @FXML
    private Label nome;
    @FXML
    private Label durata;
    @FXML
    private Label priorita;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Impegno impegno = ListaLogic.getImpegno(DataHolder.getIstanza().getInteger());

        nome.setText(nome.getText() + " " + impegno.getNomeImpegno());
        durata.setText(durata.getText() + " " + impegno.getDurataImpegno());
        priorita.setText(priorita.getText() + " " + impegno.getPrioritaImpegno());
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

