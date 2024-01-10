package org.gennisilv.smartplanner;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() throws SQLException {
        Connection connection = ConPool.getConnection();

        try{
            String query = "select * from Utente;";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while(resultSet.next())
                welcomeText.setText(resultSet.getString(1)+" | "+resultSet.getString(2)+" | \n"+resultSet.getString(3)+" | "+resultSet.getString(4)+" | \n"+resultSet.getString(5)+" | "+resultSet.getString(6));
            statement.close();
            resultSet.close();
        }
        catch (SQLException e){
            System.out.println(e);
        }
        //welcomeText.setText("Welcome to JavaFX Application!");
    }
}