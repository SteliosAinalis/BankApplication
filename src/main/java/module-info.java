module com.stelios.bankmanagementsystem {
    requires javafx.controls;
    requires javafx.fxml;
    requires de.jensd.fx.glyphs.fontawesome;
    requires java.sql;
    requires org.xerial.sqlitejdbc;


    opens com.stelios.bankmanagementsystem to javafx.fxml;
    exports com.stelios.bankmanagementsystem;
    exports com.stelios.bankmanagementsystem.Controllers;
    exports com.stelios.bankmanagementsystem.Controllers.Admin;
    exports com.stelios.bankmanagementsystem.Controllers.Client;
    exports com.stelios.bankmanagementsystem.Models;
    exports com.stelios.bankmanagementsystem.Views;


}