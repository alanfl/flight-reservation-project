package boot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class TicketService {
    @Autowired
    private JdbcTemplate jdbc;

    public Ticket get(String ticket_id){
        return (Ticket) jdbc.queryForObject("SELECT * FROM ticket WHERE ticket_id = ?",
                new Object[] { ticket_id },
                (rs,rowNum) -> new Ticket(
                        rs.getString("ticket_id"),
                        rs.getString("reservation_id"),
                        rs.getString("leg_id"),
                        rs.getString("airline_id"),
                        rs.getString("flight_id"),
                        rs.getString("departure_weekday"),
                        rs.getString("departure_date"),
                        rs.getString("price"),
                        rs.getString("waitlist_status")
                )
        );
    }

    public void delete(String ticket_id){
        jdbc.update("DELETE FROM ticket WHERE ticket_id=?", ticket_id);
    }

    public Ticket save(Ticket ticket){
        jdbc.update("INSERT INTO ticket VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)",
                ticket.getTicketId(),
                ticket.getReservationId(),
                ticket.getLegId(),
                ticket.getAirlineId(),
                ticket.getFlightId(),
                ticket.getDepartureWeekday(),
                ticket.getDepartureDate(),
                ticket.getPrice(),
                ticket.getWaitlistStatus());
        return ticket;
    }

    public Ticket update(Ticket ticket){
        jdbc.update("UPDATE ticket SET reservation_id=?, leg_id=?, airline_id=?, flight_id=?, departure_weekday=?, departure_date=?, price=?, waitlist_status=? WHERE ticket_id=?",
                ticket.getReservationId(),
                ticket.getLegId(),
                ticket.getAirlineId(),
                ticket.getFlightId(),
                ticket.getDepartureWeekday(),
                ticket.getDepartureDate(),
                ticket.getPrice(),
                ticket.getWaitlistStatus(),
                ticket.getTicketId());
        return ticket;
    }

    public Iterable<Ticket> searchTickets(String[] ticket_ids){
        if (ticket_ids != null){
            return jdbc.query("SELECT * FROM ticket WHERE ticket_id IN ?",
                    new Object[] { ticket_ids },
                    (rs,rowNum) -> new Ticket(
                            rs.getString("ticket_id"),
                            rs.getString("reservation_id"),
                            rs.getString("leg_id"),
                            rs.getString("airline_id"),
                            rs.getString("flight_id"),
                            rs.getString("departure_weekday"),
                            rs.getString("departure_date"),
                            rs.getString("price"),
                            rs.getString("waitlist_status")
                    ));
        }
        else{
            return jdbc.query("SELECT * FROM ticket",
                    new Object[]{},
                    (rs,rowNum) -> new Ticket(
                        rs.getString("ticket_id"),
                        rs.getString("reservation_id"),
                        rs.getString("leg_id"),
                        rs.getString("airline_id"),
                        rs.getString("flight_id"),
                        rs.getString("departure_weekday"),
                        rs.getString("departure_date"),
                        rs.getString("price"),
                        rs.getString("waitlist_status")
                    ));
        }
    }

}
