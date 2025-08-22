package FoodOrderingApp.managers;


import FoodOrderingApp.strategy.LocBasedDeliveryPartnerMatchingStrategy;
import FoodOrderingApp.entities.DeliveryMetaData;
import FoodOrderingApp.interfaces.IDeliveryPartnerMatchingStrategy;

public class StrategyMgr {
    private static StrategyMgr strategyMgrInstance = null;
    private LocBasedDeliveryPartnerMatchingStrategy matchingStrategy;
    
    private StrategyMgr() {
        // Default strategy (can be replaced with others)
        this.matchingStrategy = new LocBasedDeliveryPartnerMatchingStrategy();
    }

    public static StrategyMgr getStrategyMgr() {
        if (strategyMgrInstance == null) {
            synchronized (StrategyMgr.class) {
                if (strategyMgrInstance == null) {
                    strategyMgrInstance = new StrategyMgr();
                }
            }
        }
        return strategyMgrInstance;
    }

    public IDeliveryPartnerMatchingStrategy determineDeliveryPartnerMatchingStrategy(DeliveryMetaData metaData) {
        return matchingStrategy;
    }
}
