package org.gennisilv.smartplanner;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import org.gennisilv.smartplanner.data.entity.Calendario;
import org.gennisilv.smartplanner.logic.CalendarioLogic;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;


public class HomeController extends barraController implements Initializable {

    private Stage stage;
    private Scene scene;

    @FXML
    private GridPane calendarioHome;
    @FXML
    private Button aggCalendario;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ArrayList<Calendario> calendari = CalendarioLogic.returnCalendari();
        if(calendari.isEmpty()){
            calendarioHome.setVisible(false);
            //altre cose
        }
        else{
            //stampa di altre cose
        }

    }

    public void switchToinserimentoImpegno (ActionEvent e) throws IOException
    {
        Parent root = FXMLLoader.load(getClass().getResource("inserimentoImpegno.fxml"));
        stage= (Stage) ((Node)e.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToCreazioneCalendario(ActionEvent e) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("creazioneCalendario.fxml"));
        stage= (Stage) ((Node)e.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
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