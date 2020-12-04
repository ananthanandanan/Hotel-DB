package structure;

import java.util.Date;

public class employee {
    private String SSN;
    private String name;
    private Date doj;
    private String designation;

    public employee(String SSN,String name,Date doj,String designation)
    {
        this.SSN=SSN;
        this.name=name;
        this.doj=doj;
        this.designation=designation;
    }

    public employee(){}


    //getters

    public String get_ssn() {return SSN;}
    public String get_name() {return name;}
    public Date get_doj(){return doj;}
    public String get_designation(){return designation;}

    //setters

    public void set_ssn(String SSN)
    {
        this.SSN=SSN;
    }

    public void set_name(String name)
    {
        this.name=name;
    }

    public void set_doj(Date doj)
    {
        this.doj=doj;
    }

    public void set_designation(String designation)
    {
        this.designation=designation;
    }





}
