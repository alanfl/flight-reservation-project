package boot;

import org.slf4j.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service 
public class AirlineAirportService{
    @Autowired
    private JdbcTemplate jdbc;
    
    private static final Logger log = LoggerFactory.getLogger(AirlineAirportService.class);
      
    public AirlineAirport save(AirlineAirport airline_airport) {
      jdbc.update("INSERT INTO airline_airport VALUES (?, ?)", 
        airline_airport.getAirlineId(), 
        airline_airport.getAirportId() // arguments
      );
      return airline_airport;
    }
    
    public AirlineAirport get(String airline_id, String airport_id) {
      return (AirlineAirport) jdbc.queryForObject("SELECT * FROM airline_airport WHERE airline_id=? AND airport_id=?", 
        new Object[] { airline_id, airport_id }, // arguments as array
        (rs, rowNum) -> new AirlineAirport(
          rs.getString("airline_id"), 
          rs.getString("airport_id")
        ) // row mapper 
      );
    }
  
    public AirlineAirport update(AirlineAirport airline_airport) {
      jdbc.update("UPDATE airline_airport SET airline_id=?, airport_id=? WHERE airline_id=? AND airport_id=?", 
        airline_airport.getAirlineId(), 
        airline_airport.getAirportId() // arguments
      );
      return airline_airport;
    }
    
    public void delete(String airline_id, String airport_id) {
      jdbc.update("DELETE FROM airline_airport WHERE airline_id=? AND airport_id=?", airline_id, airport_id);
    }
  
    public Iterable<AirlineAirport> searchAirlineAirports(String[] airline_ids, String[] airport_ids ) {
      if (airline_ids != null && airport_ids!=null) {
        return jdbc.query("SELECT * FROM airline_airport WHERE airline_id AND airport_id IN ?", 
          new Object[] { airline_ids, airport_ids }, // arguments as array
          (rs, rowNum) -> new AirlineAirport(
              rs.getString("airline_id"),
              rs.getString("airport_id")
              )
            ); // row mapper
      }
       else {
        return jdbc.query("SELECT * FROM airline_airport",
          new Object[] {}, // arguments as array
          (rs, rowNum) -> new AirlineAirport(
              rs.getString("airline_id"),
              rs.getString("airport_id")
              )
            ); // row mapper
      }
    }
}
