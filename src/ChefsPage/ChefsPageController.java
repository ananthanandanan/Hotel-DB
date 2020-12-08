package ChefsPage;

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
import structure.Hotel;
import structure.chef;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ChefsPageController implements Initializable {

    @FXML
    public TableView<chef> chefsTable;
    @FXML
    private TableColumn<chef, String> C1;
    @FXML
    private TableColumn<chef, Float> C2;
    @FXML
    private TableColumn<chef, String> C3;
    @FXML
    private TableColumn<chef, String> C4;
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

        C1.setCellValueFactory(new PropertyValueFactory<chef, String>("SSN"));
        C2.setCellValueFactory(new PropertyValueFactory<chef, Float>("cuisine_id"));
        C3.setCellValueFactory(new PropertyValueFactory<chef, String>("name"));
        C4.setCellValueFactory(new PropertyValueFactory<chef, String>("doj"));


        ObservableList<chef> chefslist = FXCollections.observableArrayList();

        try {
            Connection connection = DatabaseConnector.getConnnection();
            connection.setAutoCommit(false);
            System.out.println("Opened database successfully");
            //get the data from db
            prep_stmt = connection.prepareStatement("SELECT * FROM chefs");
            re = prep_stmt.executeQuery();
            while (re.next()){
                chefslist.add(new chef(re.getString("SSN"), re.getString("Chef_name"), re.getString("DOJ"),
                        re.getString("Cuisine_id")));
            }
            re.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }



        chefsTable.setItems(chefslist);


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
    @FXML
    public void gotoLogin(MouseEvent actionEvent){new dashboard.dashboardController().gotoLogin(actionEvent);}

}
