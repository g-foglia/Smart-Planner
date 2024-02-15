package org.gennisilv.smartplanner;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.TextStyle;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class CalendarController {
    @FXML
    private DatePicker datePicker;
    @FXML
    private GridPane calendarGrid;
    @FXML
    private TextField eventTextField;
    @FXML
    private ComboBox<Integer> startHourComboBox;
    @FXML
    private ComboBox<Integer> endHourComboBox;
    @FXML
    private VBox eventLayout;

    // Mappa per memorizzare gli eventi associati a ciascuna data e ora
    private Map<LocalDate, Map<LocalTime, List<String>>> eventMap = new HashMap<>();

    @FXML
    private void initialize() {
        // Aggiungi le ore alla ComboBox
        ObservableList<Integer> hours = FXCollections.observableArrayList();
        for (int i = 0; i < 24; i++) {
            hours.add(i);
        }
        startHourComboBox.setItems(hours);
        endHourComboBox.setItems(hours);

        // Aggiungi una colonna sulla sinistra per gli orari
        for (int i = 0; i < 24; i++) {
            Label timeLabel = new Label(String.format("%02d:00", i));
            calendarGrid.add(timeLabel, 0, i + 1);
        }
        datePicker.setOnAction(event->handleDaySelection(datePicker.getValue()));
        LocalDate selectedDate= LocalDate.now();
        DayOfWeek firstDayOfTheWeek=DayOfWeek.MONDAY;
        for (int i = 0; i < 7; i++) {
            LocalDate currentDay = selectedDate.with(firstDayOfTheWeek).plusDays(i);
            Button dayButton = new Button(currentDay.getDayOfWeek().getDisplayName(TextStyle.SHORT, Locale.getDefault()));
            final int dayIndex = i; // Utilizziamo una variabile finale per l'indice del giorno
           // dayButton.setOnAction(event->handleDaySelection(datePicker.getValue().with(DayOfWeek.MONDAY).plusDays(dayIndex)));
            dayButton.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    calendarGrid.getChildren().clear();
                    initialize();
                    Map<LocalTime, List<String>> eventsForDate = eventMap.get(datePicker.getValue().with(DayOfWeek.MONDAY).plusDays(dayIndex));
                   if(eventsForDate!=null){
                    for (LocalTime startTime : eventsForDate.keySet()) {
                        List<String> events = eventsForDate.get(startTime);
                        for (String event : events) {
                            // Aggiungi un label per ogni evento
                            Label eventLabel = new Label(event);
                            int row = startTime.getHour() + 1;
                            calendarGrid.add(eventLabel, eventsForDate.size() + 1, row);
                        }
                    }}
                }
            });
        calendarGrid.add(dayButton,i,0);
        }

    }

    // Metodo per gestire la selezione di un giorno
    private void handleDaySelection(LocalDate selectedDate) {
        calendarGrid.getChildren().clear(); // Pulisci il layout degli eventi
        initialize();
        Map <LocalTime,List <String>> eventMaps= eventMap.get(selectedDate);
       updateEventLayout(eventMaps);
    }
private void updateEventLayout(Map <LocalTime,List <String>> eventMap)
{
    if (eventMap!=null) {
        LocalDate selectedDate = datePicker.getValue();
       // eventLayout.getChildren().clear(); // Pulisci il layout degli eventi
        // Verifica se la data selezionata è presente nella mappa degli eventi
        if (eventMap.containsKey(selectedDate)) {
            // Ottieni la mappa degli eventi per la data selezionata
            Map<LocalTime, List<String>> eventsForDate = (Map<LocalTime, List<String>>) eventMap.get(selectedDate);
            for (LocalTime startTime : eventsForDate.keySet()) {
                List<String> events = eventsForDate.get(startTime);
                for (String event : events) {
                    // Aggiungi un label per ogni evento
                    Label eventLabel = new Label(event);
                    int row = startTime.getHour() + 1;
                    calendarGrid.add(eventLabel, eventsForDate.size() + 1, row);
                }
            }
        }
    }

}

    // Metodo per aggiungere un evento
    @FXML
    private void addEvent() {
        LocalDate selectedDate = datePicker.getValue();
        String eventName = eventTextField.getText();
        Integer startHour = startHourComboBox.getValue();
        Integer endHour = endHourComboBox.getValue();
       // List<String> events= (List<String>) eventMap.get(selectedDate);
       if (selectedDate != null && eventName != null && startHour != null && endHour != null) {
            LocalTime startTime = LocalTime.of(startHour, 0);
            LocalTime endTime = LocalTime.of(endHour, 0);

            // Ottieni la mappa degli eventi per la data selezionata
            Map<LocalTime, List<String>> eventsForDate = eventMap.computeIfAbsent(selectedDate, k -> new HashMap<>());

            // Aggiungi l'evento per ogni ora tra l'ora di inizio e l'ora di fine
            for (LocalTime time = startTime; time.isBefore(endTime); time = time.plusHours(1)) {
                eventsForDate.computeIfAbsent(time, k -> new ArrayList<>()).add(eventName);
            }
            eventMap.put(selectedDate,eventsForDate);
           handleDaySelection(selectedDate);
            // Aggiorna la visualizzazione degli eventi solo se la data selezionata è quella corrente
           /* if (selectedDate.equals(datePicker.getValue())) {
                handleDaySelection(selectedDate);
            }*/
        }

           // events.add(eventName);
            // updateEventLayout(events);
            System.out.println("Evento aggiunto " + selectedDate + ":" + eventName);


    }
}
