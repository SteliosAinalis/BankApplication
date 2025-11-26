package com.stelios.bankmanagementsystem.Controllers;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    public ChoiceBox acc_selector;
    public Label payee_adress_lbl;
    public TextField payee_adress_fld;
    public TextField password_fld;
    public Button login_btn;
    public Label error_lbl;


    public void initialize(URL location, ResourceBundle resources) {}
}
