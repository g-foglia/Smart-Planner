package org.gennisilv.smartplanner;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
public class inserimentoEventoApplication extends Application {
    @Override
    public void start(Stage stage){
        try{
            Parent root = FXMLLoader.load(getClass().getResource("inserimentoEvento.fxml"));
            Scene inserimentoEvento = new Scene(root);
            stage.setScene(inserimentoEvento);
            stage.show();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
