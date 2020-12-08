package BranchPage;

import database.DatabaseConnector;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import structure.Branch;
import structure.Hotel;

import  java.sql.*;
import java.net.URL;
import java.util.ResourceBundle;

public class BranchPageController implements Initializable {

    @FXML
    private TableView<Branch> branchTable;
    @FXML
    private TableColumn<Branch, String> C1;
    @FXML
    private TableColumn<Branch, String> C2;
    @FXML
    private TableColumn<Branch, Float> C3;
    @FXML
    private TableColumn<Branch, String> C4;
    @FXML
    private TableColumn<Branch, String> C5;
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
        C1.setCellValueFactory(new PropertyValueFactory<Branch, String>("hotel_name"));
        C2.setCellValueFactory(new PropertyValueFactory<Branch, String>("branch_name"));
        C3.setCellValueFactory(new PropertyValueFactory<Branch, Float>("expenditure"));
        C4.setCellValueFactory(new PropertyValueFactory<Branch, String>("city"));
        C5.setCellValueFactory(new PropertyValueFactory<Branch, String>("SSN"));

         ObservableList<Branch> branchlist = FXCollections.observableArrayList();

        try {
            Connection connection = DatabaseConnector.getConnnection();
            connection.setAutoCommit(false);
            System.out.println("Opened database successfully");
            //get the data from db
            prep_stmt = connection.prepareStatement("SELECT * FROM Branch");
            re = prep_stmt.executeQuery();
            while (re.next()){
                branchlist.add(new Branch(re.getString("Hotel_name"),re.getString("Branch_name"), re.getFloat("Expenditure"),
                        re.getString("City"),re.getString("SSN")));
            }
            re.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        branchTable.setItems(branchlist);


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
    public void gotoLogin(MouseEvent actionEvent){new dashboard.dashboardController().gotoLogin(actionEvent);}

}
