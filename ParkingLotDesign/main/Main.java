package ParkingLotDesign.main;

import java.util.ArrayList;
import java.util.Scanner;

import ParkingLotDesign.gates.EntranceGate;
import ParkingLotDesign.gates.ExitGate;
import ParkingLotDesign.parkinglot.ParkingFloor;
import ParkingLotDesign.parkinglot.ParkingLot;
import ParkingLotDesign.payment.PaymentService;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Initialize the parking lot with one floor and two spots for simplicity
        ParkingFloor floor = new ParkingFloor(1, 2, 2);  // 2 car spots and 2 bike spots
        ArrayList<ParkingFloor> floors = new ArrayList<>();
        floors.add(floor);
        ParkingLot parkingLot = new ParkingLot(floors);

        // Initialize PaymentService, passing the scanner to it
        PaymentService paymentService = new PaymentService(scanner);

        // Initialize gates, passing both ParkingLot and PaymentService to ExitGate
        EntranceGate entranceGate = new EntranceGate(parkingLot);
        ExitGate exitGate = new ExitGate(parkingLot, paymentService);
        // Start of the parking lot system
        System.out.println("\n=========================================");
        System.out.println("   Welcome to the Parking Lot System!   ");
        System.out.println("=========================================");

        // Continuous parking session until the user exits
        boolean exit = false;
        while (!exit) {
            // Display menu
            showMenu();

            // Get user choice
            int choice = getUserChoice(scanner);

            switch (choice) {
                case 1:
                    // Park a vehicle via the entrance gate
                    parkVehicle(entranceGate);
                    break;

                case 2:
                    // Vacate a parking spot via the exit gate
                    vacateSpot(exitGate, scanner);
                    break;

                case 3:
                    // Exit the session
                    exit = true;
                    System.out.println("Thank you for using the Parking Lot System!");
                    break;

                default:
                    System.out.println("Invalid option! Please try again.");
                    break;
            }
        }

        scanner.close(); // Always close the scanner to avoid resource leak
    }

    private static void showMenu() {
        System.out.println("\n******************************************************");
        System.out.println("Please choose an option from below:");
        System.out.println("1. Park a vehicle");
        System.out.println("2. Vacate a vehicle spot");
        System.out.println("3. Exit the system");
        System.out.println("******************************************************");
    }

    private static int getUserChoice(Scanner scanner) {
        return scanner.nextInt();
    }

    private static void parkVehicle(EntranceGate entranceGate) {
        entranceGate.processEntrance();
    }

    private static void vacateSpot(ExitGate exitGate, Scanner scanner) {
        System.out.println("Enter the spot number to vacate: ");
        int spotNumber = scanner.nextInt();
        System.out.println("Enter the number of hours the vehicle stayed: ");
        int hoursStayed = scanner.nextInt();
        exitGate.processExit(spotNumber, hoursStayed);
    }
}
