package tn.zusammen.zusammen.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import tn.zusammen.zusammen.enums.MemberState;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Document
public final class MemberProfile {

    @Id
    private String id;

    @NotNull
    private MemberState state;

    @DBRef
    @NotNull
    private final User user;

    @PersistenceConstructor
    public MemberProfile(@NotNull final User user) {
        this.state = MemberState.DISABLED;
        this.user = user;
    }

    public String getId() {
        return id;
    }

    public MemberState getState() {
        return state;
    }

    public User getUser() {
        return user;
    }

    public void setState(final MemberState state) {
        this.state = state;
    }

}
