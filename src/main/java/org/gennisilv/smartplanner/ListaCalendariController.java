package org.gennisilv.smartplanner;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import org.gennisilv.smartplanner.data.entity.Calendario;
import org.gennisilv.smartplanner.logic.CalendarioLogic;
import org.gennisilv.smartplanner.utils.DataHolder;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ListaCalendariController extends BarraController implements Initializable {
    @FXML
    private FlowPane calendari;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ArrayList<Calendario> calendariUtente = CalendarioLogic.returnCalendari();

        if(!calendariUtente.isEmpty()){
            ArrayList<Button> bottoni = new ArrayList<>();
            for(Calendario calendario : calendariUtente) {
                Button button = new Button(calendario.getNomeCalendario());
                button.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        DataHolder.getIstanza().setInteger(calendario.getCodiceCalendario());
                        try {
                            switchTosettimanale(actionEvent);
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                });
                bottoni.add(button);
            }
            boolean util = calendari.getChildren().addAll(bottoni);
        }
        else{
            Alert alert = new Alert(Alert.AlertType.INFORMATION,"Nessun calendario");
            alert.showAndWait();
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

    @Override
    public void switchToAggiuntaEvento (ActionEvent e) throws IOException
    {
        super.switchToAggiuntaEvento(e);
    }
}
