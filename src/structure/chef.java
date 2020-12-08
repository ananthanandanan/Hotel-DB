package structure;

import javafx.beans.property.SimpleStringProperty;

public class chef extends employee{
    SimpleStringProperty cuisine_id;

    public chef(String SSN, String name, String doj,  String cuisine_id) {
        super(SSN, name, doj);
        this.cuisine_id = new SimpleStringProperty(cuisine_id);
    }

    public String getCuisine_id() {
        return cuisine_id.get();
    }

    public SimpleStringProperty cuisine_idProperty() {
        return cuisine_id;
    }

    public void setCuisine_id(String cuisine_id) {
        this.cuisine_id.set(cuisine_id);
    }
}
