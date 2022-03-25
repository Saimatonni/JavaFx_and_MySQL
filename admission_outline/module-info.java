module com.example.admission_dash {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.admission_dash to javafx.fxml;
    exports com.example.admission_dash;
}