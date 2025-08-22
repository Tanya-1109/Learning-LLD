package FoodOrderingApp.managers;

import java.util.concurrent.ConcurrentHashMap;

import FoodOrderingApp.entities.Order;

import java.util.Map;

public class OrderMgr {
    private static OrderMgr orderMgrInstance = null;
    private Map<String, Order> ordersMap = new ConcurrentHashMap<>();

    private OrderMgr() {}

    public static OrderMgr getOrderMgr() {
        if (orderMgrInstance == null) {
            synchronized (OrderMgr.class) {
                if (orderMgrInstance == null) {
                    orderMgrInstance = new OrderMgr();
                }
            }
        }
        return orderMgrInstance;
    }

    public void createOrder(String orderId, Order order) {
        ordersMap.put(orderId, order);
    }

    public Order getOrder(String orderId) {
        return ordersMap.get(orderId);
    }
}
