package BranchPage;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import structure.Branch;
 import database.DatabaseConnector;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class addBranchController  implements Initializable {

    @FXML
    private TextField hotelnameField;
    @FXML
    private TextField branchnameField;
    @FXML
    private TextField expenditureField;
    @FXML
    private TextField cityField;
    @FXML
    private TextField ssnfield;
    private PreparedStatement prep_stmt = null;
    private ResultSet re = null;
    private Branch editBranch;
    
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
                
    }

    public void setTextField(Branch branch){
        editBranch = branch;
        hotelnameField.setText(editBranch.getHotel_name());
        branchnameField.setText(editBranch.getBranch_name());
        expenditureField.setText( Float.toString(editBranch.getExpenditure()));
        cityField.setText(editBranch.getCity());
        ssnfield.setText(editBranch.getSSN());
    }

    public void save(ActionEvent actionEvent) {
        //open connection
        String hname = hotelnameField.getText();
        String bname = branchnameField.getText();
        Float exp = Float.parseFloat(expenditureField.getText());
        String city = cityField.getText();
        String ssn = ssnfield.getText();

        if(hname.isEmpty() || bname.isEmpty() || exp.isNaN() || city.isEmpty() || ssn.isEmpty()){
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
        hotelnameField.setText(null);
        branchnameField.setText(null);
        expenditureField.setText(null);
        cityField.setText(null);
        ssnfield.setText(null);
    }


    private  void UpdateQuery(){
        try{
            Class.forName("org.postgresql.Driver");
            Connection connection = DatabaseConnector.getConnnection();
            connection.setAutoCommit(false);
            System.out.println("Opened database successfully");
            prep_stmt = connection.prepareStatement( "UPDATE Branch SET "
                    + " Hotel_name=?,"
                    +" Branch_name=?,"
                    +" Expenditure=?,"
                    +" City=?"
                    +" WHERE SSN=?");
            prep_stmt.setString(1, hotelnameField.getText());
            prep_stmt.setString(2, branchnameField.getText());
            prep_stmt.setFloat(3, Float.parseFloat(expenditureField.getText()));
            prep_stmt.setString(4, cityField.getText());
            prep_stmt.setString(5, ssnfield.getText());
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
