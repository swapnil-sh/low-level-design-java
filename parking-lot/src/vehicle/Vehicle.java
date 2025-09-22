package vehicle;

import enumeration.DurationType;
import enumeration.VehicleTyoe;
import parkingfee.ParkingFeeStrategy;

public abstract class Vehicle {
    private String licensePlate; // Stores the vehicle's license plate number
    private String vehicleType; // Stores the type of vehicle (e.g., car, bike, truck)
    private ParkingFeeStrategy feeStrategy; // Strategy for calculating parking fees

    public Vehicle(String licensePlate, String vehicleType, ParkingFeeStrategy feeStrategy) {
        this.licensePlate = licensePlate;
        this.vehicleType = vehicleType;
        this.feeStrategy = feeStrategy;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public String getLicensePlate() {
        return licensePlate;
    }
    public double calculateFee(int duration, DurationType durationType) {
        return feeStrategy.calculateFee(vehicleType, duration, durationType);
    }
}