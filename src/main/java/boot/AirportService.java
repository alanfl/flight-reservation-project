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
}
