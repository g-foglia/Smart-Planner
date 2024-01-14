package org.gennisilv.smartplanner;

import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class inserimentoEventoController extends barraController{
    private Stage stage;
    private Scene scene;
    private Parent root;


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
