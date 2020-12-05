package dashboard;

import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

public class dashboardController implements Initializable {
    @FXML
    private BorderPane BorderPane;
    @FXML
    private VBox Vox;
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
    }
    @FXML
    public void goToChefs(ActionEvent actionEvent) {
    }
    @FXML
    public void goToBranch(ActionEvent actionEvent) {
    }
    @FXML
    public void gotToMenu(ActionEvent actionEvent) {
    }
    @FXML
    public void gotToEmployee(ActionEvent actionEvent) {
    }
}
