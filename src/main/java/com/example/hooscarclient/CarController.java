package com.example.hooscarclient;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;


import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.EventObject;
import java.util.ResourceBundle;


public class CarController
{
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private Label loginLabel;
    private Label usernameLabel;
    @FXML
    private ComboBox<String> comboBox;
    @FXML
    private ObservableList<String> pools;


    public void switchToProfile(ActionEvent event) throws IOException
    {
        root = FXMLLoader.load(getClass().getResource("profile-view.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    protected void loginClick()
    {
        //switchToProfile();
        //loginLabel.setText("Yayy you logged in hah");
        //switch to profile scene
    }


    public void signupClick()
    {
        //switch to signup scene
    }


    /*ObservableList<String> list = FXCollections.observableArrayList(
            "Item 1", "Item 2", "Item 3", "Item 4");
    ListView<String> lv = new ListView<>(list);
        lv.setCellFactory(param -> new XCell()); */
    @FXML
    protected void switchToPool(ActionEvent event) throws IOException
    {
        // when a pool is clicked, move to a different scene
        // retrieve from server
        root = FXMLLoader.load(getClass().getResource("pool-view.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    public void initializePoolList()
    {
        pools = FXCollections.observableArrayList(); // currently empty


        for (int i = 0; i < 5; i++)
        {
            pools.add("No Pool");
        }
        //retrieve pools for the mmember
        //"getAllPools username"
        //parse through
        //pools.set(i, parsed value)


       /*comboBox = new ComboBox<>();
       for(int i=0; i < 10; i++) {
           pools.add(""+i);
//            comboBox.getItems().add(""+i);
       }
       comboBox.setItems(pools);
       System.out.println(comboBox.toString()); */
        //fill pools using getAllPools
    }
    public void joinPool()
    {
        //enter ID
        //check if ID is valid (call to backend)
        //"selectPool poolID"
        // if valid add pool


        //comboBox.getItems().add("yum pices"); //add the id
    }


    public void createPool()
    {


    }
}

