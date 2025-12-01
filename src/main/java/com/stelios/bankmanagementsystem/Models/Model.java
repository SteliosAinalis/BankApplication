package com.stelios.bankmanagementsystem.Models;

import com.stelios.bankmanagementsystem.Views.AccountType;
import com.stelios.bankmanagementsystem.Views.ViewFactory;

import java.sql.ResultSet;
import java.time.LocalDate;

public class Model {
    private static Model model;
    private final ViewFactory viewFactory;
    private final DatabaseDriver databaseDriver;


    //client
    private Client client;
    private boolean clientLoginSuccess;

    //Admin
    private boolean adminLoginSuccess;



    public Model() {
        this.viewFactory = new ViewFactory();
        this.databaseDriver = new DatabaseDriver();
        this.adminLoginSuccess = false;
        this.clientLoginSuccess = false;
        this.client = new Client("","","",null,null,null);
    }


    public static synchronized Model getInstance() {
        if(model == null){
            model = new Model();
        }
        return model;
    }

    public ViewFactory getViewFactory() {return viewFactory;}

    public DatabaseDriver getDatabaseDriver() {return databaseDriver;}





    //Client methods
    public boolean getClientLoginSuccess() {return this.clientLoginSuccess;}
    public void setClientLoginSuccess(boolean flag) {this.clientLoginSuccess = flag;}

    public Client getClient() {return client;}

    public void evaluateClientCredentials(String pAddress, String password){
        this.clientLoginSuccess = false;

        CheckingAccount checkingAccount;
        SavingsAccount savingsAccount;
        ResultSet resultSet = databaseDriver.getClientData(pAddress, password);
        try{
            if(resultSet.isBeforeFirst()){
                this.client.firstNameProperty().set(resultSet.getString("FirstName"));
                this.client.lastNameProperty().set(resultSet.getString("LastName"));
                this.client.payeeAddressProperty().set(resultSet.getString("PayeeAddress"));
                String[] dateParts = resultSet.getString("Date").split("-");
                LocalDate date = LocalDate.of(Integer.parseInt(dateParts[0]),Integer.parseInt(dateParts[1]),Integer.parseInt(dateParts[2]));
                this.client.dateCreatedProperty().set(date);
                this.clientLoginSuccess = true;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }





    //Admin Methods

    public boolean getAdminLoginSuccess() {return this.adminLoginSuccess;}
    public void setAdminLoginSuccess(boolean flag) {this.adminLoginSuccess = flag;}

    public void evaluateAdminCredentials(String username, String password){
        this.adminLoginSuccess = false;

        ResultSet resultSet = databaseDriver.getAdminData(username, password);
        try{
            if(resultSet.isBeforeFirst()){
                this.adminLoginSuccess = true;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }









}
