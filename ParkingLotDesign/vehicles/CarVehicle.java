package ParkingLotDesign.vehicles;

public class CarVehicle extends Vehicle {
    private static final double RATE = 10.0; // $10 per hour for cars

    public CarVehicle(String licensePlate) {
        super(licensePlate, "Car");
    }

    // Implement calculateFee for Car
    @Override
    public double calculateFee(int hoursStayed) {
        return hoursStayed * RATE;
    }
}