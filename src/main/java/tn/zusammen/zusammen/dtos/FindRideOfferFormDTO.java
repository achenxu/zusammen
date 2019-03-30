package tn.zusammen.zusammen.dtos;

import java.util.Date;

public final class FindRideOfferFormDTO {

    private double leavingFromLatitude;
    private double leavingFromLongitude;

    private double goingToLatitude;
    private double goingToLongitude;

    private Date goingAt;

    public double getLeavingFromLatitude() {
        return leavingFromLatitude;
    }

    public void setLeavingFromLatitude(double leavingFromLatitude) {
        this.leavingFromLatitude = leavingFromLatitude;
    }

    public double getLeavingFromLongitude() {
        return leavingFromLongitude;
    }

    public void setLeavingFromLongitude(double leavingFromLongitude) {
        this.leavingFromLongitude = leavingFromLongitude;
    }

    public double getGoingToLatitude() {
        return goingToLatitude;
    }

    public void setGoingToLatitude(double goingToLatitude) {
        this.goingToLatitude = goingToLatitude;
    }

    public double getGoingToLongitude() {
        return goingToLongitude;
    }

    public void setGoingToLongitude(double goingToLongitude) {
        this.goingToLongitude = goingToLongitude;
    }

    public Date getGoingAt() {
        return goingAt;
    }

    public void setGoingAt(Date goingAt) {
        this.goingAt = goingAt;
    }

}
