module com.example.admission_student {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires mysql.connector.java;


    opens com.example.admission_student to javafx.fxml;
    exports com.example.admission_student;
}