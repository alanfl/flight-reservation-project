package boot;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.*;

// Needed for cross domain Ajax
@CrossOrigin(origins="http://s.codepen.io")
@RestController
public class AirlineAPIController {

    // private static final Logger log = LoggerFactory.getLogger(AirlineAPIController.class);

  @Autowired
  AirlineService as;

	@RequestMapping(value="/airline", method=RequestMethod.GET)
    public Iterable<Airline> searchAirlines(
    	@RequestParam(value="airline_id", required=false) String[] airline_ids) {
        return as.searchAirlines(airline_ids);
    }

	@RequestMapping(value="/airline", method=RequestMethod.POST)
    public Airline createAirline(@RequestBody Airline a) {
    	return as.save(a);
    }

	@RequestMapping(value="/airline/{airline_id}", method=RequestMethod.GET)
    public Airline getAirline(@PathVariable("airline_id") String airline_id) {
        return as.get(airline_id);
    }

	@RequestMapping(value="/airline/{airline_id}", method=RequestMethod.PUT)
    public Airline updateAirline(@RequestBody Airline a) {
        return as.update(a);
    }

    	@RequestMapping(value="/airline", method=RequestMethod.DELETE)
    public void deleteAirline(@PathVariable("airline_id") String airline_id) {
        as.delete(airline_id);
    }
}
