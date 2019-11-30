package boot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {
    @Autowired
    private JdbcTemplate jdbc;

    public Reservation get(String reservation_id){
        return (Reservation) jdbc.queryForObject("SELECT * FROM reservation WHERE reservation_id=?",
                new Object[] { reservation_id }, // arguments as array
                (rs, rowNum) -> new Reservation(
                        rs.getString("reservation_id"),
                        rs.getString("username"),
                        rs.getString("origin_airport_id"),
                        rs.getString("purchase_date"),
                        rs.getString("purchase_time"),
                        rs.getString("departure_date"),
                        rs.getString("departure_time"),
                        rs.getString("total_fare"),
                        rs.getString("fee"),
                        rs.getString("special_meal"),
                        rs.getString("seat_class"),
                        rs.getString("booking_status")
                ) // row mapper
        );
    }

    public void delete(String reservation_id) {
        jdbc.update("DELETE FROM reservation WHERE reservation_id=?", reservation_id);
    }

    public Reservation save(Reservation reservation){
        jdbc.update("INSERT INTO reservation VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
                reservation.getReservationId(),
                reservation.getUsername(),
                reservation.getOriginAirportId(),
                reservation.getPurchaseDate(),
                reservation.getPurchaseTime(),
                reservation.getDepartureDate(),
                reservation.getDepartureTime(),
                reservation.getTotalFare(),
                reservation.getFee(),
                reservation.getSpecialMeal(),
                reservation.getSeatClass(),
                reservation.getBookingStatus());
        return reservation;
    }

    public Reservation update(Reservation reservation){
        jdbc.update("UPDATE reservation SET username = ?, origin_airport_id = ?, purchase_date = ?, purchase_time = ?, departure_date = ?, departure_time = ?, total_fare = ?, fee = ?, special_meal = ?, seat_class = ?, booking_status = ? WHERE reservation_id = ?",
                reservation.getUsername(),
                reservation.getOriginAirportId(),
                reservation.getPurchaseDate(),
                reservation.getPurchaseTime(),
                reservation.getDepartureDate(),
                reservation.getDepartureTime(),
                reservation.getTotalFare(),
                reservation.getFee(),
                reservation.getSpecialMeal(),
                reservation.getSeatClass(),
                reservation.getBookingStatus(),
                reservation.getReservationId()
        );
        return reservation;
    }

    public Iterable<Reservation> searchReservations(String[] reservation_ids){
        if (reservation_ids != null) {
            return jdbc.query("SELECT * FROM reservation WHERE reservation_id IN ?",
                    new Object[] { reservation_ids }, // arguments as array
                    (rs, rowNum) -> new Reservation(
                            rs.getString("reservation_id"),
                            rs.getString("username"),
                            rs.getString("origin_airport_id"),
                            rs.getString("purchase_date"),
                            rs.getString("purchase_time"),
                            rs.getString("departure_date"),
                            rs.getString("departure_time"),
                            rs.getString("total_fare"),
                            rs.getString("fee"),
                            rs.getString("special_meal"),
                            rs.getString("seat_class"),
                            rs.getString("booking_status")
                    ) // row mapper
            );
        }
        else{
            return jdbc.query("SELECT * FROM reservation",
                    new Object[]{},
                    (rs, rowNum) -> new Reservation(
                            rs.getString("reservation_id"),
                            rs.getString("username"),
                            rs.getString("origin_airport_id"),
                            rs.getString("purchase_date"),
                            rs.getString("purchase_time"),
                            rs.getString("departure_date"),
                            rs.getString("departure_time"),
                            rs.getString("total_fare"),
                            rs.getString("fee"),
                            rs.getString("special_meal"),
                            rs.getString("seat_class"),
                            rs.getString("booking_status")
                    ) // row mapper
            );
        }
    }


}
