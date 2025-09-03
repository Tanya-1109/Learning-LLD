# Parking Lot Using LLD 
NOTE :
- I have taken the UML and the code from youtube - [https://www.youtube.com/watch?v=t2FiaSThCw8&ab_channel=MrunmaiDahare] for my understanding of how everything works.
- From this we will get a basic idea how to start in an interview when given this design.

## System Flow

Vehicle &rarr; Entrance Gate &rarr; Ticket &rarr; Multi-Level Parking Lot &rarr; Parking Spot &rarr; Exit Gate &rarr; Payment

---

## Requirements

1. **Multi-Level Flooring:**  
   The parking lot should be multilevel to accommodate more vehicles.

2. **Parking Ticket:**  
   Customers receive a ticket at entry and pay for it at the exit.

3. **Payment Methods:**  
   Customers can pay via UPI, cash, credit card, etc.

4. **Capacity Management:**  
   The system must not allow more vehicles than available parking slots.  
   Displays an error message when the parking space is full.

5. **Parking Spots:**  
   Each level should have multiple parking spots for different vehicles (car, bike).  
   Vehicles must be parked in their respective slots.

6. **Vehicle Types:**  
   The parking lot should support various vehicle types.

7. **Dynamic Configuration:**  
   The number of parking spots for cars and bikes should be configurable.

8. **Fee Models:**  
   The system should have a per-hour fee model for different types of vehicles.

---

## Classes Required

1. **Vehicle:**  
   Consists of vehicle types, license number, etc.  
   Has child classes like `Car` and `Bike`.  
   Calculates ticket price according to the fee model.  
   Implements the Factory Design Pattern for easy addition of new vehicle types.

2. **Ticket:**  
   Contains the `ParkingSpot` object, vehicle information, and start time for calculating hours parked.

3. **Payment:**  
   Encapsulates payment strategy objects for different payment methods:  
   `CreditCardPayment`, `UPIPayment`, `CashPayment`.  
   Uses the Strategy Design Pattern for flexible payment options.

4. **Parking Spot:**  
   Abstract class implemented by `BikeParkingSpot` and `CarParkingSpot`.  
   Contains details like vehicle type, spot number, and occupancy status.

5. **Parking Lot:**  
   Manages available floors and spots.  
   Responsible for parking vehicles and vacating spots.

6. **Entrance Gate:**  
   Assigns parking spots by entering vehicle type and license number.

7. **Exit Gate:**  
   Calculates hours spent, parking fee, and handles payment options.

8. **Main:**  
   Interacts with the user.

---

## UML

View the class diagram - [Lucidchart UML Link](https://lucid.app/lucidspark/ae92de08-4bee-41e2-855e-ccadb1382477/edit?invitationId=inv_d4f1737e-2ca0-4186-825d-67e5278ff0fc&page=0_0#)