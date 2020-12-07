package login;

import Transports.Paths;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import popup_windows.AlertBoxController;


import java.net.URL;
import java.util.ResourceBundle;

public class loginController extends AlertBoxController implements Initializable {

    public AnchorPane main_pane;
    public TextField username;
    public PasswordField password;
    public Button loginbutton;


    public void OnLogin(ActionEvent Event){
        if(validate()) {
            try {
                Parent root=FXMLLoader.load(getClass().getResource(Paths.DASHBOARDPAGEVIEW));
                Scene scene=new Scene(root);
                Stage window= (Stage) ((Node) Event.getSource()).getScene().getWindow();
                window.setScene(scene);
                window.setHeight(600);
                window.setWidth(800);

                window.setTitle("Welcome");
                window.show();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else{
            try{
                display();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) { ;
    }

    public boolean validate(){
        if(username.getText().equals("admin")&&password.getText().equals("admin")){
            return true;
        }
        return false;
    }
}
