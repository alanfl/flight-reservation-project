package boot;

import org.slf4j.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service 
public class AirportService{
    @Autowired
    private JdbcTemplate jdbc;
    
    private static final Logger log = LoggerFactory.getLogger(AirportService.class);
    
    // TODO re-audit this at some point, see if it can be removed or if it will still be necessary
    public Airport save(Airport airport) {
      jdbc.update("INSERT INTO airport (airport_id, airport_name) VALUES (?, ?)", 
        airport.getAirportId(), 
        airport.getAirportName() // arguments
      );
      return airport;
    }
    
    // Get all airports
    public Iterable<Airport> get() {
      return jdbc.query("SELECT airport_id, airport_name FROM airport",
        new Object[] { }, // pass args as array
        (rs, rowNum) -> new Airport(
          rs.getString("airport_id"),
          rs.getString("airport_name")
        )
      );
    }

    // Get specific airport by id
    public Airport getAirportById(String airport_id) {
      return (Airport) jdbc.queryForObject("SELECT * FROM airport WHERE airport_id=?", 
        new Object[] { airport_id }, // arguments as array
        (rs, rowNum) -> new Airport(
          rs.getString("airport_id"), 
          rs.getString("airport_name")
        ) // row mapper 
      );
    }
    
    // Augmenting update to insert new airports if necessary
    public Airport upsert(Airport airport) {
      jdbc.update("INSERT INTO airport(airport_id, airport_name) "
        + "VALUES(? ?) ON DUPLICATE KEY UPDATE "
        + "airport_id=?, airport_name=?", 
        airport.getAirportId(), airport.getAirportName(),
        airport.getAirportId(), airport.getAirportName() // arguments
      );
      return airport;
    }
    
    public void delete(Airport airport) {
      jdbc.update("DELETE FROM airport WHERE airport_id=?", airport.getAirportId());
    }
  
    public Iterable<Airport> searchAirports(String[] airport_ids) {
      if (airport_ids != null) {
        return jdbc.query("SELECT * FROM airport WHERE airport_id IN ?", 
          new Object[] { airport_ids }, // arguments as array
          (rs, rowNum) -> new Airport(
              rs.getString("airport_id"),
              rs.getString("airport_name")
              )
            ); // row mapper
      } else {
        return jdbc.query("SELECT * FROM airport",
          new Object[] {}, // arguments as array
          (rs, rowNum) -> new Airport(
              rs.getString("airport_id"),
              rs.getString("airport_name")
              )
            ); // row mapper
      }
    }
}
