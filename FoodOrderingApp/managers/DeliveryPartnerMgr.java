package FoodOrderingApp.managers;

import FoodOrderingApp.entities.DeliveryPartner;
import java.util.concurrent.ConcurrentHashMap;
import java.util.Map;

public class DeliveryPartnerMgr {
    private static DeliveryPartnerMgr deliveryPartnerMgrInstance = null;
    private Map<String, DeliveryPartner> deliveryPartnersMap = new ConcurrentHashMap<>();

    private DeliveryPartnerMgr() {}

    public static DeliveryPartnerMgr getDeliveryPartnerMgr() {
        if (deliveryPartnerMgrInstance == null) {
            synchronized (DeliveryPartnerMgr.class) {
                if (deliveryPartnerMgrInstance == null) {
                    deliveryPartnerMgrInstance = new DeliveryPartnerMgr();
                }
            }
        }
        return deliveryPartnerMgrInstance;
    }

    public void addDeliveryPartner(String partnerName, DeliveryPartner partner) {
        deliveryPartnersMap.put(partnerName, partner);
    }

    public DeliveryPartner getDeliveryPartner(String partnerName) {
        return deliveryPartnersMap.get(partnerName);
    }
}
