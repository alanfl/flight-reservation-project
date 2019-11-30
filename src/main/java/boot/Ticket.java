package boot;

import java.util.Date;

public class Ticket {
    private String ticket_id;
    private String reservation_id;
    private int leg_id;
    private String airline_id;
    private int flight_id;
    private int departure_weekday;
    private Date departure_date;
    private double price;
    private String waitlist_status;

    public Ticket(String ticket_id, String reservation_id, int leg_id, String airline_id, int flight_id, int departure_weekday, Date departure_date, double price, String waitlist_status){
        this.ticket_id = ticket_id;
        this.reservation_id = reservation_id;
        this.leg_id = leg_id;
        this.airline_id = airline_id;
        this.flight_id = flight_id;
        this.departure_weekday = departure_weekday;
        this.departure_date = departure_date;
        this.price = price;
        this.waitlist_status = waitlist_status;
    }

    public String getTicketId(){ return ticket_id; }

    public String getReservationId(){ return reservation_id; }

    public int getLegId(){ return leg_id; }

    public String getAirlineId(){ return airline_id; }

    public int getFlightId(){ return flight_id; }

    public int getDepartureWeekday(){ return departure_weekday; }

    public Date getDepartureDate(){ return departure_date; }

    public double getPrice(){ return price; }

    public String getWaitlistStatus(){ return waitlist_status; }



}
