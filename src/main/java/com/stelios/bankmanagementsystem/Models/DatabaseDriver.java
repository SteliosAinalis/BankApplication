package com.stelios.bankmanagementsystem.Models;

import java.sql.*;

public class DatabaseDriver {
    private Connection connection;

    public DatabaseDriver() {
        try{
            this.connection = DriverManager.getConnection("jdbc:sqlite:bank.db");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }





    //Client
    public ResultSet getClientData(String pAddress, String password){
        Statement statement;
        ResultSet resultSet = null;
        try{
            statement = this.connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM Clients WHERE PayeeAddress = '" + pAddress + "' AND Password = '" + password + "';");

        }catch(SQLException e){
            System.err.println("DATABASE ERROR executing getClientData query.");
            e.printStackTrace();
        }
        return resultSet;
    }



    //Admin
    public ResultSet getAdminData(String username, String password){
        Statement statement;
        ResultSet resultSet = null;
        try{
            statement = this.connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM Admins WHERE Username='"+username+"' AND Password= '"+password + "';");
        }catch(SQLException e){
            System.err.println("DATABASE ERROR executing getAdminData query.");
            e.printStackTrace();
        }
        return resultSet;
    }


    //Methods

}
