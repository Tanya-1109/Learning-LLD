# Food Ordering App Using LLD

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
- Restaurant has an aggregation relationship with restaurant manager because we want the restaurants to exist independantly even before the restaurant Manager is created.
- Restaurant, Menu, Dish, Dish Add on has a composite relationship because each cannot exist without the other.

The simple sketch for the food subsystem is this.
![alt text](/FoodOrderingApp/images/image.png)

