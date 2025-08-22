package FoodOrderingApp;

import FoodOrderingApp.entities.*;
import FoodOrderingApp.interfaces.IDeliveryPartnerMatchingStrategy;
import FoodOrderingApp.managers.*;
import FoodOrderingApp.strategy.*;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // 1. Create Restaurant Owner & Location
        
        Location restLoc = new Location("MG Road, Kolkata", 22.57, 88.36);

        // 2. Create Restaurant
        Restaurant restaurant = new Restaurant("Foodie's Hub", restLoc);

        // 3. Add Menu with Dishes
        Dish biryani = new Dish("Biryani", "Indian", 250.0);
        Dish momo = new Dish("Momo", "Tibetan", 120.0);
        Menu menu = new Menu(Arrays.asList(biryani, momo));
        // Assign menu to restaurant
        restaurant.setMenu(menu);

        // 4. Register Restaurant in RestaurantMgr
        RestaurantMgr.getRestaurantMgr().addRestaurant("Foodie's Hub", restaurant);

        // 5. Create Delivery Partner
        DeliveryPartner partner = new DeliveryPartner("Rahul");
        DeliveryPartnerMgr.getDeliveryPartnerMgr().addDeliveryPartner("Rahul", partner);

        // 6. Create Order
        Order order = new Order("ORD123", "Biryani");
        OrderMgr.getOrderMgr().createOrder(order.getOrderId(), order);

        // 7. Create Delivery Metadata
        Location userLoc = new Location("Salt Lake, Kolkata", 22.59, 88.42);
        DeliveryMetaData metaData = new DeliveryMetaData(order.getOrderId(), userLoc, restLoc);

        // 8. Prepare Food using FoodMgr
        boolean foodPrepared = FoodMgr.getFoodMgr().prepareFood(order.getOrderId(), "Foodie's Hub");
        System.out.println("Food prepared: " + foodPrepared);

        // 9. StrategyMgr chooses delivery partner
        StrategyMgr strategyMgr = StrategyMgr.getStrategyMgr();
        IDeliveryPartnerMatchingStrategy matchingStrategy = strategyMgr.determineDeliveryPartnerMatchingStrategy(metaData);
        DeliveryPartner assignedPartner = DeliveryPartnerMgr.getDeliveryPartnerMgr().getDeliveryPartner("Rahul");

        // 10. Perform Delivery
        if (assignedPartner != null) {
            assignedPartner.performDelivery(order.getOrderId(), metaData);
            System.out.println("Delivery performed by: " + assignedPartner);
        }

        // 11. Notify User
        NotificationMgr notificationMgr = NotificationMgr.getNotificationMgr();
        notificationMgr.notifyUser("USER101", "Your order " + order.getOrderId() + " is out for delivery!");
    }
}
 
