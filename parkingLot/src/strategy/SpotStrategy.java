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

    public ParkingSpot findSpot() {
        for (int i = 0; i < floors.size(); i++) {
            Floor floor = floors.get(i);
            List<ParkingSpot> spots = floor.getAllAvailableSpots();
            if (spots.size() > 0) {
                for (int i = 0; i < spots.size(); i++) {

                }
            }

        }
    }
}

class ReservSpotStrategt {

}

class VIPSportStrategy {

}