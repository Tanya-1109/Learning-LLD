package Managers;

import Entities.Driver;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;


public class DriverMgr {
    private static DriverMgr driverMgrInstance = null;
    private ReentrantLock mtx = new ReentrantLock();
    public Map<String, Driver> driversMap = new HashMap<>();

    private DriverMgr() {}

    public static DriverMgr getDriverMgr() {
        if (driverMgrInstance == null) {
            driverMgrInstance = new DriverMgr();
        }
        return driverMgrInstance;
    }

    public void addDriver(String driverName, Driver pDriver) {
        mtx.lock();
        try {
            driversMap.put(driverName, pDriver);
        } finally {
            mtx.unlock();
        }
    }

    public Driver getDriver(String driverName) {
        return driversMap.get(driverName);
    }
}