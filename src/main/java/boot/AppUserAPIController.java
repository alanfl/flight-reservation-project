package boot;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.*;

// needed for cross domain Ajax
@CrossOrigin(origins="http://s.codepen.io")
@RestController
public class AppUserAPIController {

    // private static final Logger log = LoggerFactory.getLogger(AppUserAPIController.class);

    @Autowired
    AppUserService aus;

	@RequestMapping(value="/user", method=RequestMethod.GET)
    public Iterable<AppUser> searchAppUsers(
    	@RequestParam(value="name", required=false) String[] names) {
        // name=val1&name=val2 passed as an array
        return aus.searchAppUsers(names);
    }

    // Having AppUser as input will make Spring do the following
    // 1. create a AppUser object and 
    // 2. map client input to object attribute with same name
	@RequestMapping(value="/user", method=RequestMethod.POST)
    public AppUser createAppUser(@RequestBody AppUser auser) {
    	return aus.save(auser);
    }

	@RequestMapping(value="/user/{username}", method=RequestMethod.GET)
    public AppUser getAppUser(@PathVariable("username") String username) {
        return aus.get(username);
    }

	@RequestMapping(value="/user/{id}", method=RequestMethod.PUT)
    public AppUser updateAppUser(@RequestBody AppUser auser) {
        return aus.update(auser);
    }
}
