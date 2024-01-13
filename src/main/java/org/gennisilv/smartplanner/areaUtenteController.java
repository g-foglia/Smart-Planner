package org.gennisilv.smartplanner;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class areaUtenteController {
    private Stage stage;
    private Scene scene;
    private Parent root;
    public void switchTosettimanale(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("settimanale.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void switchToHome (ActionEvent e) throws IOException
    {
        Parent root = FXMLLoader.load(getClass().getResource("Home.fxml"));
        stage= (Stage) ((Node)e.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void switchToAreaUtente (ActionEvent e) throws IOException
    {
        Parent root = FXMLLoader.load(getClass().getResource("areaUtente.fxml"));
        stage= (Stage) ((Node)e.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void switchToListaCalendari (ActionEvent e) throws IOException
    {
        Parent root = FXMLLoader.load(getClass().getResource("listaCalendari.fxml"));
        stage= (Stage) ((Node)e.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void switchToRicerca (ActionEvent e) throws IOException
    {
        Parent root = FXMLLoader.load(getClass().getResource("ricercaEventi.fxml"));
        stage= (Stage) ((Node)e.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
