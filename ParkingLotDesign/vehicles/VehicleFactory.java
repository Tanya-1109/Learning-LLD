package ParkingLotDesign.vehicles;

public class VehicleFactory {
    public static Vehicle createVehicle(String vehicleType, String licensePlate) {
        if (vehicleType.equalsIgnoreCase("Car")) {
            return new CarVehicle(licensePlate);
        } else if (vehicleType.equalsIgnoreCase("Bike")) {
            return new BikeVehicle(licensePlate);
        }
        return null; // For unsupported vehicle types
    }
}