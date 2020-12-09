package ChefsPage;

import database.DatabaseConnector;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import structure.chef;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ResourceBundle;

public class addChefsController implements Initializable {
    @FXML
    private TextField ssnfield;
    @FXML
    private TextField cuisineField;
    @FXML
    private TextField nameField;
    @FXML
    private TextField dojField;
    private PreparedStatement prep_stmt = null;
    private chef editchefs;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


    }

    public void setTextField(chef chefs){
        editchefs = chefs;
        cuisineField.setText(editchefs.getCuisine_id());
        nameField.setText(editchefs.getName());
        dojField.setText(editchefs.getDoj());
        ssnfield.setText(editchefs.getSSN());
    }

    public void save(ActionEvent actionEvent) {
        //open connection

        String name = nameField.getText();
        String cuisineID = cuisineField.getText();
        String doj = cuisineField.getText();
        String ssn = ssnfield.getText();

        if(name.isEmpty() || cuisineID.isEmpty() || doj.isEmpty() ||  ssn.isEmpty()){
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
        cuisineField.setText(null);
        nameField.setText(null);
        dojField.setText(null);
        ssnfield.setText(null);
    }


    private  void UpdateQuery(){
        try{
            Class.forName("org.postgresql.Driver");
            Connection connection = DatabaseConnector.getConnnection();
            connection.setAutoCommit(false);
            System.out.println("Opened database successfully");
            prep_stmt = connection.prepareStatement( "UPDATE chefs SET "
                    +" Cuisine_id=?,"
                    +" DOJ=?,"
                    +" Chef_name=?"
                    +" WHERE SSN=?");
            prep_stmt.setString(1, cuisineField.getText());
            prep_stmt.setString(2, dojField.getText());
            prep_stmt.setString(3,nameField.getText());
            prep_stmt.setString(4, ssnfield.getText());
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
