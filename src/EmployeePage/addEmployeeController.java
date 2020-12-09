package EmployeePage;

import database.DatabaseConnector;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import structure.chef;
import structure.employee;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ResourceBundle;

public class addEmployeeController implements Initializable {

    @FXML
    private TextField ssidfield;
    @FXML
    private TextField nameField;
    @FXML
    private TextField dojField;
    @FXML
    private TextField desigField;
    private PreparedStatement prep_stmt = null;
    private  employee editemployee;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void setTextField(employee employees){
         editemployee= employees;
        ssidfield.setText(editemployee.getSSN());
        nameField.setText(editemployee.getName());
        dojField.setText(editemployee.getDoj());
        desigField.setText(editemployee.getDesignation());
    }

    public void save(ActionEvent actionEvent) {
        //open connection

        String name = nameField.getText();
        String ssid = ssidfield.getText();
        String doj = dojField.getText();
        String designation = desigField.getText();

        if(name.isEmpty() || designation.isEmpty() || doj.isEmpty() ||  ssid.isEmpty()){
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
        desigField.setText(null);
        nameField.setText(null);
        dojField.setText(null);
        ssidfield.setText(null);
    }


    private  void UpdateQuery(){
        try{
            Class.forName("org.postgresql.Driver");
            Connection connection = DatabaseConnector.getConnnection();
            connection.setAutoCommit(false);
            System.out.println("Opened database successfully");
            prep_stmt = connection.prepareStatement( "UPDATE Employee SET "
                    +" designation=?,"
                    +" ename=?,"
                    +" DOJ=?"
                    +" WHERE SSID=?");
            prep_stmt.setString(1, desigField.getText());
            prep_stmt.setString(2, nameField.getText());
            prep_stmt.setString(3,dojField.getText());
            prep_stmt.setString(4, ssidfield.getText());
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
