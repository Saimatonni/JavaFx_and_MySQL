package com.example.dbtest;

//import connect;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class HelloController {
    public TextField textField;
    public Label textLabel;
    public TextField userName;

    public Label isConnected;
    public PasswordField userPassword;

    public void button(ActionEvent actionEvent) throws SQLException {
        textLabel.setText(textField.getText());
        System.out.println("Program is running");
    }

    public void login(ActionEvent actionEvent) {

        connect connectionClass = new connect();
        Connection connection = connectionClass.getConnection();

        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM user WHERE name = '" + userName.getText() + "' AND password = '" + userPassword.getText() + "';";
            ResultSet resultSet = statement.executeQuery(sql);

            if (resultSet.next()) {
                isConnected.setText("Connected");
            } else {

                isConnected.setText("Not Connected");
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}