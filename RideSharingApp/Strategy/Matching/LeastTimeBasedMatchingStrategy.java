package Strategy.Matching;

import Entities.Driver;
import Managers.DriverMgr;
import Models.TripMetaData;

public class LeastTimeBasedMatchingStrategy implements DriverMatchingStrategy {
    public Driver matchDriver(TripMetaData pTripMetaData) {
        // For simplicity, return first available driver
        for (Driver d : DriverMgr.getDriverMgr().driversMap.values()) {
            if (d.isAvailable()) return d;
        }
        return null;
    }
}