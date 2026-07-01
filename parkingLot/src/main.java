import models.*;

import strategy.*;

import enums.*;

public class Main {
    public static void main(String[] args) {
        ParkingLot parkingLot = new ParkingLot();
        Floor floor1 = new Floor(1);
        Floor floor2 = new Floor(2);
        floor1.addSpot(new ParkingSpot("A1", SpotType.CAR_SPOT, SpotCategory.NORMAL));
        floor1.addSpot(new ParkingSpot("B1", SpotType.BIKE_SPOT, SpotCategory.NORMAL));
        floor2.addSpot(new ParkingSpot("A2", SpotType.CAR_SPOT, SpotCategory.VIP));
        floor2.addSpot(new ParkingSpot("B2", SpotType.TRUCK_SPOT, SpotCategory.VIP));
        parkingLot.addFloor(floor1);
        parkingLot.addFloor(floor2);
        Vehicle vehicle = new Vehicle("RJ0355", VehicleType.CAR);
        // SpotStrategy spotStrategy = new NearestSpotStrategy();
        SpotStrategy spotStrategy = new VIPSpotStrategy();

        PricingStrategy pricingStrategy = new HourlyPricingStrategy();
        Ticket ticket = parkingLot.parkVehicle(vehicle, spotStrategy);
        System.out.println("Vehicle parked.");
        System.out.println("Ticket Id : " + ticket.getTicketId());
        parkingLot.exitVehicle(ticket.getTicketId(), pricingStrategy);
        System.out.println("Vehicle exited successfully.");
    }
}
