package FoodOrderingApp.managers;

import FoodOrderingApp.entities.Restaurant;
import java.util.concurrent.ConcurrentHashMap;
import java.util.Map;

public class RestaurantMgr {
    private static RestaurantMgr restaurantMgrInstance = null;
    private Map<String, Restaurant> restaurantsMap = new ConcurrentHashMap<>();

    private RestaurantMgr() {}

    public static RestaurantMgr getRestaurantMgr() {
        if (restaurantMgrInstance == null) {
            synchronized (RestaurantMgr.class) {
                if (restaurantMgrInstance == null) {
                    restaurantMgrInstance = new RestaurantMgr();
                }
            }
        }
        return restaurantMgrInstance;
    }

    public void addRestaurant(String restaurantName, Restaurant restaurant) {
        restaurantsMap.put(restaurantName, restaurant);
    }

    public Restaurant getRestaurant(String restaurantName) {
        return restaurantsMap.get(restaurantName);
    }
}
