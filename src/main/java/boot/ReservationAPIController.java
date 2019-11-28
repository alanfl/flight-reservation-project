package boot;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.*;

// needed for cross domain Ajax
@CrossOrigin(origins="http://s.codepen.io")
@RestController
public class ReservationAPIController {

    @Autowired
    ReservationService res;

    @RequestMapping(value="/reservation", method=RequestMethod.GET)
    public Iterable<Reservation> searchReservations(
            @RequestParam(value="reservation_id", required=false) int[] reservation_ids) {
        return res.searchReservations(reservation_ids);
    }

    @RequestMapping(value="/reservation", method=RequestMethod.POST)
    public Reservation createReservation(@RequestBody Reservation r){ return res.save(r); }

    @RequestMapping(value="/reservation/{reservation_id}", method=RequestMethod.GET)
    public Reservation getReservation(@PathVariable("reservation_id") int reservation_id) {
        return res.get(reservation_id);
    }

    @RequestMapping(value="/reservation/{reservation_id}", method=RequestMethod.PUT)
    public Reservation updateReservation(@RequestBody Reservation r) { return res.update(r); }

    // Must accept a parameter in order to know what specific reservation_id needs to be deleted
    @RequestMapping(value="/reservation", method=RequestMethod.DELETE)
    public void deleteReservation(@PathVariable("reservation_id") int reservation_id){
        res.delete(reservation_id);
    }
}
