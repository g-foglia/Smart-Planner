package org.gennisilv.smartplanner;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import org.gennisilv.smartplanner.data.Calendario;
import org.gennisilv.smartplanner.logic.CalendarioLogic;
import org.gennisilv.smartplanner.logic.EventoLogic;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

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
    private ChoiceBox<String> periodicitaID;
    @FXML
    private ColorPicker colore;
    @FXML
    private RadioButton notifiche;
    @FXML
    private ComboBox calendari;
    @FXML
    private ComboBox oreInizio;
    @FXML
    private ComboBox minutiInizio;
    @FXML
    private ComboBox oreFine;
    @FXML
    private ComboBox minutiFine;

    private final String[] periodicita = {"solo 1 volta", "1 volta al giorno", "1 volta a settimana", "1 volta al mese"};
    private final String[] orari = {"00","01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23"};
    private final String[] frazioni = {"00","05","10","15","20","25","30","35","40","45","50","55"};

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ArrayList<Calendario> lista = CalendarioLogic.returnCalendari();
        ArrayList<String> nomi = new ArrayList<>();

        for(Calendario calendario : lista)
            nomi.add(calendario.getNomeCalendario());

        calendari.getItems().addAll(nomi);
        periodicitaID.getItems().addAll(periodicita);
        oreInizio.getItems().addAll(orari);
        minutiInizio.getItems().addAll(frazioni);
        oreFine.getItems().addAll(orari);
        minutiFine.getItems().addAll(frazioni);
    }


    public void inserisciEvento(ActionEvent e) throws IOException {
        String nome = nomeEvento.getText();
        String descrizione = descrizioneEvento.getText();
        GregorianCalendar dataEvento = new GregorianCalendar(this.dataEvento.getValue().getYear(), this.dataEvento.getValue().getMonthValue()-1, this.dataEvento.getValue().getDayOfMonth());
        String oraI = oreInizio.getValue() + ":" + minutiInizio.getValue();
        String oraF = oreFine.getValue() + ":" + minutiFine.getValue();
        Color color = colore.getValue();
        boolean n = notifiche.isSelected();

        int periodicita = -1;
        switch (periodicitaID.getValue()){
            case "solo 1 volta":
                periodicita = 0;
            case "1 volta al giorno":
                periodicita = 1;
            case "1 volta a settimana":
                periodicita = 2;
            case "1 volta al mese":
                periodicita = 3;
        }

        /*
            CONTROLLI SUI CAMPI
         */

        if(!checkName(nome))
            if(lunghezza(descrizione))
                    if(!date(dataEvento))
                        if(checkTimeE(oraI,oraF)){
                            int codiceEvento = EventoLogic.aggiungiEvento(nome,descrizione,dataEvento,oraI,oraF,color,n,periodicita);
                            Calendario calendario = CalendarioLogic.cercaCalendario((String) calendari.getValue());
                            CalendarioLogic.aggiungiEvento(codiceEvento, calendario.getCodiceCalendario());

                            switchTosettimanale(e);
                        }
                        else{
                                //orario di fine antecedente alla orario di inizio
                                Alert alert = new Alert(Alert.AlertType.INFORMATION,"Gli orari di inizio e fine dell'evento non possono essere incrociati");
                                alert.showAndWait();
                        }
                    else{
                        //data dell'evento appartenente al passato
                        Alert alert = new Alert(Alert.AlertType.INFORMATION,"Non puoi creare eventi in giorni passati");
                        alert.showAndWait();
                    }
            else{
                    //descrizione troppo lunga
                    Alert alert = new Alert(Alert.AlertType.INFORMATION,"La descrizione dell'evento non può superare i 200 caratteri");
                    alert.showAndWait();
            }
        else{
            //nome che contiene caratteri speciali
            Alert alert = new Alert(Alert.AlertType.INFORMATION,"Il nome non può contenere caratteri speciali");
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
    public void switchToAggiuntaEvento (ActionEvent e) throws IOException
    {
        super.switchToAggiuntaEvento(e);
    }

    private boolean checkName(String nome){
        return Pattern.compile("[^a-zA-Z0-9]").matcher(nome).find();
    }

    private boolean lunghezza(String descrizione){
        if(descrizione.length() > 200)
            return false;
        return true;
    }

    //non funziona
    private boolean date(GregorianCalendar data){
        GregorianCalendar dataAttuale = new GregorianCalendar();

        return data.before(dataAttuale);
    }

    private boolean checkTimeE(String oraI, String oraF){
        int oraInizio = Integer.parseInt(oraI.substring(0,2));
        int oraFine = Integer.parseInt(oraF.substring(0,2));

        if(oraFine < oraInizio)
            return false;
        else if(oraFine == oraInizio){
            int minutiInizio = Integer.parseInt(oraI.substring(3));
            int minutiFine = Integer.parseInt(oraF.substring(3));

            if(minutiFine < minutiInizio)
                return false;
        }
        return true;
    }
}
