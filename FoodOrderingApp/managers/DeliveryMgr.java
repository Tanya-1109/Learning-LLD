package FoodOrderingApp.managers;

import FoodOrderingApp.entities.DeliveryMetaData;

public class DeliveryMgr {
    private static DeliveryMgr deliveryMgrInstance = null;

    private DeliveryMgr() {}

    public static DeliveryMgr getDeliveryMgr() {
        if (deliveryMgrInstance == null) {
            synchronized (DeliveryMgr.class) {
                if (deliveryMgrInstance == null) {
                    deliveryMgrInstance = new DeliveryMgr();
                }
            }
        }
        return deliveryMgrInstance;
    }

    public void manageDelivery(String orderId, DeliveryMetaData metaData) {
        // handle delivery management
    }
}
