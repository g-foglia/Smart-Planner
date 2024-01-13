package org.gennisilv.smartplanner;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;

import java.io.IOException;

public class settimanalController {
    private Stage stage;
    private Scene scene;
    private Parent root;
    private double x;
    private double y;
    @FXML
    private Polygon giorni;
    public void switchToSettimanale(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("settimanale.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void switchHome(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("Home.fxml"));
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
}
