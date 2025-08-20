# Ride Sharing App Using LLD 
NOTE :
- I have taken the UML and the sketch from youtube - [https://www.youtube.com/watch?v=a-F45Jov0Ck&ab_channel=KeertiPurswani] for my understanding of how everything works but the code is written by me since I wanted Java implementation.
- From this we will get a basic idea how to start in an interview when given this design.

## Basic Steps for Creation of Ride Sharing App

1. **Rider:**  
   The user who books the rides.

2. **Driver:**  
   The person accepting the rides.  
   _Assumption: Each driver has one cab._

3. **Create Trip:**  
   The rider initiates a trip by specifying their source location.

4. **Driver Matching:**  
   After creating a ride, match a driver based on certain conditions (e.g., nearest driver, highest rating).  
   _Process: Send requests; the first driver to accept is matched._

5. **Pricing:**  
   Pricing is determined by conditions such as driver rating, per km price, or

### Classes Required

#### 1. **RiderManager**
- Manages all riders in the system.
- Only one instance should exist (Singleton Pattern).

#### 2. **DriverManager**
- Manages all drivers in the system.
- Also implemented as a Singleton Pattern.

#### 3. **Rider**
- Stores rider information such as DOB, KYC, ID, etc.

#### 4. **Driver**
- Stores driver details, cab information (one cab per driver), and availability status (can accept/deny requests).

#### 5. **Trip**
- Stores all information about the ride: source, destination, driver, trip ID, pricing, etc.
- Creates a trip only when the driver is available by matching drivers based on specified conditions.
- Includes attributes for strategy matching, indicating which strategies are used for the trip.

#### 6. **StrategyManager**
- Decides which strategy to use for driver matching and pricing.
- is a singleton class beacuse we weant only one instance of Manager to be choosing the strategy.

#### 7. **TripMetaData**
- Contains all necessary data for strategy selection, such as weather conditions, source, destination, ratings, etc.
- Designed as a single level for simplicity, though multiple interfaces could be created for different strategies.

#### 8. **TripManager**
- willl be resposible for creating trips using the information from StrategyManager, Trips, TripMetaData.
- Will be a singleton class because we want all our managers to have a single instance to manage everything.

---

### **Class Relationships**

- **RiderManager** contains instances of **Rider**.
- **DriverManager** contains instances of **Driver**.
- **StrategyManager** has a unidirectional association with strategy classes (can call their functions, but not vice versa).
- **StrategyManager** has a unidirectional association with **TripMetaData** to access data required for strategy selection.
- **TripManager** has a composition relationship with **TipMetaData** and **Trip** because Trip cannot exist without TripManager
- **TripManager** has a unidirectional association with **StrategyManager** class to be able to get which starategy we are using.
- **TripManager** will have an aggregation relationship with **DriverManager** amd **RiderManager** because the latter can exist without trip manager( if a rider or a driver has just registered on the app and not booked a ride).

**Relationship Type:**
- If Riders and Drivers can exist independently of their Managers, use **Aggregation**.
- If Riders and Drivers should only exist with their Managers, use **Composition**.

---

### **Class Strategy**

We use the **Strategy Design Pattern** to create flexible strategies for price and driver matching. This approach allows easy extension by implementing new strategy interfaces as needed.

- **DriverMatching Strategy:**  
  Interface for driver matching strategies.
  - **Least Time Based Strategy:** Matches the driver closest to the rider in the least time. Implements the `matchDriver()` function.

- **Pricing Strategy:**  
  Interface for pricing strategies.
  - **Default Pricing Strategy:** Calculates price based on kilometers. Implements the `calculatePrice()` function.
  - **Rating Based Pricing Strategy:** Calculates price based on driver ratings. Implements the `calculatePrice()` function.

A simple sketch representation of the relationship and class is this.

  ![alt text](/RideSharingApp/images/image.png)


## UML DIAGRAM:

![alt text](/RideSharingApp/images/image-1.png)



