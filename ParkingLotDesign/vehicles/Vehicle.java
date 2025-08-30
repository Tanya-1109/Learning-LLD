package ParkingLotDesign.vehicles;

public abstract class Vehicle {
    private String licensePlate;
    private String vehicleType;

    // Constructor to initialize vehicle
    public Vehicle(String licensePlate, String vehicleType) {
        this.licensePlate = licensePlate;
        this.vehicleType = vehicleType;
    }

    // Getter for vehicle type
    public String getVehicleType() {
        return vehicleType;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    // Abstract method for calculating parking fee
    public abstract double calculateFee(int hoursStayed);
}
