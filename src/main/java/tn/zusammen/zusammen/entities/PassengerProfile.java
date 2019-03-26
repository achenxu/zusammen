package tn.zusammen.zusammen.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;

@Document
public final class PassengerProfile {

    @Id
    private String id;

    @DBRef
    @NotNull
    private final User user;

    private boolean smoker;
    private boolean acceptsMusic;
    private boolean acceptsRadio;

    @PersistenceConstructor
    public PassengerProfile(@NotNull final User user) {
        this.user = user;
    }

    public String getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public boolean isSmoker() {
        return smoker;
    }

    public boolean isAcceptsMusic() {
        return acceptsMusic;
    }

    public boolean isAcceptsRadio() {
        return acceptsRadio;
    }

    public void setSmoker(boolean smoker) {
        this.smoker = smoker;
    }

    public void setAcceptsMusic(boolean acceptsMusic) {
        this.acceptsMusic = acceptsMusic;
    }

    public void setAcceptsRadio(boolean acceptsRadio) {
        this.acceptsRadio = acceptsRadio;
    }

}
