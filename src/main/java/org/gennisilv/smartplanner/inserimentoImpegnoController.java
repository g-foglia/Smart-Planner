package org.gennisilv.smartplanner;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.gennisilv.smartplanner.logic.ListaLogic;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class inserimentoImpegnoController extends barraController implements Initializable {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Label prioritaLabelID;
    @FXML
    private ChoiceBox<String> prioritaID;
    @FXML
    private TextField nomeImpegno;
    @FXML
    private TextField durataImpegno;

    private String[] priorita = {"1", "2", "3", "4", "5"};

    public void inserisciImpegno(ActionEvent e) throws IOException {
        String nomeI = nomeImpegno.getText();
        int durataI = Integer.parseInt(durataImpegno.getText());
        int priorita = -1;
        switch (prioritaID.getValue()){
            case "Altissima":
                priorita = 0;
            case "Alta":
                priorita = 1;
            case "Media":
                priorita = 2;
            case "Bassa":
                priorita = 3;
            case "Bassissima":
                priorita = 4;
        }
        int codiceImpegno = ListaLogic.aggiungiImpegno(nomeI, durataI, priorita);

        if(codiceImpegno == -1){
            Alert alert = new Alert(Alert.AlertType.INFORMATION,"Il nome non può contenere caratteri speciali");
            alert.showAndWait();
        }else{
            switchTosettimanale(e);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        prioritaID.getItems().addAll(priorita);
    }

    public void switchTosettimanale(ActionEvent e) throws IOException {
        super.switchTosettimanale(e);
    }
    public void switchToHome (ActionEvent e) throws IOException
    {
        super.switchToHome(e);
    }
    public void switchToAreaUtente (ActionEvent e) throws IOException
    {
        super.switchToAreaUtente(e);
    }
    public void switchToListaCalendari (ActionEvent e) throws IOException
    {
        super.switchToListaCalendari(e);
    }
    public void switchToAggiuntaEvento (ActionEvent e) throws IOException
    {
        super.switchToAggiuntaEvento(e);
    }
    public void switchToRicerca (ActionEvent e) throws IOException
    {
        super.switchToRicerca(e);
    }


}
