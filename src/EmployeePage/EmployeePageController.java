package EmployeePage;

import ChefsPage.addChefsController;
import ChefsPage.insertChefsController;
import Transports.Paths;
import database.DatabaseConnector;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import structure.chef;
import structure.employee;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class EmployeePageController implements Initializable {

    public TableView<employee> employeeTable;
    @FXML
    private Label invalidLabel;
    @FXML
    private TableColumn<employee, String> C1;
    @FXML
    private TableColumn<employee, String> C2;
    @FXML
    private TableColumn<employee, String> C3;
    @FXML
    private TableColumn<employee, String> C4;
    @FXML
    private Hyperlink backlabel;
    @FXML
    private BorderPane borderPane;
    @FXML
    private VBox vbox;
    @FXML
    private Label rectitle;
    @FXML
    private Button Hotebutton;
    @FXML
    private Button chefButton;
    @FXML
    private Button branchButton;
    @FXML
    private Button menuButton;
    @FXML
    private Button EmployeeButton;
    @FXML
    private ImageView logmini;
    private PreparedStatement prep_stmt = null;
    private ResultSet re = null;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        invalidLabel.setText("");
        C1.setCellValueFactory(new PropertyValueFactory<employee, String>("SSN"));
        C2.setCellValueFactory(new PropertyValueFactory<employee, String>("name"));
        C3.setCellValueFactory(new PropertyValueFactory<employee, String>("doj"));
        C4.setCellValueFactory(new PropertyValueFactory<employee, String>("designation"));

        ObservableList<employee> employeelist = FXCollections.observableArrayList();

        try {
            Connection connection = DatabaseConnector.getConnnection();
            connection.setAutoCommit(false);
            System.out.println("Opened database successfully");
            //get the data from db
            prep_stmt = connection.prepareStatement("SELECT * FROM Employee");
            re = prep_stmt.executeQuery();
            while (re.next()){
                employeelist.add(new employee(re.getString("SSID"), re.getString("ename"), re.getString("DOJ"),
                        re.getString("designation")));
            }
            re.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }



        employeeTable.setItems(employeelist);


    }
    @FXML
    public void goToHotel(ActionEvent actionEvent) {
        new HotelPage.HotelPageController().goToHotel(actionEvent);
    }
    @FXML
    public void goToChefs(ActionEvent actionEvent) {
        new HotelPage.HotelPageController().goToChefs(actionEvent);
    }
    @FXML
    public void goToBranch(ActionEvent actionEvent) {
        new HotelPage.HotelPageController().goToBranch(actionEvent);
    }
    @FXML
    public void gotToMenu(ActionEvent actionEvent) {
        new HotelPage.HotelPageController().gotToMenu(actionEvent);
    }
    @FXML
    public void gotToEmployee(ActionEvent actionEvent) {
        new HotelPage.HotelPageController().gotToEmployee(actionEvent);
    }
    @FXML
    public void gotToHome(ActionEvent actionEvent) {
        new dashboard.dashboardController().gotToHome(actionEvent);
    }
    @FXML
    public void gotoLogin(MouseEvent actionEvent){
        new dashboard.dashboardController().gotoLogin(actionEvent);
    }

    public void Editcol(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader ();
            loader.setLocation(getClass().getResource(Paths.EDITEMPLOYEEVIEW));
            Parent root = loader.load();
            Scene scene = new Scene(root,513, 544);
            addEmployeeController abc = loader.getController();
            abc.setTextField(employeeTable.getSelectionModel().getSelectedItem());

            Stage window= new Stage();
            window.setTitle("employee page");
            window.setScene(scene);
            window.setResizable(false);
            window.show();
            root.requestFocus();
        }
        catch (Exception ex) {
            System.out.println("Error load Checkin FXML !");
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
    }

    public void Adddata(ActionEvent actionEvent) {

        try {
            FXMLLoader loader = new FXMLLoader ();
            loader.setLocation(getClass().getResource(Paths.INSERTEMPLOYEEVIEW));
            Parent root = loader.load();
            Scene scene = new Scene(root,513, 544);
            insertEmployeeController abc = loader.getController();
            Stage window= new Stage();
            window.setTitle("employee page");
            window.setScene(scene);
            window.setResizable(false);
            window.show();
            root.requestFocus();
        }
        catch (Exception ex) {
            System.out.println("Error load Checkin FXML !");
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
    }

    @FXML
    public void delcol(ActionEvent actionevent)
    {
        try {
            Connection connection = DatabaseConnector.getConnnection();
            connection.setAutoCommit(false);
            System.out.println("Opened database successfully");
            employee e1 = employeeTable.getSelectionModel().getSelectedItem();
            prep_stmt = connection.prepareStatement("Delete from employee where SSID=?");
            prep_stmt.setString(1, e1.getSSN());
            prep_stmt.executeUpdate();
            connection.commit();
            connection.close();
            invalidLabel.setText("Deletion successful");
            invalidLabel.setTextFill(Color.GREEN);
        }
        catch(Exception e){
            e.printStackTrace();

    }
    }
}
