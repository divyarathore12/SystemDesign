package models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import strategy.PricingStrategy;
import strategy.SpotStrategy;

public class ParkingLot {

    private List<Floor> floorsList = new ArrayList<>();
    private Map<String, Ticket> ticketById = new HashMap<>();
    private Map<String, Ticket> ticketByVehicleId = new HashMap<>();

    public Ticket parkVehicle(Vehicle vehicle, SpotStrategy spotStrategy) {
        if (vehicle == null) {
            throw new IllegalArgumentException("Vehicle is required");
        }

        if (spotStrategy == null) {
            throw new IllegalArgumentException("Spot strategy is required");
        }

        ParkingSpot spot = spotStrategy.findSpot(floorsList, vehicle);

        if (spot == null) {
            throw new IllegalStateException("Spot is not available");
        }

        spot.assignVehicle(vehicle);

        LocalDateTime date = LocalDateTime.now();

        Ticket ticket = new Ticket(spot, date, vehicle);

        ticketById.put(ticket.getTicketId(), ticket);
        ticketByVehicleId.put(ticket.getTicketVehicle().getVehicleNumber(), ticket);

        return ticket;
    }

    public void exitVehicle(String id, PricingStrategy pricingStrategy) {
        if (id == null) {
            throw new IllegalArgumentException("Ticket id is required");
        }

        if (pricingStrategy == null) {
            throw new IllegalArgumentException("Pricing strategy is required");
        }

        LocalDateTime exitTime = LocalDateTime.now();

        Ticket ticket = ticketById.get(id);

        if (ticket == null) {
            ticket = ticketByVehicleId.get(id);
        }

        if (ticket == null) {
            throw new IllegalStateException("Ticket not found");
        }

        int price = pricingStrategy.calculatePrice(ticket, exitTime);

        // TODO: Process payment using 'price'

        ParkingSpot spot = ticket.getTicketSpot();
        spot.release();

        ticketById.remove(ticket.getTicketId());
        ticketByVehicleId.remove(ticket.getTicketVehicle().getVehicleNumber());
    }

    public void addFloor(Floor floor) {
        if (floor == null) {
            throw new IllegalArgumentException("Floor is required");
        }

        floorsList.add(floor);
    }

    public void removeFloor(Floor floor) {
        if (floor == null) {
            throw new IllegalArgumentException("Floor is required");
        }

        floorsList.remove(floor);
    }

    public List<Floor> getAllFloors() {
        return floorsList;
    }
}