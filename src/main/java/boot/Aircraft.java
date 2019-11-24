package boot;

public class Aircraft {
    private String aircraft_id;
    private String aircraft_model;
    
    public Aircraft() {
    }
    
    public Aircraft(String aircraft_id) {
        this.aircraft_id = aircraft_id;
    }
    
    public Aircraft(String aircraft_id, String aircraft_model) {
        this.aircraft_id = aircraft_id;
        this.aircraft_model = aircraft_model;
    }
    
    public String getAircraftId() {
        return aircraft_id;
    }
    
    public String getAircraftModel() {
        return aircraft_model;
    }
}
