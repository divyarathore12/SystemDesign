package strategy;

import java.util.List;

import models.*;

public interface SpotStrategy {
    public ParkingSpot findSpot();
}

class NearestSpotStrategy implements SpotStrategy {
    private List<Floor> floors;
    private Vehicle vehicle

    public NearestSpotStrategy(List<Floor> floors, Vehicle vehicle) {
        this.floors = floors;
        this.vehicle = vehicle;
    }

}

class ReservSpotStrategt {

}

class VIPSportStrategy {

}