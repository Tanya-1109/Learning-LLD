# Food Ordering App Using LLD
NOTE :
- I have taken the UML and the sketch from youtube - [https://www.youtube.com/watch?v=XN17WWiUzT4&ab_channel=KeertiPurswani] for my understanding of how everything works but the code is written by me since I wanted Java implementation.
- From this we will get a basic idea how to start in an interview when given this design.
- In any interview, we won't be given the whole design, just the subparts - Food Ordering, Delivering, Notification System.

## System Design Approach and Basics

To design a scalable food ordering system, we divide the system into smaller sub-systems:

- **Delivery:**  
  Assigns delivery partners, ensures timely delivery, and verifies correct location.

- **Food:**  
  Presents the menu accurately before the order is placed.

- **Order:**  
  Acts as the connecting point between Delivery and Food sub-systems.

 - **Order Manager:**  
    Receives orders, generates order IDs, and communicates with both the Food and Delivery systems.  
    The data sent to the Delivery Manager and Food Manager may change over time (e.g., fewer orders allow more deliveries, menu updates).

- **Delivery Manager:**  
  Assigns delivery partners using the order ID received from the Order Manager.

- **Food Manager:**  
  Prepares food, displays the menu, and manages the food subsystem.



## Classes Required

### Food Subsystem

- **Food Manager:**  
  Handles food preparation with functions like `prepareFood`, which takes parameters such as restaurant ID, order ID, and a map of dishes and quantities.  
  Implemented as a Singleton class to manage all food orders.

- **Restaurant:**  
  Stores restaurant details like ID, location, and availability.  
  Supports chains of restaurants (e.g., Domino's, CCD) using a flag.  
  The Factory Design Pattern can be used for managing chains.

- **Restaurant Manager:**  
  Maintains a map of restaurant IDs to restaurant instances.  
  Implemented as a Singleton class to manage all restaurants.

- **Menu:**  
  Each restaurant has its own menu showing available dishes.

- **Dish:**  
  Represents individual dishes.

- **Dish Add-On:**  
  Add-ons can be ordered with dishes but not separately.

#### Relationships

- **Restaurant** has an **aggregation** relationship with **Restaurant Manager**  
  Restaurants can exist independently, even before the Restaurant Manager is created.

- **Restaurant**, **Menu**, **Dish**, and **Dish Add-On** have a **composition** relationship  
  These components cannot exist without each other.


The simple sketch for the food subsystem is this.

![alt text](/FoodOrderingApp/images/image.png)

### Delivery Subsystem

- **Delivery Manager:**  
  Manages the delivery subsystem and receives orders from the order subsystem.

- **Delivery MetaData:**  
  Stores information about the delivery, such as user location, restaurant location, and order ID.

- **Delivery Partner Matching Strategy:**  
  Interface with the function `matchDeliveryPartner`. Implements the Strategy Pattern for flexible partner matching.
  - **Location Based DPMS:**  
    Matches delivery partners based on location using `DeliveryMetaData`.
- **Strategy Manager:**  
  Responsible for selecting which matching strategy to use.

This is the sketch for Delivery Subsystem.

![alt text](/FoodOrderingApp/images/image2.png)

## UML
This is the UML representation of the app. The UML contains extra classes than discussed above but I have implemented it in the code. During the interview, we can choose to omit this part and explain only the basics.

![alt text](/FoodOrderingApp/images/image3.png)

