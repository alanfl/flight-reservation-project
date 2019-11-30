package boot;

import java.security.Principal;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.*;

// Needed for cross domain Ajax
@CrossOrigin(origins="http://s.codepen.io")
@RestController
public class AirportAPIController {

    // private static final Logger log = LoggerFactory.getLogger(AirportAPIController.class);

    @Autowired
    AirportService as;

    // TODO Likely not necessary, re-audit and test
	// @RequestMapping(value="/airport", method=RequestMethod.GET)
    // public Iterable<Airport> searchAirports(
    // 	@RequestParam(value="airport_id", required=false) String[] airport_ids) {
    //     return as.searchAirports(airport_ids);
    // }

    @RequestMapping(value="/airport", method=RequestMethod.GET)
    public Iterable<Airport> get(Principal principal) {
        return as.get();
    }

	@RequestMapping(value="/airport", method=RequestMethod.POST)
    public Airport createAirport(@RequestBody Airport a) {
    	return as.upsert(a);
    }

    // TODO re-audit later on to see if this is necessary
	// @RequestMapping(value="/airport/{airport_id}", method=RequestMethod.GET)
    // public Airport getAirport(@PathVariable("airport_id") String airport_id) {
    //     return as.getAirportById(airport_id);
    // }

	@RequestMapping(value="/airport", method=RequestMethod.PUT)
    public Airport updateAirport(@RequestBody Airport a) {
        return as.upsert(a);
    }

    @RequestMapping(value="/airport", method=RequestMethod.DELETE)
    public Airport deleteAirport(@RequestBody Airport a) {
        as.delete(a);
        return new Airport();
    }
}
