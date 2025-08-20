package Strategy.Pricing;

import Models.TripMetaData;

public interface PricingStrategy {
    double calculatePrice(TripMetaData pTripMetaData);
}
