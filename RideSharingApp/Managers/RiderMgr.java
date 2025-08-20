package Managers;
import java.util.*;
import java.util.concurrent.locks.ReentrantLock;

import Entities.Rider;

public class RiderMgr {
    private static RiderMgr riderMgrInstance = null;
    private ReentrantLock mtx = new ReentrantLock();
    private Map<String, Rider> ridersMap = new HashMap<>();

    private RiderMgr() {}

    public static RiderMgr getRiderMgr() {
        if (riderMgrInstance == null) {
            riderMgrInstance = new RiderMgr();
        }
        return riderMgrInstance;
    }

    public void addRider(String riderName, Rider pRider) {
        mtx.lock();
        try {
            ridersMap.put(riderName, pRider);
        } finally {
            mtx.unlock();
        }
    }

    public Rider getRider(String riderName) {
        return ridersMap.get(riderName);
    }
}
