package Managers;
import java.util.*;
import java.util.concurrent.locks.ReentrantLock;

import Models.TripMetaData;
import Strategy.Matching.DriverMatchingStrategy;
import Strategy.Matching.LeastTimeBasedMatchingStrategy;
import Strategy.Pricing.PricingStrategy;
import Strategy.Pricing.RatingBasedPricingStrategy;

class StrategyMgr {
    private static StrategyMgr strategyMgrInstance = null;
    private ReentrantLock mtx = new ReentrantLock();

    private StrategyMgr() {}

    public static StrategyMgr getStrategyMgr() {
        if (strategyMgrInstance == null) {
            strategyMgrInstance = new StrategyMgr();
        }
        return strategyMgrInstance;
    }

    public PricingStrategy determinePricingStrategy(TripMetaData metaData) {
        return new RatingBasedPricingStrategy(); // can add conditions
    }

    public DriverMatchingStrategy determineMatchingStrategy(TripMetaData metaData) {
        return new LeastTimeBasedMatchingStrategy();
    }
}