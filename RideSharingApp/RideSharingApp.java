import Entities.Driver;
import Entities.Rider;
import Managers.DriverMgr;
import Managers.RiderMgr;
import Managers.TripMgr;
import enums.RATING;

public class RideSharingApp {
    public static void main(String[] args) {
        Rider r1 = new Rider("Alice", RATING.FIVE);
        Driver d1 = new Driver("Bob", RATING.FOUR);

        RiderMgr.getRiderMgr().addRider("Alice", r1);
        DriverMgr.getDriverMgr().addDriver("Bob", d1);

        TripMgr tripMgr = TripMgr.getTripMgr();
        tripMgr.createTrip(r1, "Park Street", "Airport");
    }
}