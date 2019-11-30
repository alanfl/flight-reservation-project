package boot;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.*;

@CrossOrigin(origins="http://s.codepen.io")
@RestController
public class TicketAPIController {
    @Autowired
    TicketService ts;

    @RequestMapping(value="/ticket", method=RequestMethod.GET)
    public Iterable<Ticket> searchTickets(
            @RequestParam(value="ticket_id", required=false) String[] ticket_ids){
        return ts.searchTickets(ticket_ids);
    }

    @RequestMapping(value="/ticket", method=RequestMethod.POST)
    public Ticket createTicket(@RequestBody Ticket t){ return ts.save(t); }

    @RequestMapping(value="/ticket/{ticket_id}", method=RequestMethod.GET)
    public Ticket getTicket(@PathVariable("ticket_id") String ticket_id){
        return ts.get(ticket_id);
    }

    @RequestMapping(value="/ticket/{ticket_id}", method=RequestMethod.PUT)
    public Ticket updateTicket(@RequestBody Ticket t) { return ts.update(t); }

    @RequestMapping(value="/ticket/{ticket_id}", method=RequestMethod.DELETE)
    public void deleteTicket(@PathVariable("ticket_id") String ticket_id){ ts.delete(ticket_id); }

    // TODO implement customer-representatives making tickets on behalf of a customer
}
