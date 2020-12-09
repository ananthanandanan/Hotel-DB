package ChefsPage;

import BranchPage.addBranchController;
import BranchPage.insertBranchController;
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
import structure.Branch;
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
    private Label invalidLabel;
    @FXML
    private TableView<Branch> branchTable;
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
    public void gotoLogin(MouseEvent actionEvent) {
        new dashboard.dashboardController().gotoLogin(actionEvent);
    }

    public void Editcol(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader ();
            loader.setLocation(getClass().getResource(Paths.EDITCHEFSVIEW));
            Parent root = loader.load();
            Scene scene = new Scene(root,513, 544);
            addChefsController abc = loader.getController();
            abc.setTextField(chefsTable.getSelectionModel().getSelectedItem());

            Stage window= new Stage();
            window.setTitle("chef page");
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
            loader.setLocation(getClass().getResource(Paths.INSERTCHEFSVIEW));
            Parent root = loader.load();
            Scene scene = new Scene(root,513, 544);
            insertChefsController abc = loader.getController();
            Stage window= new Stage();
            window.setTitle("chef page");
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
        try
        {
            Connection connection = DatabaseConnector.getConnnection();
            connection.setAutoCommit(false);
            System.out.println("Opened database successfully");

            chef d1 =chefsTable.getSelectionModel().getSelectedItem();
            prep_stmt=connection.prepareStatement("Select * from  Branch where SSN=?");
            prep_stmt.setString(1,d1.getSSN());
            re=prep_stmt.executeQuery();

            if(re.next())
            {
                invalidLabel.setText("Data in Branch Table!");
                invalidLabel.setTextFill(Color.RED);
            }

            else{
                prep_stmt=connection.prepareStatement("Delete from chefs where SSN=?");
                prep_stmt.setString(1,d1.getSSN());
                int i = prep_stmt.executeUpdate();
                connection.commit();
                System.out.println(i+" records affected");
                connection.close();
                invalidLabel.setText("Deletion successful!");
                invalidLabel.setTextFill(Color.GREEN);
            }
            re.close();
        }
        catch(Exception e) {
            e.printStackTrace();
        }

        }

    }


