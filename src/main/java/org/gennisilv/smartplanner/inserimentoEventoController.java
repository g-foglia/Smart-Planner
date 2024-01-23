package org.gennisilv.smartplanner;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import org.gennisilv.smartplanner.data.Calendario;
import org.gennisilv.smartplanner.data.CalendarioDAO;
import org.gennisilv.smartplanner.data.Evento;
import org.gennisilv.smartplanner.data.EventoDAO;
import org.gennisilv.smartplanner.utils.UserHolder;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.ResourceBundle;

public class inserimentoEventoController extends barraController implements Initializable {
    private Stage stage;
    private Scene scene;

    @FXML
    private TextField nomeEvento;
    @FXML
    private TextArea descrizioneEvento;
    @FXML
    private DatePicker dataEvento;
    @FXML
    private TextField oraInizio;
    @FXML
    private TextField oraFine;
    @FXML
    private ChoiceBox<String> periodicitaID;
    @FXML
    private ColorPicker colore;
    @FXML
    private RadioButton notifiche;
    @FXML
    private ComboBox calendari;

    private String[] periodicita = {"0 - solo 1 volta;", "1 - 1 volta al giorno;", "2 - 1 volta a settimana;", "3 - 1 volta al mese;"};

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ArrayList<Calendario> lista = CalendarioDAO.doRetrieveByUtente(UserHolder.getIstanza().getUtente().getEmail());
        ArrayList<String> nomi = new ArrayList<>();

        for(Calendario calendario : lista)
            nomi.add(calendario.getNomeCalendario());

        calendari.getItems().addAll(nomi);
        periodicitaID.getItems().addAll(periodicita);
    }


    public void inserisciEvento(ActionEvent e) throws IOException {
        Evento evento = new Evento();
        evento.setNomeEvento(nomeEvento.getText());
        evento.setDescrizione(descrizioneEvento.getText());
        evento.setDataEvento(new GregorianCalendar(dataEvento.getValue().getYear(),dataEvento.getValue().getMonthValue()-1,dataEvento.getValue().getDayOfMonth()));
        evento.setOrarioInizio(oraInizio.getText());
        evento.setOrarioFine(oraFine.getText());
        evento.setColoreEvento(toHexString(colore.getValue()));
        evento.setNotifiche(notifiche.isSelected());
        switch (periodicitaID.getValue()){
            case "0 - solo 1 volta;":
                evento.setPeriodicita(0);
            case "1 - 1 volta al giorno;":
                evento.setPeriodicita(1);
            case "2 - 1 volta a settimana;":
                evento.setPeriodicita(2);
            case "3 - 1 volta al mese;":
                evento.setPeriodicita(3);
        }

        EventoDAO.doSaveEvento(evento);
        Calendario calendario = CalendarioDAO.doRetrieveByNome((String) calendari.getValue(),UserHolder.getIstanza().getUtente().getEmail());
        CalendarioDAO.doAddEvento(evento.getCodiceEvento(), calendario.getCodiceCalendario());

        switchTosettimanale(e);
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
