package com.example.add_university;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
//import utilities.sqliteConnection;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ResourceBundle;

//import static javax.xml.catalog.CatalogMessages.resourceBundle;

//import static com.sun.java.swing.action.ActionManager.utilities;

// all users class
public class controller{

    @FXML
    private TextField uniname;
    @FXML
    private TextField hsc_gpa;
    @FXML
    private TextField hsc_steam;
    @FXML
    private TextField ssc_gpa;
    @FXML
    private TextField ssc_steam;
    @FXML
    private TextField unit;
    @FXML
    private Label meassage;


    //ObservableList<String> typelist= FXCollections.observableArrayList("STUDENT","FACULTY","ADMIN");

    @FXML
    public void add_uni(MouseEvent event) throws SQLException, IOException {
        dbconnect connectnow = new dbconnect();
        Connection connectdb = connectnow.getConnection();

        String uname = uniname.getText();
        String Unit = unit.getText();
        String hscgpa = hsc_gpa.getText();
        String hscsteam = hsc_steam.getText();
        String sscgpa = ssc_gpa.getText();
        String sscsteam = ssc_steam.getText();
        String insertFields = "INSERT INTO login.university_list (uni_name, unit, hsc_gpa, hsc_steam, ssc_gpa,ssc_steam) VALUES ('";
        String insertValues = uname + "','" + Unit + "','" + hscgpa + "','" + hscsteam +  "','" + sscgpa + "','" + sscsteam + "')";
        String insertToRegister = insertFields + insertValues;

        try{
            Statement statement = connectdb.createStatement();
            statement.executeUpdate(insertToRegister);
            meassage.setText("added successfully");
            //createAccountFrom();

        }catch(Exception e){
            e.printStackTrace();
            e.getCause();
        }

    }
    @FXML
    void add2(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("adduni.fxml"));
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setScene(new Scene(root));

    }
    @FXML
    void show(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("DisplayUsers.fxml"));
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setScene(new Scene(root));

    }



}