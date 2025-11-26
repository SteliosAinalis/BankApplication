package com.stelios.bankmanagementsystem.Controllers;

import com.stelios.bankmanagementsystem.Models.Model;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    public ChoiceBox acc_selector;
    public TextField password_fld;
    public Button login_btn;
    public Label error_lbl;
    public Label payee_address_lbl;
    public TextField payee_address_fld;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        login_btn.setOnAction(actionEvent -> onLogin());
    }


    private void onLogin(){
        Stage stage = (Stage) error_lbl.getScene().getWindow();
        Model.getInstance().getViewFactory().closeStage(stage);
        Model.getInstance().getViewFactory().showClientWindow();

    }
}
