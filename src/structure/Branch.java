package structure;

public class Branch extends Hotel {

    private String branch_name;
    private float expenditure;
    private String city;
    private String SSN;

    public Branch(String hotel_name,String branch_name,float expenditure,String city,String SSN)
    {
        super(hotel_name);
        this.branch_name=branch_name;
        this.expenditure=expenditure;
        this.city=city;
        this.SSN=SSN;
    }

    public Branch(){}





    //getters
    public String get_branch_name() { return branch_name; }
    public float get_expenditure() { return expenditure; }
    public String get_city() { return city; }
    public String get_ssn() { return SSN; }


    //setters
    public void set_branch_name(String branch_name)
    {
        this.branch_name=branch_name;
    }
    public void set_city(String city)
    {
        this.city=city;
    }
    public void set_ssn(String branch_name)
    {
        this.SSN=SSN;
    }
    public void set_expenditure(float expenditure)
    {
        this.expenditure=expenditure;
    }





}
