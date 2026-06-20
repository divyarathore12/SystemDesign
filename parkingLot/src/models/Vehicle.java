package models;

import enums.VehicleType;

public class Vehicle {

    private String vehicleNumber;
    private VehicleType vehicleType;

    public Vehicle(String vehicleNumber, VehicleType vehicleType) {

        if (vehicleNumber == null || vehicleNumber.isBlank()) {
            throw new IllegalArgumentException("Vehicle number is required");
        }

        if (vehicleType == null) {
            throw new IllegalArgumentException("Vehicle type is required");
        }

        this.vehicleNumber = vehicleNumber;
        this.vehicleType = vehicleType;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }
}