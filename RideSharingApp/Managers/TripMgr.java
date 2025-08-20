package Managers;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

import Strategy.Pricing.PricingStrategy;
import Entities.Rider;
import Entities.Driver;
import Entities.Trip;
import Models.TripMetaData;
import Strategy.Matching.DriverMatchingStrategy;

public class TripMgr {
    private static TripMgr tripMgrInstance = null;
    private ReentrantLock mtx = new ReentrantLock();
    private RiderMgr riderMgr;
    private DriverMgr driverMgr;
    private Map<Integer, TripMetaData> tripsMetaDataInfo = new HashMap<>();
    private Map<Integer, Trip> tripsInfo = new HashMap<>();
    private int tripCounter = 1;

    private TripMgr() {
        riderMgr = RiderMgr.getRiderMgr();
        driverMgr = DriverMgr.getDriverMgr();
    }

    public static TripMgr getTripMgr() {
        if (tripMgrInstance == null) {
            tripMgrInstance = new TripMgr();
        }
        return tripMgrInstance;
    }

    public Trip createTrip(Rider pRider, String pSrcLoc, String pDstLoc) {
        TripMetaData metaData = new TripMetaData(pSrcLoc, pDstLoc, pRider.getRating());
        PricingStrategy pricingStrategy = StrategyMgr.getStrategyMgr().determinePricingStrategy(metaData);
        DriverMatchingStrategy driverMatchingStrategy = StrategyMgr.getStrategyMgr().determineMatchingStrategy(metaData);

        double price = pricingStrategy.calculatePrice(metaData);
        Driver driver = driverMatchingStrategy.matchDriver(metaData);
        if (driver != null) {
            metaData.setDriverRating(driver.getRating());
        }

        Trip trip = new Trip(pRider, driver, pSrcLoc, pDstLoc, price, pricingStrategy, driverMatchingStrategy);
        tripsMetaDataInfo.put(tripCounter, metaData);
        tripsInfo.put(tripCounter, trip);
        trip.displayTripDetails();
        tripCounter++;
        return trip;
    }
}
 
    

