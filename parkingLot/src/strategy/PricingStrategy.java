package strategy;

import java.time.Duration;
import java.time.LocalDateTime;

import models.*;

import enums.*;

public interface PricingStrategy {
    public int calculatePrice(Ticket ticket, LocalDateTime exitTime);
}

public class HourlyPricingStrategy implements PricingStrategy {
    public int calculatePrice(Ticket ticket, LocalDateTime exitTime) {
        if (ticket == null) {
            throw new IllegalArgumentException("Ticket is required");
        }
        if (exitTime == null) {
            throw new IllegalArgumentException("Exit time is required");
        }
        LocalDateTime entryTime = ticket.getTicketStartingTime();
        Vehicle vehicle = ticket.getTicketVehicle();
        VehicleType vehicleType = vehicle.getVehicleType();
        long price = 0;
        long hours = Duration.between(entryTime, exitTime).toHours();
        switch (vehicleType) {
            case CAR:
                price = hours * 20;
                break;

            case BIKE:
                price = hours * 10;
                break;

            case TRUCK:
                price = hours * 30;
                break;

            default:
                throw new IllegalStateException("Unsupported vehicle type");
                ;
        }
        return price;
    }

}
