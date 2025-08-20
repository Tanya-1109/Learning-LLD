package Entities;

import enums.RATING;

public class Rider {
    private String name;
    private RATING rating;

    public Rider(String pName, RATING pRating) {
        this.name = pName;
        this.rating = pRating;
    }

    public String getRiderName() {
        return name;
    }

    public RATING getRating() {
        return rating;
    }
}