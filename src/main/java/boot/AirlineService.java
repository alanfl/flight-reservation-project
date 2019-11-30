package boot;

import org.slf4j.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service 
public class AirlineService {
  @Autowired
  private JdbcTemplate jdbc;
    
  private static final Logger log = LoggerFactory.getLogger(AirlineService.class);
      
  public Airline save(Airline airline) {
    jdbc.update("INSERT INTO airline (airline_id, airline_name) VALUES (?, ?)", 
      airline.getAirlineId(), 
      airline.getAirlineName() // arguments
    );
    return airline;
  }
    
  public Airline get(String airline_id) {
    return (Airline) jdbc.queryForObject("SELECT * FROM airline WHERE airline_id=?", 
      new Object[] { airline_id }, // arguments as array
      (rs, rowNum) -> new Airline(
        rs.getString("airline_id"), 
        rs.getString("airline_name")
      ) // row mapper 
    );
  }
    
  public Airline update(Airline airline) {
    jdbc.update("UPDATE airline SET airline_id=?, airline_name=? WHERE airline_id=?", 
      airline.getAirlineId(), 
      airline.getAirlineName() // arguments
    );
    return airline;
  }
    
  public void delete(String airline_id) {
    jdbc.update("DELETE FROM airline WHERE airline_id=?", airline_id);
  }
  
  public Iterable<Airline> searchAirlines(String[] airline_ids) {
    if (airline_ids != null) {
      return jdbc.query("SELECT * FROM airline WHERE airline_id IN ?", 
        new Object[] { airline_ids }, // arguments as array
        (rs, rowNum) -> new Airline(
            rs.getString("airline_id"),
            rs.getString("airline_name")
            )
          ); // row mapper
    } else {
      return jdbc.query("SELECT * FROM airline",
        new Object[] {}, // arguments as array
        (rs, rowNum) -> new Airline(
            rs.getString("airline_id"),
            rs.getString("airline_name")
            )
          ); // row mapper
    }
  }

  public Iterable<Airline> getAirlines() {
    return jdbc.query("SELECT airline_id, airline_name FROM airline",
      new Object[] { }, // pass in args as an array
        (rs, rowNum) -> new Airline(
          rs.getString("airline_id"), 
          rs.getString("airline_name"))
    );
  }
}
