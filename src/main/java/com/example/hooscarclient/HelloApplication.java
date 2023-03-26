package com.example.hooscarclient;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application
{
    @Override
    public void start(Stage stage) throws IOException
    {
        try
        {
            //FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("homepage-view.fxml"));
            Parent root = FXMLLoader.load(HelloApplication.class.getResource("homepage-view.fxml"));
            Scene scene = new Scene(root, 450, 650);
            stage.setTitle("Hoos Car");
            String css = this.getClass().getResource("homepage.css").toExternalForm();
            scene.getStylesheets().add(css);
            stage.setScene(scene);
            stage.show();
        }
        catch(Exception e)
        {
            System.out.println("HelloApplication failure");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch();
    }
}