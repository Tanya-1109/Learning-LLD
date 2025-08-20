package Entities;
import Strategy.Matching.DriverMatchingStrategy;
import Strategy.Pricing.PricingStrategy;
import enums.TRIP_STATUS;

public class Trip {
    private Rider rider;
    private Driver driver;
    private String srcLoc;
    private String dstLoc;
    private TRIP_STATUS status;
    private int tripId;
    private double price;
    private PricingStrategy pricingStrategy;
    private DriverMatchingStrategy driverMatchingStrategy;

    public Trip(Rider pRider, Driver pDriver, String pSrcLoc, String pDstLoc,
                double pPrice, PricingStrategy pPricingStrategy,
                DriverMatchingStrategy pDriverMatchingStrategy) {
        this.rider = pRider;
        this.driver = pDriver;
        this.srcLoc = pSrcLoc;
        this.dstLoc = pDstLoc;
        this.status = TRIP_STATUS.CREATED;
        this.price = pPrice;
        this.pricingStrategy = pPricingStrategy;
        this.driverMatchingStrategy = pDriverMatchingStrategy;
    }

    public void displayTripDetails() {
        System.out.println("Trip from " + srcLoc + " to " + dstLoc +
                " Rider: " + rider.getRiderName() +
                " Driver: " + (driver != null ? driver.getDriverName() : "None") +
                " Price: " + price +
                " Status: " + status);
    }
}
