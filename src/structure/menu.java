package structure;

import javafx.beans.property.SimpleStringProperty;

public class menu extends cuisine  {
    SimpleStringProperty food_item;

    public menu( String food_item, String cuisine_id) {
        super(cuisine_id);
        this.food_item = new SimpleStringProperty(food_item);
    }


    public String getFood_item() {
        return food_item.get();
    }

    public SimpleStringProperty food_itemProperty() {
        return food_item;
    }

    public void setFood_item(String food_item) {
        this.food_item.set(food_item);
    }
}
