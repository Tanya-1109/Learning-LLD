package ParkingLotDesign.vehicles;

public class BikeVehicle extends Vehicle {
    private static final double RATE = 5.0; // $5 per hour for bikes

    public BikeVehicle(String licensePlate) {
        super(licensePlate, "Bike");
    }

    // Implement calculateFee for Bike
    @Override
    public double calculateFee(int hoursStayed) {
        return hoursStayed * RATE;
    }
}