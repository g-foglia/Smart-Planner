package org.gennisilv.smartplanner;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.gennisilv.smartplanner.data.Calendario;
import org.gennisilv.smartplanner.logic.CalendarioLogic;
import org.gennisilv.smartplanner.utils.DataHolder;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class listaCalendariController extends barraController implements Initializable {
    private Stage stage;
    private Scene scene;
    @FXML
    private VBox lista;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ArrayList<Calendario> calendari = CalendarioLogic.returnCalendari();

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

                button.setStyle("-fx-background-color:" + calendario.getColoreCalendario());

                bottoni.add(button);
                VBox.setMargin(button, new Insets(10, 10, 10, 10));
                lista.setSpacing(5);
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
