package HotelPage;

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

public class insertHotelController implements Initializable {

    @FXML
    private TextField nameField;
    @FXML
    private TextField revenueField;
    @FXML
    private TextField stateField;
    @FXML
    private TextField dateField;
    private PreparedStatement prep_stmt = null;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

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
            AddQuery();
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

    private  void AddQuery(){
        try{
            Class.forName("org.postgresql.Driver");
            Connection connection = DatabaseConnector.getConnnection();
            connection.setAutoCommit(false);
            System.out.println("Opened database successfully");
            prep_stmt = connection.prepareStatement( "INSERT INTO  Hotel VALUES(?,?,?,?)");
            prep_stmt.setString(1, nameField.getText());
            prep_stmt.setFloat(2, Float.parseFloat(revenueField.getText()));
            prep_stmt.setString(3, stateField.getText());
            prep_stmt.setString(4, dateField.getText());
            int i = prep_stmt.executeUpdate();
            System.out.println(i+" records affected");
            connection.commit();
            connection.close();

        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

}
