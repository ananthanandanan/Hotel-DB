package MenuPage;

import database.DatabaseConnector;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ResourceBundle;

public class insertMenuController implements Initializable {

    @FXML
    private TextField foodField;
    @FXML
    private TextField cuisineidField;
    private PreparedStatement prep_stmt = null;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

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
            AddQuery();
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
    private  void AddQuery(){
        try{
            Class.forName("org.postgresql.Driver");
            Connection connection = DatabaseConnector.getConnnection();
            connection.setAutoCommit(false);
            System.out.println("Opened database successfully");
            prep_stmt = connection.prepareStatement( "INSERT INTO  Menu VALUES(?,?)");
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
