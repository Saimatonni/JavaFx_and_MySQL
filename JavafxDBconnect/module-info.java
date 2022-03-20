module com.example.dbtest {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires mysql.connector.java;


    opens com.example.dbtest to javafx.fxml;
    exports com.example.dbtest;
}