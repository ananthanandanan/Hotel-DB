package structure;


import javafx.beans.property.SimpleStringProperty;

public class Hotel {

    SimpleStringProperty hotel_name ;
    Float revenue_planned;
    SimpleStringProperty state;
    SimpleStringProperty date;

    public  Hotel(String hotel_name, Float revenue_planned, String state, String date){
        this.hotel_name = new SimpleStringProperty(hotel_name);
        this.revenue_planned = revenue_planned;
        this.state =  new SimpleStringProperty(state);
        this.date = new SimpleStringProperty(date);

    }

    public  Hotel(String hotel_name){

        this.hotel_name= new SimpleStringProperty(hotel_name);
    }
    public Hotel(){}

    public String getHotel_name() {
        return hotel_name.get();
    }

    public SimpleStringProperty hotel_nameProperty() {
        return hotel_name;
    }

    public void setHotel_name(String hotel_name) {
        this.hotel_name.set(hotel_name);
    }

    public Float getRevenue_planned() {
        return revenue_planned;
    }

    public void setRevenue_planned(Float revenue_planned) {
        this.revenue_planned = revenue_planned;
    }

    public String getState() {
        return state.get();
    }

    public SimpleStringProperty stateProperty() {
        return state;
    }

    public void setState(String state) {
        this.state.set(state);
    }

    public String getDate() {
        return date.get();
    }

    public SimpleStringProperty dateProperty() {
        return date;
    }

    public void setDate(String date) {
        this.date.set(date);
    }
}
