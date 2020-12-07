package popup_windows;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class AlertBoxController implements Initializable {
    @FXML
    private Pane main_pane;
    public static Label label1;
    @FXML
    private Button okbutton;
    Stage stage;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void display() throws Exception{
        try{
            stage=new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            Parent root=FXMLLoader.load(getClass().getResource("/popup_windows/AlertBox.fxml"));
            Scene scene=new Scene(root);
            stage.setTitle("Error");

            stage.setScene(scene);
            stage.setResizable(false);
            stage.showAndWait();

        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    private Label getLabel1() {
        return label1;
    }

    public void close(ActionEvent Event){
        Stage window= (Stage) ((Node) Event.getSource()).getScene().getWindow();
        window.close();
    }
}
