package HotelPage;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import structure.Hotel;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;
import  database.DatabaseConnector;

public class HotelPageController implements Initializable {
    @FXML
    private TableView<Hotel> hotelTable;
    @FXML
    private TableColumn<Hotel, String> C1;
    @FXML
    private TableColumn<Hotel, Float> C2;
    @FXML
    private TableColumn<Hotel, String> C3;
    @FXML
    private TableColumn<Hotel, String> C4;
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
    private PreparedStatement prep_stmt = null;
    private ResultSet re = null;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        C1.setCellValueFactory(new PropertyValueFactory<Hotel, String>("hotel_name"));
        C2.setCellValueFactory(new PropertyValueFactory<Hotel, Float>("revenue_planned"));
        C3.setCellValueFactory(new PropertyValueFactory<Hotel, String>("state"));
        C4.setCellValueFactory(new PropertyValueFactory<Hotel, String>("date"));


         ObservableList<Hotel> hotellist = FXCollections.observableArrayList();

        try {
            Connection connection = DatabaseConnector.getConnnection();
            connection.setAutoCommit(false);
            System.out.println("Opened database successfully");
            //get the data from db
            prep_stmt = connection.prepareStatement("SELECT * FROM Hotel");
             re = prep_stmt.executeQuery();
            while (re.next()){
                hotellist.add(new Hotel(re.getString("Hotel_name"),re.getFloat("Revenue_planned"), re.getString("State"),
                        re.getString("Start_date")));
            }
            re.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }



        hotelTable.setItems(hotellist);

    }
    @FXML
    public void goToHotel(ActionEvent actionEvent) {
        new dashboard.dashboardController().goToHotel(actionEvent);
    }
    @FXML
    public void goToChefs(ActionEvent actionEvent) {
        new dashboard.dashboardController().goToChefs(actionEvent);
    }
    @FXML
    public void goToBranch(ActionEvent actionEvent) {
        new dashboard.dashboardController().goToBranch(actionEvent);
    }
    @FXML
    public void gotToMenu(ActionEvent actionEvent) {
        new dashboard.dashboardController().gotToMenu(actionEvent);
    }
    @FXML
    public void gotToEmployee(ActionEvent actionEvent) {
        new dashboard.dashboardController().gotToEmployee(actionEvent);
    }
    @FXML
    public void gotToHome(ActionEvent actionEvent) {
        new dashboard.dashboardController().gotToHome(actionEvent);
    }
}
