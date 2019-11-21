package boot;

public class Airline {
    private String airlineId;
    private String airlineName;
    
    public Airline() {
    }
    
    public Airline(String airlineId) {
        this.airlineId = airlineId;
    }
    
    public AirLine(String airlineId, String airlineName) {
        this.airlineId = airlineId;
        this.airlineName = airlineName;
    }
    
    public String getAirlineId() {
        return airlineId;
    }
    
    public String getAirlineName() {
        return airlineName;
    }
}
