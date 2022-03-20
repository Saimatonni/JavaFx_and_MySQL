package com.example.dbtest;

import java.sql.Connection;
import java.sql.DriverManager;

public class connect {
    public Connection connection;
    public  Connection getConnection(){


        String dbName="github";
        String userName="tttt";
        String password="tt";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();

            connection= DriverManager.getConnection("jdbc:mysql://localhost/"+dbName,userName,password);


        } catch (Exception e) {
            e.printStackTrace();
        }


        return connection;
    }

}

