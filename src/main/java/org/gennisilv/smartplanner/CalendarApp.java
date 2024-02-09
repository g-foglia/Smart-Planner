package org.gennisilv.smartplanner;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class CalendarApp extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("calendar.fxml"));
        primaryStage.setScene(new Scene(root, 400, 500));
        primaryStage.setTitle("Calendario");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}