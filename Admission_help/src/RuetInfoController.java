package com.example.admission_add;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class RuetInfoController implements Initializable {
    @FXML
    private ImageView ruetimageview;

    @FXML
    private Button btnBack;

    @FXML
    private Button btnContact;

    @FXML
    private Button btnDept;

    @FXML
    private Button btnHome;

    @FXML
    private Button btnResearch;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        File ruetFile = new File("images/cuet_logo.png");
        Image ruetImage = new Image(ruetFile.toURI().toString());
        ruetimageview.setImage(ruetImage);
    }

    @FXML
    void goBack(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("UniversityList.fxml"));
        Scene scene= new Scene(root);

        Stage NewStage=(Stage)((Node)event.getSource()).getScene().getWindow();
        NewStage.setScene(scene);
        NewStage.show();
    }

    @FXML
    void goHome(ActionEvent event) {

    }

    @FXML
    void openConactWindow(ActionEvent event) {

    }

    @FXML
    void openDeptWindow(ActionEvent event) {

    }

    @FXML
    void openResearchWindow(ActionEvent event) {

    }

}
