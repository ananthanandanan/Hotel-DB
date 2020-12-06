package ChefsPage;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

public class ChefsPageController implements Initializable {

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
}
