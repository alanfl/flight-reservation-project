package boot;

import org.slf4j.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service 
public class AirlineService{
    @Autowired
    private JdbcTemplate jdbc;
    
      private static final Logger log = LoggerFactory.getLogger(AirlineService.class);
      
    public Airline save(Airline airline) {
    jdbc.update("INSERT INTO airline (airline_Id, airline_Name) VALUES (?, ?)", 
      airline.getAirline_id(), airline.getAirline_name() // arguments
    );
    return airline;
    }
    
    public Airline get(String airline_id) {
    return (Airline) jdbc.queryForObject("SELECT airline_id, airline_name FROM airline WHERE airline_id=?", 
      new Object[] { airline_id }, // arguments as array
      (rs, rowNum) -> new Airline(
        rs.getString("airline_id"), 
        rs.getString("airline_name")
      ) // row mapper 
    );
    }
    
    public void delete(String airline_id) {
    jdbc.update("DELETE FROM airline WHERE airline_id=?", airline_id);
    }
  
    public Iterable<Airline> searchAirline(String[] names) {
    if (names != null) {
      return jdbc.query("SELECT airline_id FROM airline where username IN ?", 
        new Object[] { names }, // arguments as array
        (rs, rowNum) -> new Airline(rs.getString("airline_id"))); // row mapper
    } else {
      return jdbc.query("SELECT airline_id FROM airline",
        new Object[] {}, // arguments as array
        (rs, rowNum) -> new Airline(rs.getString("airline_id"))); // row mapper
    }
  }
}
