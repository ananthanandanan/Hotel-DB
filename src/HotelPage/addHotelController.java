package HotelPage;

import database.DatabaseConnector;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import structure.Hotel;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ResourceBundle;

public class addHotelController implements Initializable {
    @FXML
    private TextField nameField;
    @FXML
    private TextField revenueField;
    @FXML
    private TextField stateField;
    @FXML
    private TextField dateField;
    private PreparedStatement prep_stmt = null;
    private Hotel edithotel;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    public void setTextField(Hotel hotel){
        edithotel= hotel;
        nameField.setText(edithotel.getHotel_name());
        revenueField.setText(Float.toString(edithotel.getRevenue_planned()));
        stateField.setText(edithotel.getState());
        dateField.setText(edithotel.getDate());
    }

    public void save(ActionEvent actionEvent) {
        //open connection

        String name = nameField.getText();
        Float revenue = Float.parseFloat(revenueField.getText());
        String date = dateField.getText();
        String state = stateField.getText();

        if(name.isEmpty() || revenue.isNaN() || date.isEmpty() ||  state.isEmpty()){
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
        revenueField.setText(null);
        nameField.setText(null);
        dateField.setText(null);
        stateField.setText(null);
    }


    private  void UpdateQuery(){
        try{
            Class.forName("org.postgresql.Driver");
            Connection connection = DatabaseConnector.getConnnection();
            connection.setAutoCommit(false);
            System.out.println("Opened database successfully");
            prep_stmt = connection.prepareStatement( "UPDATE Hotel SET "
                    +" Revenue_planned=?,"
                    +" State=?,"
                    +" Start_date=?"
                    +" WHERE Hotel_name=?");
            prep_stmt.setFloat(1, Float.parseFloat(revenueField.getText()));
            prep_stmt.setString(2, stateField.getText());
            prep_stmt.setString(3,dateField.getText());
            prep_stmt.setString(4, nameField.getText());
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
