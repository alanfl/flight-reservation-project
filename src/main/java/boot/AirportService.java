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
      
    public Airport save(Airport airport) {
      jdbc.update("INSERT INTO airport (airport_id, airport_name) VALUES (?, ?)", 
        airport.getAirportId(), airport.getAirportName() // arguments
      );
      return airport;
    }
    
    public Airport get(String airport_id) {
      return (Airport) jdbc.queryForObject("SELECT airport_id, airport_name FROM airport WHERE airport_id=?", 
        new Object[] { airport_id }, // arguments as array
        (rs, rowNum) -> new Airport(
          rs.getString("airport_id"), 
          rs.getString("airport_name")
        ) // row mapper 
      );
    }
    
    public Airport update(Airport airport) {
      jdbc.update("UPDATE airport SET airport_id=? WHERE airport_name=?", 
        airline.getAirportId(), airline.getAirportName() // arguments
      );
      return airport;
    }
    
    public void delete(String airport_id) {
      jdbc.update("DELETE FROM airport WHERE airport_id=?", airport_id);
    }
  
    public Iterable<Airport> searchAirports(String[] airport_ids) {
      if (airport_ids != null) {
        return jdbc.query("SELECT airport_id FROM airport where airport_id IN ?", 
          new Object[] { airport_ids }, // arguments as array
          (rs, rowNum) -> new Airport(rs.getString("airport_id"))); // row mapper
      } else {
        return jdbc.query("SELECT airport_id FROM airport",
          new Object[] {}, // arguments as array
          (rs, rowNum) -> new Airport(rs.getString("airport_id"))); // row mapper
      }
    }
}
