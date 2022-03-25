module com.example.admission_home {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.admission_home to javafx.fxml;
    exports com.example.admission_home;
}