package org.gennisilv.smartplanner;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;
import java.io.IOException;
import com.calendarfx.view.AgendaView;

public final class settimanaleController extends barraController{
    private Stage stage;
    private Scene scene;
    @FXML
    private GridPane calendarGrid;
    @FXML
    private Polygon giorni;

    public void initialize()
    {
        for (int i = 0; i < 24; i++) {
            Label timeLabel = new Label(String.format("%02d:00", i));
            calendarGrid.add(timeLabel, 0, i + 1);
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
    public void lunedi(ActionEvent e) throws IOException{
    giorni.setTranslateX(0);
    }
    public void martedi(ActionEvent e) throws IOException{
        giorni.setTranslateX(35);
    }
    public void mercoledi(ActionEvent e) throws IOException{
        giorni.setTranslateX(73);
    }
    public void giovedi(ActionEvent e) throws IOException{
        giorni.setTranslateX(108);
    }
    public void venerdi(ActionEvent e) throws IOException{
        giorni.setTranslateX(143);
    }
    public void sabato(ActionEvent e) throws IOException{
        giorni.setTranslateX(178);
    }
    public void domenica(ActionEvent e) throws IOException{
        giorni.setTranslateX(214);
    }
    }


