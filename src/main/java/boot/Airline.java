package boot;

public class Airline {
    private String airline_Id;
    private String airline_Name;
    
    public Airline() {
    }
    
    public Airline(String airline_Id) {
        this.airline_Id = airline_Id;
    }
    
    public Airline(String airline_Id, String airline_Name) {
        this.airline_Id = airline_Id;
        this.airline_Name = airline_Name;
    }
    
    public String getAirline_Id() {
        return airline_Id;
    }
    
    public String getAirline_Name() {
        return airline_Name;
    }
}
