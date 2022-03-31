package com.example.admission_student;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ResourceBundle;

public class studentCon implements Initializable {
    @FXML
    private TextField nametextfield;
    @FXML
    private TextField grouptextfield;
    @FXML
    private TextField sscgpatextfield;
    @FXML
    private TextField hscgpatextfield;
    @FXML
    private TextField totalgpatextfield;
    @FXML
    private TextField passedyeartextfield;
    @FXML
    private Label addedlabelmessage;

    @FXML
    private ImageView studentimageview;
    @FXML
    private ImageView universityimageview;
    @FXML
    private ImageView dashimageview;
    @FXML
    private ImageView homeimageview;
    @FXML
    private ImageView euniversityimageview;
    @FXML
    private ImageView dstudentimageview;
    @FXML
    private ImageView questionsimageview;
    @FXML
    private ImageView logoutimageview;
    @FXML
    private ImageView logoutimageview2;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        File studentFile = new File("images/Stats.png");
        Image studentImage = new Image(studentFile.toURI().toString());
        studentimageview.setImage(studentImage);

        File universityFile = new File("images/university-icon-19.png");
        Image universityImage = new Image(universityFile.toURI().toString());
        universityimageview.setImage(universityImage);

        File homeFile = new File("images/home.png");
        Image homeImage = new Image(homeFile.toURI().toString());
        homeimageview.setImage(homeImage);

        File dstudentFile = new File("images/Male.png");
        Image dstudentImage = new Image(dstudentFile.toURI().toString());
        dstudentimageview.setImage(dstudentImage);

        File euniversityFile = new File("images/Search.png");
        Image euniversityImage = new Image(euniversityFile.toURI().toString());
        euniversityimageview.setImage(euniversityImage);

        File questionsFile = new File("images/Read.png");
        Image questionsImage = new Image(questionsFile.toURI().toString());
        questionsimageview.setImage(questionsImage);

        File dashFile = new File("images/Disk.png");
        Image dashImage = new Image(dashFile.toURI().toString());
        dashimageview.setImage(dashImage);

        File logoutFile = new File("images/Circles.png");
        Image logoutImage = new Image(logoutFile.toURI().toString());
        logoutimageview.setImage(logoutImage);

        File logoutFile2 = new File("images/Circles.png");
        Image logoutImage2 = new Image(logoutFile2.toURI().toString());
        logoutimageview2.setImage(logoutImage2);

    }
    public void addStudentonAction(ActionEvent event){
        addStudent();
    }


    public void addStudent(){
        dbconnect connectnow = new dbconnect();
        Connection connectdb = connectnow.getConnection();

        String name = nametextfield.getText();
        String group = grouptextfield.getText();
        String ssc_gpa = sscgpatextfield.getText();
        String hsc_gpa = hscgpatextfield.getText();
        String total_gpa = totalgpatextfield.getText();
        String passed_year = passedyeartextfield.getText();
        String insertFields = "INSERT INTO login.admission_student (name, add_group, ssc_gpa, hsc_gpa, total_gpa, passed_year) VALUES ('";
        String insertValues = name + "','" + group + "','" + ssc_gpa + "','" + hsc_gpa + "','" + total_gpa + "','" + passed_year + "')";
        String inserttostudent = insertFields + insertValues;

        try{
            Statement statement = connectdb.createStatement();
            statement.executeUpdate(inserttostudent);
            addedlabelmessage.setText("Added Successfully");
            //createAccountFrom();

        }catch(Exception e){
            e.printStackTrace();
            e.getCause();
        }

    }
}