package com.stelios.bankmanagementsystem.Controllers.Client;

import com.stelios.bankmanagementsystem.Models.Transaction;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

import java.net.URL;
import java.util.ResourceBundle;

public class TransactionCellController implements Initializable {
    public HBox transaction_cell_container;
    public Label trans_date_lbl;
    public Label sender_lbl;
    public Label receiver_lbl;
    public Label amount_lbl;

    private final Transaction transaction;

    public TransactionCellController(Transaction transaction) {
        this.transaction = transaction;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        trans_date_lbl.textProperty().bind(transaction.dateProperty().asString());
        sender_lbl.textProperty().bind(transaction.senderProperty());
        receiver_lbl.textProperty().bind(transaction.receiverProperty());
        amount_lbl.textProperty().bind(transaction.amountProperty().asString("$%,.2f"));
        transaction_cell_container.setOnMousePressed(event -> showTransactionMessage());
    }

    private void showTransactionMessage() {
        String message = transaction.messageProperty().get();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Transaction Message");
        alert.setHeaderText("From: " + transaction.senderProperty().get() + "\nTo: " + transaction.receiverProperty().get());

        if (message != null && !message.isBlank()) {
            alert.setContentText(message);
        } else {
            alert.setContentText("No message was provided for this transaction.");
        }
        alert.showAndWait();
    }
}