package parkingspot;

import vehicle.Vehicle;

public class OtherVehicleParkingSpot extends ParkingSpot {
    public OtherVehicleParkingSpot(int spotNumber, String spotType) {
        super(spotNumber, spotType);
    }

    public OtherVehicleParkingSpot(int spotNumber) {
        super();
    }
    @Override
    public boolean canParkVehicle(Vehicle vehicle) {
        return "Car".equalsIgnoreCase(vehicle.getVehicleType());
    }
}
