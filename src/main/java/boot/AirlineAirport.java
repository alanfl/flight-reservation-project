package boot;

public class AirlineAirport {
    private String airline_id;
    private String airport_id;
    
    public AirlineAirport() {
    }
    
    public AirlineAirport(String airline_id, String airport_id) {
        this.airline_id = airline_id;
        this.airport_id = airport_id;
    }
    
    public String getAirlineId() {
        return airline_id;
    }
    
    public String getAirportId() {
        return airport_id;
    }
}
