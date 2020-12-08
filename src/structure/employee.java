package structure;

import javafx.beans.property.SimpleStringProperty;

import java.util.Date;

public class employee {
    SimpleStringProperty SSN;
    SimpleStringProperty name;
    SimpleStringProperty doj;
    SimpleStringProperty designation;

    public employee(String SSN,String name,String doj,String designation)
    {
        this.SSN= new SimpleStringProperty(SSN);
        this.name= new SimpleStringProperty(name);
        this.doj= new SimpleStringProperty(doj);
        this.designation= new SimpleStringProperty(designation);
    }

    public employee(String SSN,String name,String doj)
    {
        this.SSN= new SimpleStringProperty(SSN);
        this.name= new SimpleStringProperty(name);
        this.doj= new SimpleStringProperty(doj);
    }

    public employee(){}

    public String getSSN() {
        return SSN.get();
    }

    public SimpleStringProperty SSNProperty() {
        return SSN;
    }

    public void setSSN(String SSN) {
        this.SSN.set(SSN);
    }

    public String getName() {
        return name.get();
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getDoj() {
        return doj.get();
    }

    public SimpleStringProperty dojProperty() {
        return doj;
    }

    public void setDoj(String doj) {
        this.doj.set(doj);
    }

    public String getDesignation() {
        return designation.get();
    }

    public SimpleStringProperty designationProperty() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation.set(designation);
    }
}
