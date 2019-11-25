package boot;

import org.slf4j.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service 
public class AircraftService{
    @Autowired
    private JdbcTemplate jdbc;
    
    private static final Logger log = LoggerFactory.getLogger(AircraftService.class);
      
    public Aircraft save(Aircraft aircraft) {
      jdbc.update("INSERT INTO aircraft (aircraft_id, aircraft_model) VALUES (?, ?)", 
        aircraft.getAircraftId(), aircraft.getAircraftModel() // arguments
      );
      return aircraft;
    }
    
    public Aircraft get(String aircraft_id) {
      return (Aircraft) jdbc.queryForObject("SELECT aircraft_id, aircraft_model FROM aircraft WHERE aircraft_id=?", 
        new Object[] { aircraft_id }, // arguments as array
        (rs, rowNum) -> new Aircraft(
          rs.getString("aircraft_id"), 
          rs.getString("aircraft_model"),
          rs.getString("airline_id")
        ) // row mapper 
      );
    }
    
    public Aircraft update(Aircraft aircraft) {
      jdbc.update("UPDATE aircraft SET aircraft_id=? WHERE aircraft_model=?", 
        aircraft.getAircraftId(), aircraft.getAircraftModel() // arguments
      );
      return aircraft;
    }
    
    public void delete(String aircraft_id) {
      jdbc.update("DELETE FROM aircraft WHERE aircraft_id=?", aircraft_id);
    }
  
    public Iterable<Aircraft> searchAircrafts(String[] aircraft_ids) {
      if (aircraft_ids != null) {
        return jdbc.query("SELECT aircraft_id FROM aircraft where aircraft_id IN ?", 
          new Object[] { aircraft_ids }, // arguments as array
          (rs, rowNum) -> new Aircraft(rs.getString("aircraft_id"))); // row mapper
      } else {
        return jdbc.query("SELECT aircraft_id FROM aircraft",
          new Object[] {}, // arguments as array
          (rs, rowNum) -> new Aircraft(rs.getString("aircraft_id"))); // row mapper
      }
    }
}
