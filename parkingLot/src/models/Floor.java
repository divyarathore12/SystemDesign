package models;

import java.util.ArrayList;
import java.util.List;

public class Floor {
    private int floorNumber;
    private List<ParkingSpot> spots;

    public Floor(int floorNumber) {
        this.floorNumber = floorNumber;
        this.spots = new ArrayList<>();
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public List<ParkingSpot> getAllSpotsOfFloor() {
        return spots;
    }

    public void addSpot(ParkingSpot spot) {
        if (spot == null) {
            throw new IllegalStateException("Spot is required");
        }
        for (int i = 0; i < spots.size(); i++) {
            if (spots.get(i).getSpotId().equals(spot.getSpotId())) {
                throw new IllegalStateException("spot already present");
            }
        }
        spots.add(spot);
    }

    public void deleteSpot(ParkingSpot spot) {
        if (spot == null) {
            throw new IllegalStateException("Spot is required");
        }
        for (int i = 0; i < spots.size(); i++) {
            if (spots.get(i).getSpotId().equals(spot.getSpotId())) {
                spots.remove(spot);
                return;
            }
        }
        throw new IllegalStateException("Spot is not present");

    }

    public List<ParkingSpot> getAllAvailableSpots() {
        List<ParkingSpot> availableSpots = new ArrayList<>();

        for (int i = 0; i < spots.size(); i++) {
            if (spots.get(i).isAvailable()) {
                availableSpots.add(spots.get(i));
            }
        }

        return availableSpots;
    }
}