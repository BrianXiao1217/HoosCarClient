package com.example.hooscarclient;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.EventObject;

public class CarController {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private Label loginLabel;
    private Label usernameLabel;

    public void switchToProfile(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("profile-view.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    protected void loginClick() {
        //switchToProfile();
        //loginLabel.setText("Yayy you logged in hah");
        //switch to profile scene
    }

    public void signupClick() {
        //switch to signup scene
    }

    /*ObservableList<String> list = FXCollections.observableArrayList(
            "Item 1", "Item 2", "Item 3", "Item 4");
    ListView<String> lv = new ListView<>(list);
        lv.setCellFactory(param -> new XCell()); */
    @FXML
    protected void myPoolClick() {
        // when a pool is clicked, move to a different scene
        // retrieve from server
    }

    public void joinPoolClick() {
        //switch to signup scene
    }
}