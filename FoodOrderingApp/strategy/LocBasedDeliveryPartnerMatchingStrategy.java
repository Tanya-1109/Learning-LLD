package FoodOrderingApp.strategy;

import FoodOrderingApp.entities.DeliveryMetaData;
import FoodOrderingApp.entities.DeliveryPartner;
import FoodOrderingApp.interfaces.IDeliveryPartnerMatchingStrategy;

import java.util.List;
import java.util.ArrayList;

public class LocBasedDeliveryPartnerMatchingStrategy implements IDeliveryPartnerMatchingStrategy {
    @Override
    public List<DeliveryPartner> matchDeliveryPartners(DeliveryMetaData metaData) {
        // return based on location logic
        return new ArrayList<>();
    }
}
