package boot;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.*;

// Needed for cross domain Ajax
@CrossOrigin(origins="http://s.codepen.io")
@RestController
public class AircraftAPIController {

    // private static final Logger log = LoggerFactory.getLogger(AircraftAPIController.class);

  @Autowired
  AircraftService as;

	@RequestMapping(value="/aircraft", method=RequestMethod.GET)
    public Iterable<Aircraft> searchAircrafts(
    	@RequestParam(value="aircraft_id", required=false) String[] aircraft_ids) {
        return as.searchAircrafts(aircraft_ids);
    }

	@RequestMapping(value="/aircraft", method=RequestMethod.POST)
    public Aircraft createAircraft(@RequestBody Aircraft a) {
    	return as.save(a);
    }

	@RequestMapping(value="/aircraft/{aircraft_id}", method=RequestMethod.GET)
    public Aircraft getAircraft(@PathVariable("aircraft_id") String aircraft_id) {
        return as.get(aircraft_id);
    }

	@RequestMapping(value="/aircraft/{aircraft_id}", method=RequestMethod.PUT)
    public Aircraft updateAircraft(@RequestBody Aircraft a) {
        return as.update(a);
    }

    @RequestMapping(value="/aircraft/{aircraft_id}", method=RequestMethod.DELETE)
    public void deleteAircraft(@PathVariable("aircraft_id") String aircraft_id) {
        as.delete(aircraft_id);
    }
}
