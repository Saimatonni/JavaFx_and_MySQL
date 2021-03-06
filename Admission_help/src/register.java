package com.example.admission_add;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.stage.StageStyle;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

public class register implements Initializable{
    @FXML
    private ImageView registerimageview;
    @FXML
    private Button closeButton;
    @FXML
    private Button haveaccountButton;
    @FXML
    private Label registerMessagelabel;
    @FXML
    private PasswordField passwordTextfield;
    @FXML
    private PasswordField confirmpasswordfield;
    @FXML
    private Label confirmpasswordlabel;
    @FXML
    private TextField nameTextfield;
    @FXML
    private TextField gmailTextfield;
    @FXML
    private TextField usernameTextfield;
    public void initialize(URL url, ResourceBundle resourceBundle) {
        File registerFile = new File("images/register-here-button.png");
        Image registerImage = new Image(registerFile.toURI().toString());
        registerimageview.setImage(registerImage);

    }

    public void registerButtonOnAction(ActionEvent event) throws IOException {
        if(passwordTextfield.getText().equals(confirmpasswordfield.getText())){
            registerUser();
            confirmpasswordlabel.setText("");

                Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));

                Node node = (Node) event.getSource();

                Stage stage = (Stage) node.getScene().getWindow();

                stage.setScene(new Scene(root));


            //registerMessagelabel.setText("user has been registered successfully");
        }
        else{
            confirmpasswordlabel.setText("Password does not match");
        }
    }
    public void closeButtonOnAction(ActionEvent event){
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
        //Platform.exit();
        //createAccountFrom();
    }
    public void haveaccountButtonOnAction(ActionEvent event) throws IOException {
        //createAccountFrom();
            Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));

            Node node = (Node) event.getSource();

            Stage stage = (Stage) node.getScene().getWindow();

            stage.setScene(new Scene(root));

    }

    public void registerUser(){
        dbconnect connectnow = new dbconnect();
        Connection connectdb = connectnow.getConnection();

        String name = nameTextfield.getText();
        String gmail = gmailTextfield.getText();
        String username = usernameTextfield.getText();
        String password = passwordTextfield.getText();
        String insertFields = "INSERT INTO login.admission_login (name, gmail, username, password) VALUES ('";
        String insertValues = name + "','" + gmail + "','" + username + "','" + password + "')";
        String insertToRegister = insertFields + insertValues;

        try{
            Statement statement = connectdb.createStatement();
            statement.executeUpdate(insertToRegister);
            //registerMessagelabel.setText("user has been registered successfully");
            //createAccountFrom();

        }catch(Exception e){
            e.printStackTrace();
            e.getCause();
        }

    }
    /*public void createAccountFrom(){
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(login.class.getResource("login.fxml"));
            Stage RegisterStage = new Stage();
            Scene scene = new Scene(fxmlLoader.load(), 600, 400);
            RegisterStage.initStyle(StageStyle.UNDECORATED);
            RegisterStage.setScene(scene);
            RegisterStage.show();

        }catch(Exception e){
            e.printStackTrace();;
            e.getCause();
        }
    }*/


}