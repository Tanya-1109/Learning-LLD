package Entities;
import enums.RATING;

public class Driver {
    private String name;
    private boolean avail;
    private RATING rating;

    public Driver(String pName, RATING pRating) {
        this.name = pName;
        this.rating = pRating;
        this.avail = true;
    }

    public void updateAvail(boolean pAvail) {
        this.avail = pAvail;
    }

    public String getDriverName() {
        return name;
    }

    public RATING getRating() {
        return rating;
    }

    public boolean isAvailable() {
        return avail;
    }
}