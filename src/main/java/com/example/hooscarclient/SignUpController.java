package com.example.hooscarclient;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class SignUpController {
    @FXML
    private Label signupLabel;

    @FXML
    protected void signupClick() {
        signupLabel.setText("");
    }

}
