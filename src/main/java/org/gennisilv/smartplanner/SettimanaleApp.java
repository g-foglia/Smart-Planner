package org.gennisilv.smartplanner;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SettimanaleApp extends Application {
    @Override
    public void start(Stage stage){
        try{
            Parent root = FXMLLoader.load(getClass().getResource("settimanale.fxml"));
            Scene helloview = new Scene(root);
            stage.setScene(helloview);
            stage.show();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}