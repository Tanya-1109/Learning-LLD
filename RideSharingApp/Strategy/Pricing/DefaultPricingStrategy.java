package Strategy.Pricing;
import Models.TripMetaData;
import enums.RATING;



class DefaultPricingStrategy implements PricingStrategy {
    public double calculatePrice(TripMetaData pTripMetaData) {
        return 100.0; // flat price
    }
}
