package boot;

public class Airport {
    private String airport_id;
    private String airport_name;
    
    public Airport() {
    }
    
    public Airport(String airport_id) {
        this.airport_id = airport_id;
    }
    
    public Airport(String airport_id, String airport_name) {
        this.airport_id = airport_id;
        this.airport_name = airport_name;
    }
    
    public String getAirportId() {
        return airport_id;
    }
    
    public String getAirportName() {
        return airport_name;
    }
}
