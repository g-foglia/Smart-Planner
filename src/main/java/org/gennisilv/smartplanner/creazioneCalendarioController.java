package org.gennisilv.smartplanner;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import org.gennisilv.smartplanner.logic.CalendarioLogic;
import org.gennisilv.smartplanner.utils.DataHolder;

import java.io.IOException;

public class creazioneCalendarioController extends barraController{
    private Stage stage;
    private Scene scene;

    @FXML
    private TextField nomeC;
    @FXML
    private ColorPicker colore;

    public void creaCalendario(ActionEvent e) throws IOException {
        Color color = colore.getValue();
        String nome = nomeC.getText();

        int codicecCalendario = CalendarioLogic.creaCalendario(nome,color);
        DataHolder.getIstanza().setInteger(codicecCalendario);
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
    public void switchToCreazioneCalendario(ActionEvent e) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("creazioneCalendario.fxml"));
        stage= (Stage) ((Node)e.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
