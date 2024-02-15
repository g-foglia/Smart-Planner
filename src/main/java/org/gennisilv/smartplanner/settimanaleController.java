package org.gennisilv.smartplanner;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;
import org.gennisilv.smartplanner.data.entity.Evento;
import org.gennisilv.smartplanner.logic.CalendarioLogic;
import org.gennisilv.smartplanner.utils.DataHolder;
import org.gennisilv.smartplanner.utils.DateConverter;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;


public final class settimanaleController extends barraController{
    private Stage stage;
    private Scene scene;
    @FXML
    private GridPane calendarGrid;
    @FXML
    private Polygon giorni;
    @FXML
    private DatePicker data;
    private Map<LocalDate, Map<LocalTime, Evento>> eventi = new HashMap<>();
    private boolean check = true;

    public void initialize() {
        ArrayList<Evento> eventiCalendario = CalendarioLogic.getEventi(DataHolder.getIstanza().getInteger());
        //creo la mappa contenente tutti gli eventi del calendario, la loro data e gli orari che occupano nella giornata
        if(!eventiCalendario.isEmpty()) {
            for (Evento evento : eventiCalendario) {
                LocalDate dataEvento = DateConverter.toLocalDate(evento.getDataEvento());
                String oraInizio = evento.getOrarioInizio();
                String oraFine = evento.getOrarioFine();
                LocalTime inizio = LocalTime.of(Integer.parseInt(oraInizio.substring(0, 2)), Integer.parseInt(oraInizio.substring(3)));
                LocalTime fine = LocalTime.of(Integer.parseInt(oraFine.substring(0, 2)), Integer.parseInt(oraFine.substring(3)));
                Map<LocalTime, Evento> distribuzioneEvento = new HashMap<>();

                for (LocalTime time = inizio; time.isBefore(fine); time = time.plusHours(1)) {
                    distribuzioneEvento.put(time, evento);
                }
                eventi.put(dataEvento, distribuzioneEvento);
            }

            for (int i = 0; i < 24; i++) {
                Label timeLabel = new Label(String.format("%02d:00", i));
                calendarGrid.add(timeLabel, 0, i + 1);
            }
        }
        else{
            Alert alert = new Alert(Alert.AlertType.INFORMATION,"Calendario vuoto");
            alert.showAndWait();
        }
        if(check) {
            LocalDate oggi = LocalDate.now();
            data.setValue(oggi);
            DayOfWeek giorno = oggi.getDayOfWeek();

            switch (giorno){
                case MONDAY -> giorni.setTranslateX(0);
                case TUESDAY -> giorni.setTranslateX(35);
                case WEDNESDAY -> giorni.setTranslateX(73);
                case THURSDAY -> giorni.setTranslateX(108);
                case FRIDAY -> giorni.setTranslateX(143);
                case SATURDAY -> giorni.setTranslateX(178);
                case SUNDAY -> giorni.setTranslateX(214);
            }
            check = false;
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

    public void switchToDettagliEvento(ActionEvent e) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("dettagliEvento.fxml"));
        stage= (Stage) ((Node)e.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void lunedi(ActionEvent e) throws IOException{
        giorni.setTranslateX(0);
        calendarGrid.getChildren().clear();
        initialize();
        LocalDate dataOdierna = data.getValue().with(DayOfWeek.MONDAY);
        Map<LocalTime, Evento> eventiGiorno = eventi.get(dataOdierna);
        if(eventiGiorno != null){
            for(LocalTime inizio : eventiGiorno.keySet()){
                Evento evento = eventiGiorno.get(inizio);
                Button button = new Button(evento.getNomeEvento());
                button.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        DataHolder.getIstanza().setInteger(evento.getCodiceEvento());
                        try {
                            switchToDettagliEvento(actionEvent);
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                });
                int riga = inizio.getHour() + 1;
                calendarGrid.add(button,1,riga);
            }
        }
        data.setValue(dataOdierna);
    }
    public void martedi(ActionEvent e) throws IOException{
        giorni.setTranslateX(35);
        calendarGrid.getChildren().clear();
        initialize();
        LocalDate dataOdierna = data.getValue().with(DayOfWeek.TUESDAY);
        Map<LocalTime, Evento> eventiGiorno = eventi.get(dataOdierna);
        if(eventiGiorno != null){
            for(LocalTime inizio : eventiGiorno.keySet()){
                Evento evento = eventiGiorno.get(inizio);
                Button button = new Button(evento.getNomeEvento());
                button.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        DataHolder.getIstanza().setInteger(evento.getCodiceEvento());
                        try {
                            switchToDettagliEvento(actionEvent);
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                });
                int riga = inizio.getHour() + 1;
                calendarGrid.add(button,2,riga);
            }
        }
        data.setValue(dataOdierna);
    }
    public void mercoledi(ActionEvent e) throws IOException{
        giorni.setTranslateX(73);
        calendarGrid.getChildren().clear();
        initialize();
        LocalDate dataOdierna = data.getValue().with(DayOfWeek.WEDNESDAY);
        Map<LocalTime, Evento> eventiGiorno = eventi.get(dataOdierna);
        if(eventiGiorno != null){
            for(LocalTime inizio : eventiGiorno.keySet()){
                Evento evento = eventiGiorno.get(inizio);
                Button button = new Button(evento.getNomeEvento());
                button.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        DataHolder.getIstanza().setInteger(evento.getCodiceEvento());
                        try {
                            switchToDettagliEvento(actionEvent);
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                });
                int riga = inizio.getHour() + 1;
                calendarGrid.add(button,3,riga);
            }
        }
        data.setValue(dataOdierna);
    }
    public void giovedi(ActionEvent e) throws IOException{
        giorni.setTranslateX(108);
        calendarGrid.getChildren().clear();
        initialize();
        LocalDate dataOdierna = data.getValue().with(DayOfWeek.THURSDAY);
        Map<LocalTime, Evento> eventiGiorno = eventi.get(dataOdierna);
        if(eventiGiorno != null){
            for(LocalTime inizio : eventiGiorno.keySet()){
                Evento evento = eventiGiorno.get(inizio);
                Button button = new Button(evento.getNomeEvento());
                button.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        DataHolder.getIstanza().setInteger(evento.getCodiceEvento());
                        try {
                            switchToDettagliEvento(actionEvent);
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                });
                int riga = inizio.getHour() + 1;
                calendarGrid.add(button,4,riga);
            }
        }
        data.setValue(dataOdierna);
    }
    public void venerdi(ActionEvent e) throws IOException{
        giorni.setTranslateX(143);
        calendarGrid.getChildren().clear();
        initialize();
        LocalDate dataOdierna = data.getValue().with(DayOfWeek.FRIDAY);
        Map<LocalTime, Evento> eventiGiorno = eventi.get(dataOdierna);
        if(eventiGiorno != null){
            for(LocalTime inizio : eventiGiorno.keySet()){
                Evento evento = eventiGiorno.get(inizio);
                Button button = new Button(evento.getNomeEvento());
                button.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        DataHolder.getIstanza().setInteger(evento.getCodiceEvento());
                        try {
                            switchToDettagliEvento(actionEvent);
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                });
                int riga = inizio.getHour() + 1;
                calendarGrid.add(button,5,riga);
            }
        }
        data.setValue(dataOdierna);
    }
    public void sabato(ActionEvent e) throws IOException{
        giorni.setTranslateX(178);
        calendarGrid.getChildren().clear();
        initialize();
        LocalDate dataOdierna = data.getValue().with(DayOfWeek.SATURDAY);
        Map<LocalTime, Evento> eventiGiorno = eventi.get(dataOdierna);
        if(eventiGiorno != null){
            for(LocalTime inizio : eventiGiorno.keySet()){
                Evento evento = eventiGiorno.get(inizio);
                Button button = new Button(evento.getNomeEvento());
                button.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        DataHolder.getIstanza().setInteger(evento.getCodiceEvento());
                        try {
                            switchToDettagliEvento(actionEvent);
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                });
                int riga = inizio.getHour() + 1;
                calendarGrid.add(button,6,riga);
            }
        }
        data.setValue(dataOdierna);
    }
    public void domenica(ActionEvent e) throws IOException{
        giorni.setTranslateX(214);
        calendarGrid.getChildren().clear();
        initialize();
        LocalDate dataOdierna = data.getValue().with(DayOfWeek.SUNDAY);
        Map<LocalTime, Evento> eventiGiorno = eventi.get(dataOdierna);
        if(eventiGiorno != null){
            for(LocalTime inizio : eventiGiorno.keySet()){
                Evento evento = eventiGiorno.get(inizio);
                Button button = new Button(evento.getNomeEvento());
                button.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        DataHolder.getIstanza().setInteger(evento.getCodiceEvento());
                        try {
                            switchToDettagliEvento(actionEvent);
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                });
                int riga = inizio.getHour() + 1;
                calendarGrid.add(button,7,riga);
            }
        }
        data.setValue(dataOdierna);
    }

    public void handleDaySelection(ActionEvent e){
        calendarGrid.getChildren().clear();
        LocalDate selectedDate = data.getValue();
        initialize();
        Map<LocalTime, Evento> mappaEventi = eventi.get(selectedDate);
        updateLayout(mappaEventi, selectedDate.getDayOfWeek());
    }

    private void updateLayout(Map<LocalTime, Evento> mappaEventi, DayOfWeek day){
        int i = 1;
        switch (day){
            case MONDAY -> {giorni.setTranslateX(0); i = 1;}
            case TUESDAY -> {giorni.setTranslateX(35); i = 2;}
            case WEDNESDAY -> {giorni.setTranslateX(73); i = 3;}
            case THURSDAY -> {giorni.setTranslateX(108); i = 4;}
            case FRIDAY -> {giorni.setTranslateX(143); i = 5;}
            case SATURDAY -> {giorni.setTranslateX(178); i = 6;}
            case SUNDAY -> {giorni.setTranslateX(214); i = 7;}
        }
        if(mappaEventi != null){
            for(LocalTime inizio : mappaEventi.keySet()){
                Evento evento = mappaEventi.get(inizio);
                Button button = new Button(evento.getNomeEvento());
                button.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        DataHolder.getIstanza().setInteger(evento.getCodiceEvento());
                        try {
                            switchToDettagliEvento(actionEvent);
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                });
                int riga = inizio.getHour() + 1;
                calendarGrid.add(button,i,riga);
            }
        }
        else{
            calendarGrid.getChildren().clear();
            for (i = 0; i < 24; i++) {
                Label timeLabel = new Label(String.format("%02d:00", i));
                calendarGrid.add(timeLabel, 0, i + 1);
            }
        }
    }

}


