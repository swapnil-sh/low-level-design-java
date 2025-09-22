package parkingspot;

import vehicle.Vehicle;

public class BikeParkingSpot extends ParkingSpot {
    public BikeParkingSpot(int spotNumber, String spotType) {
        super(spotNumber, spotType);
    }

    public BikeParkingSpot(int spotNumber) {
        super();
    }

    @Override
    public boolean canParkVehicle(Vehicle vehicle) {
        return "Bike".equalsIgnoreCase(vehicle.getVehicleType());
    }
}