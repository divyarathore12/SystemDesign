package strategy;

import java.util.List;

import models.Floor;
import models.ParkingSpot;
import models.Vehicle;

public class VIPSpotStrategy implements SpotStrategy {
    public ParkingSpot findSpot(List<Floor> floors, Vehicle vehicle) {
        for (int i = 0; i < floors.size(); i++) {
            Floor floor = floors.get(i);
            List<ParkingSpot> currentFloorSpots = floor.getAllAvailableSpots();
            for (int j = 0; j < currentFloorSpots.size(); j++) {
                ParkingSpot currSpot = currentFloorSpots.get(j);
                if (currSpot.canFitVehicle(vehicle) && currSpot.isVIPSpotCategory()) {
                    return currSpot;
                }

            }
        }
        return null;
    }

}