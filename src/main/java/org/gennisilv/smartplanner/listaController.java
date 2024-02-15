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
import org.gennisilv.smartplanner.data.entity.Impegno;
import org.gennisilv.smartplanner.logic.ListaLogic;
import org.gennisilv.smartplanner.utils.DataHolder;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class listaController extends barraController implements Initializable {

    private Stage stage;
    private Scene scene;
    @FXML
    private FlowPane lista;
    private ArrayList<Impegno> impegni;
    public void initialize(URL url, ResourceBundle resourceBundle) {
        impegni = ListaLogic.getLista();

        if(!impegni.isEmpty()){
            ArrayList<Button> bottoni = new ArrayList<>();
            for(Impegno impegno : impegni) {
                Button button = new Button(impegno.getNomeImpegno());
                button.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        DataHolder.getIstanza().setInteger(impegno.getCodiceImpegno());
                        try {
                            switchToDettagliImpegno(actionEvent);
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                });
                bottoni.add(button);
            }
            boolean util = lista.getChildren().addAll(bottoni);
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

    public void switchToDettagliImpegno(ActionEvent e) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("dettagliImpegno.fxml"));
        stage= (Stage) ((Node)e.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToInserimentoImpegno(ActionEvent e) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("inserimentoImpegno.fxml"));
        stage= (Stage) ((Node)e.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}

