package org.gennisilv.smartplanner;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import org.gennisilv.smartplanner.data.Calendario;
import org.gennisilv.smartplanner.data.CalendarioDAO;
import org.gennisilv.smartplanner.data.Evento;
import org.gennisilv.smartplanner.data.Utente;
import org.gennisilv.smartplanner.utils.DataHolder;
import org.gennisilv.smartplanner.utils.UserHolder;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class listaCalendariController extends barraController implements Initializable {
    private Stage stage;
    private Scene scene;
    @FXML
    private FlowPane lista;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ArrayList<Calendario> calendari = CalendarioDAO.doRetrieveByUtente(UserHolder.getIstanza().getUtente().getEmail());

        if(!calendari.isEmpty()){
            //creo la lista di bottoni che sarà visualizzata
            ArrayList<Button> bottoni = new ArrayList<>();

            //per ogni calendario creo un bottone che si chiama come il calendario e lo aggiungo alla lista
            for(Calendario calendario : calendari) {
                Button button = new Button(calendario.getNomeCalendario());
                button.setOnAction(e -> {
                    try {
                        DataHolder.getIstanza().setData(button.getText());
                        switchTosettimanale(e);
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                });
                bottoni.add(button);
            }
            //aggiungo la lista di bottoni al contenitore
            boolean util = lista.getChildren().addAll(bottoni);
        }
        else{
            Alert alert = new Alert(Alert.AlertType.INFORMATION,"Non c'è nessun calendario");
            alert.showAndWait();
        }
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
