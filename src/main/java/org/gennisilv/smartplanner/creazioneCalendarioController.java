package org.gennisilv.smartplanner;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import org.gennisilv.smartplanner.data.Calendario;
import org.gennisilv.smartplanner.data.CalendarioDAO;
import org.gennisilv.smartplanner.data.Utente;
import org.gennisilv.smartplanner.utils.UserHolder;

import java.io.IOException;

public class creazioneCalendarioController extends barraController{
    private Stage stage;
    private Scene scene;

    @FXML
    private Label nome;
    @FXML
    private ColorPicker colore;

    public void creaCalendario(ActionEvent e){
        Calendario calendario = new Calendario(".a.a.a.a",nome.getText(),toHexString(colore.getValue()));

        CalendarioDAO.doSaveCalendario(calendario, UserHolder.getIstanza().getUtente().getEmail());
        //switch alla pagina del calendario
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
    public void switchToAggiuntaEvento (ActionEvent e) throws IOException
    {
        super.switchToAggiuntaEvento(e);
    }

    //due metodi per la conversione dell'oggetto Color in una stringa esadecimale.
    //NON funzionano per TUTTI i colori possibili, ma sono abbastanza affidabili
    private String format(double val) {
        String in = Integer.toHexString((int) Math.round(val * 255));
        return in.length() == 1 ? "0" + in : in;
    }

    public String toHexString(Color value) {
        return "#" + (format(value.getRed()) + format(value.getGreen()) + format(value.getBlue()) + format(value.getOpacity()))
                .toUpperCase();
    }

}
