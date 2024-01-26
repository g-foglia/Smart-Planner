package org.gennisilv.smartplanner;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage){
        try{
            Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
            Scene helloview = new Scene(root);
            stage.setScene(helloview);
            stage.show();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
