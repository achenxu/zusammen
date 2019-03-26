package tn.zusammen.zusammen.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import tn.zusammen.zusammen.enums.RideOfferState;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.LinkedHashSet;

@Document
public final class RideOffer {

    @Id
    private String id;

    @NotNull
    private RideOfferState state;

    @DBRef
    @NotNull
    @Size(min = 2, message = "path should have two places at least.")
    private LinkedHashSet<Place> path;

    @DBRef
    @NotNull
    private final User driver;

    @DBRef
    private final LinkedHashSet<RideRequest> rideRequests;

    @NotNull
    @FutureOrPresent(message = "Ride offer date can't be in the past.")
    private Date date;

    private boolean smoking;
    private boolean musicOn;
    private boolean radioOn;

    @PersistenceConstructor
    public RideOffer(@NotNull final User driver, @NotNull final Date date) {
        this.state = RideOfferState.ACTIVE;
        this.driver = driver;
        this.rideRequests = new LinkedHashSet<>();
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public RideOfferState getState() {
        return state;
    }

    public LinkedHashSet<Place> getPath() {
        return path;
    }

    public User getDriver() {
        return driver;
    }

    public LinkedHashSet<RideRequest> getRideRequests() {
        return rideRequests;
    }

    public Date getDate() {
        return date;
    }

    public boolean isSmoking() {
        return smoking;
    }

    public boolean isMusicOn() {
        return musicOn;
    }

    public boolean isRadioOn() {
        return radioOn;
    }

    public void setState(final RideOfferState state) {
        this.state = state;
    }

    public void setPath(final LinkedHashSet<Place> path) {
        this.path = path;
    }

    public void setDate(final Date date) {
        this.date = date;
    }

    public void setSmoking(boolean smoking) {
        this.smoking = smoking;
    }

    public void setMusicOn(boolean musicOn) {
        this.musicOn = musicOn;
    }

    public void setRadioOn(boolean radioOn) {
        this.radioOn = radioOn;
    }

}
