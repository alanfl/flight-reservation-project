package boot;

import java.sql.Time;
import java.util.Date;

public class Reservation {
    private int reservation_id;
    private int user_id;
    private String origin_airport_id;
    private Date purchase_date;
    private Time purchase_time;
    private Date departure_date;
    private Time departure_time;
    private double total_fare;
    private double fee;
    private String special_meal;
    private String class_name;
    private String reservation_status;

    public Reservation(int reservation_id, int user_id, String origin_airport_id, Date purchase_date, Time purchase_time, Date departure_date, Time departure_time, double total_fare,double fee, String special_meal,String class_name,String reservation_status) {
        this.reservation_id = reservation_id;
        this.user_id = user_id;
        this.origin_airport_id = origin_airport_id;
        this.purchase_date = purchase_date;
        this.purchase_time = purchase_time;
        this.departure_date = departure_date;
        this.departure_time = departure_time;
        this.total_fare = total_fare;
        this.fee = fee;
        this.special_meal = special_meal;
        this.class_name = class_name;
        this.reservation_status = reservation_status;
    }

    public int getReservationId() {
        return reservation_id;
    }

    public int getUserId() {
        return user_id;
    }

    public String getOriginAirportId() { return origin_airport_id; }

    public Date getPurchaseDate(){ return purchase_date; }

    public Time getPurchaseTime(){ return purchase_time; }

    public Date getDepartureDate(){ return departure_date; }

    public Time getDepartureTime(){ return departure_time; }

    public double getTotalFare(){ return total_fare; }

    public double getFee(){ return fee; }

    public String getSpecialMeal(){ return special_meal; }

    public String getClassName(){ return class_name; }

    public String getReservationStatus(){ return reservation_status; }
}
