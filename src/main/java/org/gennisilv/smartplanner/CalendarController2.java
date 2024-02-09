package org.gennisilv.smartplanner;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class CalendarController2 {

    @FXML
    private DatePicker datePicker=new DatePicker();

    @FXML
    private GridPane calendarGrid=new GridPane();

    @FXML
    private VBox eventLayout;

    @FXML
    private TextField eventTextField;

    private Map<LocalDate, List<String>> eventMap = new HashMap<>();

    @FXML
    private void initialize() {
        datePicker.setOnAction(event -> handleDaySelection(datePicker.getValue()));
        LocalDate selectedDate = LocalDate.now();
        DayOfWeek firstDayOfWeek = DayOfWeek.MONDAY;
        for (int i = 0; i < 7; i++) {
            LocalDate currentDay = selectedDate.with(firstDayOfWeek).plusDays(i);
            Button dayButton = new Button(currentDay.getDayOfWeek().getDisplayName(TextStyle.SHORT, Locale.getDefault()));
            final int dayIndex = i;
            dayButton.setOnAction(event -> handleDaySelection(datePicker.getValue().with(DayOfWeek.MONDAY).plusDays(dayIndex)));
            calendarGrid.add(dayButton, i, 0);
        }
    }

    private void handleDaySelection(LocalDate selectedDate) {
        System.out.println("Data selezionata: " + selectedDate);
        List<String> eventDescriptions = eventMap.get(selectedDate);
        updateEventLayout(eventDescriptions);
    }

    private void updateEventLayout(List<String> eventDescriptions) {
        eventLayout.getChildren().clear();
        if (eventDescriptions != null) {
            for (String description : eventDescriptions) {
                Label eventLabel = new Label(description);
                eventLayout.getChildren().add(eventLabel);
            }
        }
    }

    @FXML
    private void handleAddEvent() {
        LocalDate selectedDate = datePicker.getValue();
        String eventDescription = eventTextField.getText();
        List<String> eventDescriptions = eventMap.get(selectedDate);
        if (eventDescriptions == null) {
            eventDescriptions = new ArrayList<>();
            eventMap.put(selectedDate, eventDescriptions);
        }
        eventDescriptions.add(eventDescription);
        updateEventLayout(eventDescriptions);
        System.out.println("Evento aggiunto per la data " + selectedDate + ": " + eventDescription);
    }
}