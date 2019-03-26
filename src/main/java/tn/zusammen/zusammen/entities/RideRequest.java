package tn.zusammen.zusammen.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import tn.zusammen.zusammen.enums.RideRequestState;

import javax.validation.constraints.NotNull;

@Document
@CompoundIndexes({
        @CompoundIndex(
                name = "user_rideOffer",
                def = "{'user.id' : 1, 'rideOffer.id': 1}",
                unique = true
        )
})
public final class RideRequest {

    @Id
    private String id;

    @DBRef
    @NotNull
    private final User user;

    @DBRef
    @NotNull
    private final RideOffer rideOffer;

    @NotNull
    private RideRequestState state;

    @PersistenceConstructor
    public RideRequest(@NotNull final User user, @NotNull final RideOffer rideOffer) {
        this.user = user;
        this.rideOffer = rideOffer;
        this.state = RideRequestState.SENT;
    }

    public String getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public RideOffer getRideOffer() {
        return rideOffer;
    }

    public RideRequestState getState() {
        return state;
    }

    public void setState(final RideRequestState state) {
        this.state = state;
    }

}
