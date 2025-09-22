import enumeration.DurationType;
import parkingfee.BasicHourlyRateStrategy;
import parkingfee.ParkingFeeStrategy;
import parkingfee.PremiumRateStrategy;
import parkingspot.BikeParkingSpot;
import parkingspot.CarParkingSpot;
import parkingspot.ParkingSpot;
import payments.CashPayment;
import payments.CreditCardPayment;
import payments.PaymentStrategy;
import vehicle.Vehicle;
import vehicle.VehicleFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Create a parking lot with multiple floors and varied spot configurations
        ParkingLot parkingLot =
                new ParkingLotBuilder()
                        // First floor: 2 car spots, 2 bike spots
                        .createFloor(1, 2, 2)
                        // Second floor: 3 car spots, 1 bike spot, 1 other vehicle spot
                        .createFloor(2, 3, 1, 1)
                        .build();
        // Existing parking lot logic can be applied as before
        // Example: parking vehicles, calculating fees, etc.
    }
}

/*
* Parking LOT
* 1. Parking Vehicles
* 2. Collecting Payments
* 3. Managing space efficiently
* 4. Different types pf vehicles
* 5. Parking ticket on entry ticket
* 6. The system calculates the parking fee based on the duration of stay and vehicle type.
*
*
Exit and Payment:

• A vehicle needs to make a payment before exiting.
• Multiple payment methods (Cash, Card, UPI) should be supported.
• Once payment is successful, the vehicle is allowed to exit, and the parking slot is freed.

Illegal Actions:
• A vehicle cannot park in an already occupied slot.
• Vehicles cannot vacate without completing the payment process.


Candidate: To summarize, the key requirements are:
• A parking lot with multiple slot types.
• Support for bikes, cars, and trucks.
• Dynamic slot allocation based on vehicle size.
• Payment processing with multiple methods.
• Entry ticket issuance and exit validation.

* Point 4: Design Challenges :
Interviewer: What design challenges do you anticipate?

Candidate: The key challenges for the Parking Lot system include:
1. Efficient Slot Allocation: Ensuring vehicles are assigned to the correct slot type.
2. Tracking vehicle.Vehicle Duration: Keeping a record of entry times for payment calculations.
3. Handling Payments: Supporting multiple payment methods dynamically.
4. Managing Concurrency: Ensuring simultaneous vehicle entries and exits are handled properly.


Point 5: Approach :
Interviewer: How would you approach these challenges?
Candidate: I propose using design patterns effectively. Here are my strategies:
1. Factory for vehicle.Vehicle Creation :
• Allows easy extension for new vehicle types.
• Ensures consistent object creation.
2. Strategy Pattern for Payments and Parking Fares :
• Enables flexible payment methods and Parking fares based on the vehicle type and duration for the parking.
• Easily extendable for future payment integrations and new fare strategy additions.
3. Singleton Pattern for Parking Lot Management :
• Ensures only one instance of the parking lot exists.
4. Observer Pattern for Exit Notifications :
• Notifies the system when a vehicle exits.
• Can be extended for alerts or logging.


*
 * */