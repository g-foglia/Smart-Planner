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
import org.gennisilv.smartplanner.logic.CalendarioLogic;
import org.gennisilv.smartplanner.logic.EventoLogic;
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
        ArrayList<Calendario> lista = CalendarioLogic.returnCalendari();
        ArrayList<String> nomi = new ArrayList<>();

        for(Calendario calendario : lista)
            nomi.add(calendario.getNomeCalendario());

        calendari.getItems().addAll(nomi);
        periodicitaID.getItems().addAll(periodicita);
    }


    public void inserisciEvento(ActionEvent e) throws IOException {
        String nome = nomeEvento.getText();
        String descrizione = descrizioneEvento.getText();
        GregorianCalendar date = new GregorianCalendar(dataEvento.getValue().getYear(),dataEvento.getValue().getMonthValue()-1,dataEvento.getValue().getDayOfMonth());
        String oraI = oraInizio.getText();
        String oraF = oraFine.getText();
        Color color = colore.getValue();
        boolean n = notifiche.isSelected();

        int periodicita = -1;
        switch (periodicitaID.getValue()){
            case "0 - solo 1 volta;":
                periodicita = 0;
            case "1 - 1 volta al giorno;":
                periodicita = 1;
            case "2 - 1 volta a settimana;":
                periodicita = 2;
            case "3 - 1 volta al mese;":
                periodicita = 3;
        }
        int codiceEvento = EventoLogic.aggiungiEvento(nome,descrizione,date,oraI,oraF,color,n,periodicita);

        Calendario calendario = CalendarioLogic.cercaCalendario((String) calendari.getValue());
        CalendarioLogic.aggiungiEvento(codiceEvento, calendario.getCodiceCalendario());

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
}
