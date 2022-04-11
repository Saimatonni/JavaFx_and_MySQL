package com.example.add_university;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
//import utilities.sqliteConnection;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ResourceBundle;
// display users
public class displayUsers implements Initializable{

    @FXML
    private TableView<user> tableView;
    @FXML
    private TableColumn<user,Integer> idc;
    @FXML
    private TableColumn<user,String> universityc;
    @FXML
    private TableColumn<user,String> unitc;
    @FXML
    private TableColumn<user,String> hscgpac;
    @FXML
    private TableColumn<user,String> hscsteamc;
    @FXML
    private TableColumn<user,String> sscgpac;
    @FXML
    private TableColumn<user, String> sscsteamc;



    @FXML
    public void loadData() {

        idc.setCellValueFactory(new PropertyValueFactory<user,Integer>("id"));
        universityc.setCellValueFactory(new PropertyValueFactory<user,String>("university"));
        unitc.setCellValueFactory(new PropertyValueFactory<user,String>("unit"));
        hscgpac.setCellValueFactory(new PropertyValueFactory<user,String>("hsc_gpa"));
        hscsteamc.setCellValueFactory(new PropertyValueFactory<user,String>("hsc_steam"));
        sscgpac.setCellValueFactory(new PropertyValueFactory<user,String>("ssc_gpa"));
        sscsteamc.setCellValueFactory(new PropertyValueFactory<user,String>("ssc_steam"));


        tableView.setItems(getUsers());
    }

    public ObservableList<user> getUsers(){
        ObservableList<user> user= FXCollections.observableArrayList();
        try {
           /* Connection connection = sqliteConnection.dbConnector();
            Statement statement = connection.createStatement();*/
            dbconnect connectnow = new dbconnect();
            Connection connectdb = connectnow.getConnection();
            Statement statement = connectdb.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from university_list");
            while (resultSet.next()) {
                user.add(new user(resultSet.getInt("iduniversity_list"), resultSet.getString("uni_name"), resultSet.getString("unit"),  resultSet.getString("hsc_gpa"), resultSet.getString("hsc_steam"), resultSet.getString("ssc_gpa"), resultSet.getString("ssc_steam")));
            }


        } catch (SQLException e) {
            System.err.println("Cannot Connect to Database");
        }



        return user;
    }

    @FXML
    public void rmData() throws SQLException {
        user selectedItem = tableView.getSelectionModel().getSelectedItem();
        tableView.getItems().remove(selectedItem);


        dbconnect connectnow = new dbconnect();
        Connection connectdb = connectnow.getConnection();
        Statement statement = connectdb.createStatement();

        int status = statement.executeUpdate("DELETE FROM university_list WHERE id= '"+selectedItem.getId()+"'");

        /*if (status==1) {
            Alert alert =new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Remove university");
            alert.setHeaderText(null);
            alert.setContentText("University "+selectedItem.getUniversity()+" "+selectedItem.getUnit()+" have been removed Successfuly!");
            alert.showAndWait();
        }*/
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadData();
    }
    @FXML
    void add(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("adduni.fxml"));
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setScene(new Scene(root));

    }
    @FXML
    void show(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("DisplayUsers.fxml"));
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setScene(new Scene(root));

    }
}
