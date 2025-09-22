package parkingspot;

import vehicle.Vehicle;

public class CarParkingSpot extends ParkingSpot {
    public CarParkingSpot(int spotNumber, String spotType) {
        super(spotNumber, spotType);
    }

    public CarParkingSpot(int spotNumber) {
        super();
    }
    @Override
    public boolean canParkVehicle(Vehicle vehicle) {
        return "Car".equalsIgnoreCase(vehicle.getVehicleType());
    }
}

