package structure;


public class Hotel {

    String hotel_name ;
    float revenue_planned;
    String state;
    String date;

    public  Hotel(String hotel_name, float revenue_planned, String state, String date){
        this.hotel_name = hotel_name;
        this.revenue_planned = revenue_planned;
        this.state = state;
        this.date = date;

    }

    public  Hotel(String hotel_name){
        this.hotel_name=hotel_name;
    }
    public Hotel(){}






    //Getters
    public  String getHotel_name(){
        return  hotel_name;
    }
    public  float getRevenue_planned(){
        return  revenue_planned;
    }
    public  String getState(){
        return  state;
    }
    public  String getDate(){
        return  date;
    }
    //Setters
    public void setHotel_name(String hotel_name) {
        this.hotel_name = hotel_name;;
    }
    public void setRevenue_planned(float revenue_planned) {
       this.revenue_planned = revenue_planned;
    }
    public void setState(String state) {
        this.state = state;
    }
    public void setDate(String date) {
        this.date = date;
    }

}
