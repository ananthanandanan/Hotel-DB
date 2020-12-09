package MenuPage;

import database.DatabaseConnector;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import structure.Hotel;
import structure.menu;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ResourceBundle;

public class addMenuController implements Initializable {

    @FXML
    private TextField foodField;
    @FXML
    private TextField cuisineidField;
    private PreparedStatement prep_stmt = null;
    private menu edimenu;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void setTextField(menu menus){
        edimenu= menus;
        foodField.setText(edimenu.getFood_item());
        cuisineidField.setText(edimenu.getCuisine_id());
    }

    public void save(ActionEvent actionEvent) {
        //open connection

        String food = foodField.getText();
        String cuisine = cuisineidField.getText();

        if(cuisine.isEmpty() || food.isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Please Fill All DATA");
            alert.showAndWait();
        }
        else {
            UpdateQuery();
            clean();
            Stage window= (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            window.close();

        }

    }
    @FXML
    private void clean() {
        foodField.setText(null);
        cuisineidField.setText(null);
    }


    private  void UpdateQuery(){
        try{
            Class.forName("org.postgresql.Driver");
            Connection connection = DatabaseConnector.getConnnection();
            connection.setAutoCommit(false);
            System.out.println("Opened database successfully");
            prep_stmt = connection.prepareStatement( "UPDATE Menu SET "
                    +" Food_Item=?"
                    +" WHERE Cuisine_id=?");
            prep_stmt.setString(1,foodField.getText());
            prep_stmt.setString(2, cuisineidField.getText());
            int i = prep_stmt.executeUpdate();
            connection.commit();
            System.out.println(i+" records affected");
            connection.close();

        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

}
