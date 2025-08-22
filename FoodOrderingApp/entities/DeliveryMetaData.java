package FoodOrderingApp.entities;

public class DeliveryMetaData {
    private Location userLoc;
    private Location restaurantLoc;
    private String orderId;

    public DeliveryMetaData(String orderId, Location userLoc, Location restaurantLoc) {
        this.orderId = orderId;
        this.userLoc = userLoc;
        this.restaurantLoc = restaurantLoc;
    }

    public Location getUserLoc() { return userLoc; }
    public Location getRestaurantLoc() { return restaurantLoc; }
    public String getOrderId() { return orderId; }
}
