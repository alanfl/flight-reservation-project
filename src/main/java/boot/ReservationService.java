package boot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {
    @Autowired
    private JdbcTemplate jdbc;

    public Reservation get(int reservation_id){
        return (Reservation) jdbc.queryForObject("SELECT * FROM reservation WHERE reservation_id=?",
                new Object[] { reservation_id }, // arguments as array
                (rs, rowNum) -> new Reservation(
                        rs.getInt("reservation_id"),
                        rs.getInt("user_id"),
                        rs.getString("origin_airport_id"),
                        rs.getDate("purchase_date"),
                        rs.getTime("purchase_time"),
                        rs.getDate("departure_date"),
                        rs.getTime("departure_time"),
                        rs.getDouble("total_fare"),
                        rs.getDouble("fee"),
                        rs.getString("special_meal"),
                        rs.getString("class"),
                        rs.getString("reservation_status")
                ) // row mapper
        );
    }

    public void delete(int reservation_id) {
        jdbc.update("DELETE FROM reservation WHERE reservation_id=?", reservation_id);
    }

    public Reservation save(Reservation reservation){
        jdbc.update("INSERT INTO reservation VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?",
                reservation.getReservationId(),
                reservation.getUserId(),
                reservation.getOriginAirportId(),
                reservation.getPurchaseDate(),
                reservation.getPurchaseTime(),
                reservation.getDepartureDate(),
                reservation.getDepartureTime(),
                reservation.getTotalFare(),
                reservation.getFee(),
                reservation.getSpecialMeal(),
                reservation.getClassName(),
                reservation.getReservationStatus());
        return reservation;
    }

    public Reservation update(Reservation reservation){
        jdbc.update("UPDATE reservation SET user_id = ?, origin_airport_id = ?, purchase_date = ?, purchase_time = ?, departure_date = ?, departure_time = ?, total_fare = ?, fee = ?, special_meal = ?, class = ?, reservation_status = ? WHERE reservation_id = ?",
                reservation.getUserId(),
                reservation.getOriginAirportId(),
                reservation.getPurchaseDate(),
                reservation.getPurchaseTime(),
                reservation.getDepartureDate(),
                reservation.getDepartureTime(),
                reservation.getTotalFare(),
                reservation.getFee(),
                reservation.getSpecialMeal(),
                reservation.getClassName(),
                reservation.getReservationStatus(),
                reservation.getReservationId()
        );
        return reservation;
    }

    public Iterable<Reservation> searchReservations(int[] reservation_ids){
        if (reservation_ids != null) {
            return jdbc.query("SELECT * FROM reservation where reservation_id IN ?",
                    new Object[] { reservation_ids }, // arguments as array
                    (rs, rowNum) -> new Reservation(
                            rs.getInt("reservation_id"),
                            rs.getInt("user_id"),
                            rs.getString("origin_airport_id"),
                            rs.getDate("purchase_date"),
                            rs.getTime("purchase_time"),
                            rs.getDate("departure_date"),
                            rs.getTime("departure_time"),
                            rs.getDouble("total_fare"),
                            rs.getDouble("fee"),
                            rs.getString("special_meal"),
                            rs.getString("class"),
                            rs.getString("reservation_status")
                    ) // row mapper
            );
        }
        else{
            return jdbc.query("SELECT * FROM reservation",
                    new Object[]{},
                    (rs, rowNum) -> new Reservation(
                            rs.getInt("reservation_id"),
                            rs.getInt("user_id"),
                            rs.getString("origin_airport_id"),
                            rs.getDate("purchase_date"),
                            rs.getTime("purchase_time"),
                            rs.getDate("departure_date"),
                            rs.getTime("departure_time"),
                            rs.getDouble("total_fare"),
                            rs.getDouble("fee"),
                            rs.getString("special_meal"),
                            rs.getString("class"),
                            rs.getString("reservation_status")
                    ) // row mapper
            );
        }
    }


}
