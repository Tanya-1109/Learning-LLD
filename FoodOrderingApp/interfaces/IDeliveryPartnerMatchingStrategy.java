package FoodOrderingApp.interfaces;

import FoodOrderingApp.entities.DeliveryMetaData;
import FoodOrderingApp.entities.DeliveryPartner;
import java.util.List;

public interface IDeliveryPartnerMatchingStrategy {
    List<DeliveryPartner> matchDeliveryPartners(DeliveryMetaData metaData);
}
