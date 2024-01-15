package org.gennisilv.smartplanner;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.gennisilv.smartplanner.data.Impegno;
import org.gennisilv.smartplanner.data.ListaDAO;

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

    /*public void inserisciImpegno(ActionEvent event){

        Impegno impegno = new Impegno();
        impegno.setNomeImpegno(nomeImpegno.getText());
        impegno.setDurataImpegno((Integer.parseInt(durataImpegno.getText())));
        impegno.setPrioritaImpegno((Integer.parseInt(prioritaID.getValue())));
        ListaDAO.doAddImpegno(impegno, EMAIL UTENTE);
        switchToHome(event);

    }  */

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
