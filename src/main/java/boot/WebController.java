package boot;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;

import org.slf4j.*;

@Controller
public class WebController {

    @Autowired
    AppUserService aus;

    private static final Logger log = LoggerFactory.getLogger(WebController.class);

    @RequestMapping("/")
    public String greeting(
        @RequestParam(value="name", required=false, defaultValue="World") String name,
        Model model) 
    {
    	// put result in model
        // model.addAttribute("name", name);
        
        // return view name pointing to templates/hello.html
        return "home";
    }

    @RequestMapping(value="/adduser", method = RequestMethod.POST)
    public String addUser(
        @RequestParam(value="username", required=true) String username, 
        @RequestParam(value="password", required=true) String password, 
        Model model) 
    {
        aus.save(new AppUser(username, password));

        // return view name pointing to templates/hello.html
        return "login";
    }
}