package org.gennisilv.smartplanner;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.File;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage){
        try{
            Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
            Scene helloview = new Scene(root);
            stage.setTitle("SmartPlanner");
            Image image = new Image(new File("src/main/resources/images/logofia.png").toURI().toString());
            stage.getIcons().add(image);
            stage.setScene(helloview);
            stage.show();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
