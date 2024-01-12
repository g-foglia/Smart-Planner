package org.gennisilv.smartplanner;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Polyline;
import javafx.stage.Stage;

import java.io.IOException;


public final class settimanaleController {
    private Stage stage;
    private Scene scene;
    private Parent root;
    private Polyline giorno;
    private double x;
    private double y;
    @FXML
    private Polygon giorni;
    public void switchTosettimanale(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("settimanale.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void lunedi(ActionEvent e) throws IOException{
    giorni.setTranslateX(0);
    }
    public void martedi(ActionEvent e) throws IOException{
        giorni.setTranslateX(35);
    }
    public void mercoledi(ActionEvent e) throws IOException{
        giorni.setTranslateX(73);
    }
    public void giovedi(ActionEvent e) throws IOException{
        giorni.setTranslateX(108);
    }
    public void venerdi(ActionEvent e) throws IOException{
        giorni.setTranslateX(143);
    }
    public void sabato(ActionEvent e) throws IOException{
        giorni.setTranslateX(178);
    }
    public void domenica(ActionEvent e) throws IOException{
        giorni.setTranslateX(214);
    }
    /*public void switchToRegistrazione(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Registrazione.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToLogin(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }*/


}