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
      jdbc.update("INSERT INTO airport VALUES (?, ?)", 
        airport.getAirportId(), 
        airport.getAirportName() // arguments
      );
      return airport;
    }
    
    public Airport get(String airport_id) {
      return (Airport) jdbc.queryForObject("SELECT * FROM airport WHERE airport_id=?", 
        new Object[] { airport_id }, // arguments as array
        (rs, rowNum) -> new Airport(
          rs.getString("airport_id"), 
          rs.getString("airport_name")
        ) // row mapper 
      );
    }
    
    public Airport update(Airport airport) {
      jdbc.update("UPDATE airport SET airport_id=?, airport_name=? WHERE airport_id=?", 
        airport.getAirportId(), 
        airport.getAirportName() // arguments
      );
      return airport;
    }
    
    public void delete(String airport_id) {
      jdbc.update("DELETE FROM airport WHERE airport_id=?", airport_id);
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
