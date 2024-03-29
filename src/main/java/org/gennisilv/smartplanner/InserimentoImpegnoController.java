package org.gennisilv.smartplanner;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
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

public class InserimentoImpegnoController extends BarraController implements Initializable {

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
        String durata = durataImpegno.getText();
        int durataI = 0;
        if(!durata.isEmpty()){
            durataI = Integer.parseInt(durata);
        }
        int priorita = 2;
        if(prioritaID.getValue() != null) {
            switch (prioritaID.getValue()) {
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
        }
        int codiceImpegno = ListaLogic.aggiungiImpegno(nomeI, durataI, priorita);

        if(codiceImpegno == -1){
            Alert alert = new Alert(Alert.AlertType.INFORMATION,"La durata è obbligatoria e deve essere di almeno 30 minuti");
            alert.showAndWait();
        }else if(codiceImpegno == -2){
            Alert alert = new Alert(Alert.AlertType.INFORMATION,"Il nome non può contenere caratteri speciali o essere vuoto");
            alert.showAndWait();
        }
        else{
            switchToLista(e);
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

    public void switchToLista(ActionEvent e) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("lista.fxml"));
        stage= (Stage) ((Node)e.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
