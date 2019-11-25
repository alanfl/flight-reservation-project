package boot;

public class Aircraft {
    private String aircraft_id;
    private String aircraft_model;
    private String airline_id;
    
    public Aircraft() {
    }
    
    public Aircraft(String aircraft_id) {
        this.aircraft_id = aircraft_id;
    }
    
    public Aircraft(String aircraft_id, String aircraft_model, String airline_id) {
        this.aircraft_id = aircraft_id;
        this.aircraft_model = aircraft_model;
        this.airline_id = airline_id;
    }
    
    public String getAircraftId() {
        return aircraft_id;
    }
    
    public String getAircraftModel() {
        return aircraft_model;
    }
    
    public String getAirlineId() {
        return airline_id;
    }
}
