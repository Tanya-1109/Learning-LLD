package FoodOrderingApp.entities;

public class Order {
    private String orderId;
    private String foodId;

    public Order(String orderId, String foodId) {
        this.orderId = orderId;
        this.foodId = foodId;
    }

    public String getOrderId() { return orderId; }
    public String getFoodId() { return foodId; }
}
