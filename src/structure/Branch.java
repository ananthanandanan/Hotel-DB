package structure;

import javafx.beans.property.SimpleStringProperty;

public class Branch extends Hotel {

    SimpleStringProperty branch_name;
    Float expenditure;
    SimpleStringProperty city;
    SimpleStringProperty SSN;

    public Branch(String hotel_name, String branch_name, Float expenditure, String city, String SSN)
    {
        super(hotel_name);
        this.branch_name= new SimpleStringProperty(branch_name);
        this.expenditure=expenditure;
        this.city= new SimpleStringProperty(city);
        this.SSN= new SimpleStringProperty(SSN);
    }

    public Branch(){}

    public String getBranch_name() {
        return branch_name.get();
    }

    public SimpleStringProperty branch_nameProperty() {
        return branch_name;
    }

    public void setBranch_name(String branch_name) {
        this.branch_name.set(branch_name);
    }

    public Float getExpenditure() {
        return expenditure;
    }

    public void setExpenditure(Float expenditure) {
        this.expenditure = expenditure;
    }

    public String getCity() {
        return city.get();
    }

    public SimpleStringProperty cityProperty() {
        return city;
    }

    public void setCity(String city) {
        this.city.set(city);
    }

    public String getSSN() {
        return SSN.get();
    }

    public SimpleStringProperty SSNProperty() {
        return SSN;
    }

    public void setSSN(String SSN) {
        this.SSN.set(SSN);
    }
}
