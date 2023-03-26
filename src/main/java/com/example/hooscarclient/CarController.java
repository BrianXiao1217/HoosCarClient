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
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.URL;
import java.net.UnknownHostException;
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
    @FXML
    private TextField usernameLabel;
    @FXML
    private PasswordField passwordLabel;
    @FXML
    private ComboBox<String> comboBox;
    @FXML
    private ObservableList<String> pools;
    @FXML
    private Button[] buttons = new Button[6];

    public void switchToProfile(ActionEvent event) throws IOException //TWO WAY SOCKET WORKS
    {
        //socket (to communicate to server)
        Socket socket = null;

        //write data to the server
        DataOutputStream out = null;
        //pulls data from the server
        BufferedReader in = null;
        BufferedReader keys = null;

        try //try to make socket
        {
           //new socket, IP/port of server is constant
           socket = new Socket("172.25.174.86", 80);

           //sends data to server
           out = new DataOutputStream(socket.getOutputStream());
           //reads data from server
           in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
           keys = new BufferedReader(new InputStreamReader(System.in));
        }
        catch(UnknownHostException e)
        {
            System.out.println("nothing to connect to");
            System.exit(0);
        }
        catch(IOException e)
        {
            System.out.println("fuck you");
            System.exit(0);
        }

        String user;
        String password;
        String result = "";
        try
        {
            //user inputs to client
            //line = keys.readLine();
            //NEEDS TO READ FROM TEXTBOX
            user = usernameLabel.getText();
            password = passwordLabel.getText();

            System.out.println("user and password obtained");
            System.out.println(user+" "+password);

            //the info is sent to the server
            out.writeUTF(user+" "+password);
            //get the result after the server processes
            result = in.readLine();
            System.out.println(result);
        }
        catch(IOException e)
        {
            System.out.println("fuck you bad line");
            System.exit(0);
        }
        try
        {
            in.close();
            out.close();
            socket.close();
        }
        catch(IOException e)
        {
            System.out.println("fuck you in closing");
            System.exit(0);
        }


        if(result.equals("success"))
        {
            root = FXMLLoader.load(getClass().getResource("profile-view.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
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

    public void initializeButtons() {
        // request date, time + destination from
        ArrayList<String> buttonText = new ArrayList<>();
        int i = 0;
        for (String s: buttonText) {
            buttons[i].setText(s);
            i++;
        }
    }

    public void switchToRide(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("ride-view.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToRequest(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("request-view.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}

