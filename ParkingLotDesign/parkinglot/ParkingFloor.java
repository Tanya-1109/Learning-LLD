package ParkingLotDesign.parkinglot;


import java.util.ArrayList;
import java.util.List;

public class ParkingFloor {
    private List<ParkingSpot> spots;  // List of parking spots on this floor
    private int floorNumber;  // To track which floor this is

    // Constructor to initialize the parking floor with a specific number of spots for cars and bikes
    public ParkingFloor(int floorNumber, int numOfCarSpots, int numOfBikeSpots) {
        this.floorNumber = floorNumber;
        this.spots = new ArrayList<>();  // Initialize the list of spots

        // Add spots for cars
        for (int i = 0; i < numOfCarSpots; i++) {
            this.spots.add(new CarParkingSpot(i + 1));  // Add car spots (using CarParkingSpot)
        }

        // Add spots for bikes
        for (int i = numOfCarSpots; i < numOfCarSpots + numOfBikeSpots; i++) {
            this.spots.add(new BikeParkingSpot(i + 1));  // Add bike spots (using BikeParkingSpot)
        }
    }



    // Method to find an available spot based on the vehicle type
    public ParkingSpot findAvailableSpot(String vehicleType) {
        for (ParkingSpot spot : spots) {
            if (!spot.isOccupied() && spot.getSpotType().equalsIgnoreCase(vehicleType)) {
                return spot;  // Return the first available spot for the vehicle type
            }
        }
        return null;  // No available spot found for the given vehicle type
    }



    // Method to return all parking spots on this floor
    public List<ParkingSpot> getParkingSpots() {
        return spots;
    }
}
