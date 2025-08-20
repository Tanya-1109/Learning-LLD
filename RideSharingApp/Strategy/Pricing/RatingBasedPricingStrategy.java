package Strategy.Pricing;
import Models.TripMetaData;
import enums.RATING;

public class RatingBasedPricingStrategy implements PricingStrategy {
    public double calculatePrice(TripMetaData pTripMetaData) {
        if (pTripMetaData.getRiderRating() == RATING.FIVE) {
            return 80.0; // discount
        }
        return 120.0;
    }
}