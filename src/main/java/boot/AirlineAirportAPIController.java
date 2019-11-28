package boot;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.*;

// Needed for cross domain Ajax
@CrossOrigin(origins="http://s.codepen.io")
@RestController
public class AirlineAirportAPIController {

    // private static final Logger log = LoggerFactory.getLogger(AirlineAirportAPIController.class);

  @Autowired
  AirlineAirportService aas;
    //Unsure about this one
	@RequestMapping(value="/airline_airport", method=RequestMethod.GET)
    public Iterable<AirlineAirport> searchAirlineAirports(
    	@RequestParam(value="airline_id, airport_ids", required=false) String[] airline_ids, String[] airport_ids) {
        return aas.searchAirlineAirports(airline_ids, airport_ids);
    }

	@RequestMapping(value="/airline_airport", method=RequestMethod.POST)
    public AirlineAirport createAirlineAirport(@RequestBody AirlineAirport aa) {
    	return aas.save(aa);
    }

	@RequestMapping(value="/airline_airport/{airline_id, airport_id}", method=RequestMethod.GET)
    public AirlineAirport getAirlineAirport(@PathVariable("airline_id, airport_id") String airline_id, String airport_id) {
        return aas.get(airline_id, airport_id);
    }

	@RequestMapping(value="/airline_airport/{airline_id, airport_id}", method=RequestMethod.PUT)
    public AirlineAirport updateAirlineAirport(@RequestBody AirlineAirport aa) {
        return aas.update(aa);
    }

    @RequestMapping(value="/airline_airport", method=RequestMethod.DELETE)
    public void deleteAirlineAirport(@PathVariable("airline_id, airport_id") String airline_id, String airport_id) {
        aas.delete(airline_id, airport_id);
    }
}
