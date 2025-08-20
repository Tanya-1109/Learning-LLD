package Models;
import enums.RATING;

public class TripMetaData {
    private RATING riderRating;
    private RATING driverRating;
    private String srcLoc;
    private String dstLoc;

    public TripMetaData(String pSrcLoc, String pDstLoc, RATING pRiderRating) {
        this.srcLoc = pSrcLoc;
        this.dstLoc = pDstLoc;
        this.riderRating = pRiderRating;
    }

    public RATING getRiderRating() { return riderRating; }
    public RATING getDriverRating() { return driverRating; }
    public void setDriverRating(RATING pDriverRating) { driverRating = pDriverRating; }
}