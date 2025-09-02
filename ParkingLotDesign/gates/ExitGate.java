package ParkingLotDesign.gates;

import MovieTicketBookingApp.services.PaymentService;
import ParkingLotDesign.parkinglot.ParkingLot;
import ParkingLotDesign.parkinglot.ParkingSpot;
import ParkingLotDesign.vehicles.Vehicle;

public class ExitGate {
    private ParkingLot parkingLot;
    private PaymentService paymentService;

    public ExitGate(ParkingLot parkingLot, PaymentService paymentService) {
        this.parkingLot = parkingLot;
        this.paymentService = paymentService;
    }

    public void processExit(int spotNumber, int hoursStayed) {
        // Find the spot by number
        ParkingSpot spot = parkingLot.getSpotByNumber(spotNumber);

        if (spot == null || !spot.isOccupied()) {
            System.out.println("Invalid or vacant spot!");
            return;
        }

        // Get the vehicle in the spot
        Vehicle vehicle = spot.getVehicle();
        if (vehicle == null) {
            System.out.println("No vehicle found in the spot!");
            return;
        }

        // Calculate the parking fee
        double fee = vehicle.calculateFee(hoursStayed);

        // Delegate payment processing to PaymentService
        paymentService.processPayment(fee);

        // Vacate the spot after payment
        parkingLot.vacateSpot(spot, vehicle);
        System.out.println("Spot vacated successfully!");
    }
}
