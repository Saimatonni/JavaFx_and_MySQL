module com.example.admission_login {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires mysql.connector.java;


    opens com.example.admission_login to javafx.fxml;
    exports com.example.admission_login;
}