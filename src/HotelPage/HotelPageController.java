package HotelPage;

import EmployeePage.addEmployeeController;
import EmployeePage.insertEmployeeController;
import Transports.Paths;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
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
import structure.Hotel;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;
import  database.DatabaseConnector;

public class HotelPageController implements Initializable {
    @FXML
    private Label invalidLabel;
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
    @FXML
    private ImageView logmini;
    private PreparedStatement prep_stmt = null;
    private ResultSet re = null;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        invalidLabel.setText("");

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
        System.out.println("Check in button clicked");

        try {
            Parent root = FXMLLoader.load(getClass().getResource(Paths.HOTELPAGEVIEW));
            Stage window= (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            window.setTitle("Hotel page");
            Scene scene = new Scene(root);
            window.setScene(scene);
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
    public void goToChefs(ActionEvent actionEvent) {
        System.out.println("Check in button clicked");

        try {
            Parent root = FXMLLoader.load(getClass().getResource(Paths.CHEFSPAGEVIEW));
            Stage window= (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            window.setTitle("Chefs page");
            Scene scene = new Scene(root);
            window.setScene(scene);
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
    public void goToBranch(ActionEvent actionEvent) {
        System.out.println("Check in button clicked");

        try {
            Parent root = FXMLLoader.load(getClass().getResource(Paths.BRANCHPAGEVIEW));
            Stage window= (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            window.setTitle("Branch page");
            Scene scene = new Scene(root);
            window.setScene(scene);
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
    public void gotToMenu(ActionEvent actionEvent) {
        System.out.println("Check in button clicked");

        try {
            Parent root = FXMLLoader.load(getClass().getResource(Paths.MENUPAGEVIEW));
            Stage window= (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            window.setTitle("Menu page");
            Scene scene = new Scene(root);
            window.setScene(scene);
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
    public void gotToEmployee(ActionEvent actionEvent) {
        System.out.println("Check in button clicked");

        try {
            Parent root = FXMLLoader.load(getClass().getResource(Paths.EMPLOYEEPAGEVIEW));
            Stage window= (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            window.setTitle(" Employee page");
            Scene scene = new Scene(root);
            window.setScene(scene);
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
            loader.setLocation(getClass().getResource(Paths.EDITHOTELVIEW));
            Parent root = loader.load();
            Scene scene = new Scene(root,513, 544);
            addHotelController abc = loader.getController();
            abc.setTextField(hotelTable.getSelectionModel().getSelectedItem());

            Stage window= new Stage();
            window.setTitle("Hotel page");
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
            loader.setLocation(getClass().getResource(Paths.INSERTHOTELVIEW));
            Parent root = loader.load();
            Scene scene = new Scene(root,513, 544);
            insertHotelController abc = loader.getController();
            Stage window= new Stage();
            window.setTitle("Hotel page");
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
    private void Deldata(ActionEvent actionEvent){
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DatabaseConnector.getConnnection();
            connection.setAutoCommit(false);
            System.out.println("Opened database successfully");
            Hotel hotel=hotelTable.getSelectionModel().getSelectedItem();
            prep_stmt=connection.prepareStatement("Select * from Branch where Hotel_name=?");
            prep_stmt.setString(1,hotel.getHotel_name());
            re=prep_stmt.executeQuery();


            if(re.next()){
                invalidLabel.setText("Data in Branch Table!");
                invalidLabel.setTextFill(Color.RED);
            }
            else{
                prep_stmt=connection.prepareStatement("Delete from Hotel where Hotel_name=?");
                prep_stmt.setString(1,hotel.getHotel_name());
                int i = prep_stmt.executeUpdate();
                connection.commit();
                System.out.println(i+" records affected");
                connection.close();
                invalidLabel.setText("Deletion successful!");
                invalidLabel.setTextFill(Color.GREEN);
            }
            re.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

}
