package models;

import enums.SpotType;
import enums.VehicleType;

public class ParkingSpot {

    private String spotId;
    private Vehicle currentVehicle;
    private boolean reserved;
    private SpotType spotType;

    public ParkingSpot(String spotId, SpotType spotType) {
        this.spotId = spotId;
        this.spotType = spotType;
        this.reserved = false;
        this.currentVehicle = null;
    }

    public String getSpotId() {
        return this.spotId;
    }

    public SpotType getSpotType() {
        return this.spotType;
    }

    public Vehicle getCurrentVehicle() {
        return this.currentVehicle;
    }

    public boolean isReserved() {
        return this.reserved;
    }

    public boolean isAvailable() {
        return currentVehicle == null && !reserved;
    }

    public void reserve() {
        if (currentVehicle != null) {
            throw new IllegalStateException("Vehicle is already present");
        }

        if (reserved) {
            throw new IllegalStateException("Spot is already reserved");
        }

        this.reserved = true;
    }

    public void unreserve() {
        if (!reserved) {
            throw new IllegalStateException("Spot is not reserved");
        }

        this.reserved = false;
    }

    public void assignVehicle(Vehicle vehicle) {

        if (vehicle == null) {
            throw new IllegalStateException("Vehicle cannot be null");
        }

        if (currentVehicle != null) {
            throw new IllegalStateException("Spot is already occupied");
        }

        if (reserved) {
            throw new IllegalStateException("Spot is already reserved");
        }

        if ((vehicle.getVehicleType() == VehicleType.CAR && spotType == SpotType.CAR_SPOT)
                || (vehicle.getVehicleType() == VehicleType.BIKE && spotType == SpotType.BIKE_SPOT)
                || (vehicle.getVehicleType() == VehicleType.TRUCK && spotType == SpotType.TRUCK_SPOT)) {

            this.currentVehicle = vehicle;

        } else {
            throw new IllegalStateException("Vehicle type is not supported by current spot");
        }
    }

    public void release() {
        if (currentVehicle == null) {
            throw new IllegalStateException("Spot is already free");
        }

        this.currentVehicle = null;
    }

    public boolean isSpotPresent(String spotId) {
        return this.spotId.equals(spotId);
    }
}