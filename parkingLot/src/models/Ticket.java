package models;

import java.util.LocalDateTime;
import java.util.UUID;

public class Ticket {

    private ParkingSpot spot;
    private LocalDateTime date;
    private Vehicle vehicle;
    private String ticketId;

    public Ticket(ParkingSpot spot, LocalDateTime date, Vehicle vehicle) {

        if (spot == null) {
            throw new IllegalStateException("Spot is required");
        }

        if (date == null) {
            throw new IllegalStateException("Date is required");
        }

        if (vehicle == null) {
            throw new IllegalStateException("Vehicle is required");
        }

        this.spot = spot;
        this.date = date;
        this.vehicle = vehicle;
        this.ticketId = UUID.randomUUID().toString();
    }

    public String getTicketId() {
        return ticketId;
    }

    public LocalDateTime getTicketStartingTime() {
        return date;
    }

    public Vehicle getTicketVehicle() {
        return vehicle;
    }

    public ParkingSpot getTicketSpot() {
        return spot;
    }
}