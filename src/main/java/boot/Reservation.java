package boot;

import java.sql.Time;
import java.util.Date;

public class Reservation {
    private String reservation_id;
    private String username;
    private String origin_airport_id;
    private Date purchase_date;
    private Time purchase_time;
    private Date departure_date;
    private Time departure_time;
    private double total_fare;
    private double fee;
    private String special_meal;
    private String seat_class;
    private String booking_status;

    public Reservation(String reservation_id, String username, String origin_airport_id, Date purchase_date, Time purchase_time, Date departure_date, Time departure_time, double total_fare,double fee, String special_meal,String seat_class,String booking_status) {
        this.reservation_id = reservation_id;
        this.username = username;
        this.origin_airport_id = origin_airport_id;
        this.purchase_date = purchase_date;
        this.purchase_time = purchase_time;
        this.departure_date = departure_date;
        this.departure_time = departure_time;
        this.total_fare = total_fare;
        this.fee = fee;
        this.special_meal = special_meal;
        this.seat_class = seat_class;
        this.booking_status = booking_status;
    }

    public String getReservationId() {
        return reservation_id;
    }

    public String getUsername() {
        return username;
    }

    public String getOriginAirportId() { return origin_airport_id; }

    public Date getPurchaseDate(){ return purchase_date; }

    public Time getPurchaseTime(){ return purchase_time; }

    public Date getDepartureDate(){ return departure_date; }

    public Time getDepartureTime(){ return departure_time; }

    public double getTotalFare(){ return total_fare; }

    public double getFee(){ return fee; }

    public String getSpecialMeal(){ return special_meal; }

    public String getSeatClass(){ return seat_class; }

    public String getBookingStatus(){ return booking_status; }
}
