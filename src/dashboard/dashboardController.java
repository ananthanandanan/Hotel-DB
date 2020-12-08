package dashboard;

import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import java.net.URL;
import java.util.ResourceBundle;
import  Transports.Paths;
import javafx.stage.Stage;

public class dashboardController implements Initializable {

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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

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

    public void gotToHome(ActionEvent actionEvent) {
        System.out.println("Home button clicked");

        try {
            Parent root = FXMLLoader.load(getClass().getResource(Paths.DASHBOARDPAGEVIEW));
            Stage window= (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            window.setTitle("Home page");
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
    public void gotoLogin(MouseEvent actionEvent){
        System.out.println("The mouse is clicked");
        try{
            Parent root=FXMLLoader.load(getClass().getResource(Paths.LOGINPAGEVIEW));
            Stage window= (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            window.setTitle("Hotel Management System");
            Scene scene=new Scene(root);
            window.setScene(scene);
            window.show();
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
