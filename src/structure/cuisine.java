package structure;

import javafx.beans.property.SimpleStringProperty;

public class cuisine {
    SimpleStringProperty cuisine_id;
    SimpleStringProperty Cuisine;


    public cuisine(String cuisine_id) {
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

    public String getCuisine() {
        return Cuisine.get();
    }

    public SimpleStringProperty cuisineProperty() {
        return Cuisine;
    }

    public void setCuisine(String cuisine) {
        this.Cuisine.set(cuisine);
    }
}
