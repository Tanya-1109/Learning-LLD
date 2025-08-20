package Strategy.Matching;
import Entities.Driver;
import Managers.DriverMgr;
import Models.TripMetaData;

public interface DriverMatchingStrategy {
    Driver matchDriver(TripMetaData pTripMetaData);
}
