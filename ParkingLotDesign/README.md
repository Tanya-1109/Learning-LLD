# Parking Lot Using LLD 
NOTE :
- I have taken the UML and the code from youtube - [https://www.youtube.com/watch?v=t2FiaSThCw8&ab_channel=MrunmaiDahare] for my understanding of how everything works.
- From this we will get a basic idea how to start in an interview when given this design.

## System Flow
 Vehicle -----> Entrance Gate -----> Ticket ----->Multi- Level Parking Lot -----> Parking Spot -----> Exit Gate -----> Payment 

## Requirements
1. Multi - Level Flooring - The parking lot should be multilevel for our customers to park their vehicle 
2. Parking Ticket - Customers should get their ticket at entry points and pay thir ticket price at the exit.
3. Payment Method - Customers can pay via various payment method like UPI, Cash, credit Card etc.
4. Capacity Management : The system must not allow more vehicles to be parked than the parking slots. It show display an error message that the parking space is full.
5. Parking Spots: Each level should have multiple parking spots for different vehicles( Car, Bike) and respective vehicles dhould be parked at respective slots.
6. Vehicle Types - The parking lot should support various vehicle type.
7. Dynamic Configuration - Number of parking sopts for cars and bikes should be configurable.
8. Fee Models - The system should have a per hour fee model for different types of vehicles.

