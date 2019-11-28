package boot;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.*;

// Needed for cross domain Ajax
@CrossOrigin(origins="http://s.codepen.io")
@RestController
public class AirportAPIController {

    // private static final Logger log = LoggerFactory.getLogger(AirportAPIController.class);

  @Autowired
  AirportService as;

	@RequestMapping(value="/airport", method=RequestMethod.GET)
    public Iterable<Airport> searchAirports(
    	@RequestParam(value="airport_id", required=false) String[] airport_ids) {
        return as.searchAirports(airport_ids);
    }

	@RequestMapping(value="/airport", method=RequestMethod.POST)
    public Airport createAirport(@RequestBody Airport a) {
    	return as.save(a);
    }

	@RequestMapping(value="/airport/{airport_id}", method=RequestMethod.GET)
    public Airport getAirport(@PathVariable("airport_id") String airport_id) {
        return as.get(airport_id);
    }

	@RequestMapping(value="/airport/{airport_id}", method=RequestMethod.PUT)
    public Airport updateAirport(@RequestBody Airport a) {
        return as.update(a);
    }

    @RequestMapping(value="/airport", method=RequestMethod.DELETE)
    public void deleteAirport(@PathVariable("airport_id") String airport_id) {
        as.delete(airport_id);
    }
}
