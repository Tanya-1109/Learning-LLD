package FoodOrderingApp.managers;

import FoodOrderingApp.entities.Restaurant;

public class FoodMgr {
    private static FoodMgr foodMgrInstance = null;

    private FoodMgr() {}

    public static FoodMgr getFoodMgr() {
        if (foodMgrInstance == null) {
            synchronized (FoodMgr.class) {
                if (foodMgrInstance == null) {
                    foodMgrInstance = new FoodMgr();
                }
            }
        }
        return foodMgrInstance;
    }

    public boolean prepareFood(String orderId, String restaurantId) {
        RestaurantMgr restaurantMgr = RestaurantMgr.getRestaurantMgr();
        Restaurant restaurant = restaurantMgr.getRestaurant(restaurantId);
        if (restaurant != null) {
            return restaurant.prepareFood(orderId);
        }
        return false;
    }
}
