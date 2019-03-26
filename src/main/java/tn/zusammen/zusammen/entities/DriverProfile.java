package tn.zusammen.zusammen.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import java.util.Date;

@Document
public final class DriverProfile {

    @Id
    private String id;

    @DBRef
    @NotNull
    private final User user;

    @PastOrPresent(message = "Licence date of issue can't be in the future.")
    private Date licenceDateOfIssue;

    @PersistenceConstructor
    public DriverProfile(@NotNull final User user) {
        this.user = user;
    }

    public String getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public Date getLicenceDateOfIssue() {
        return licenceDateOfIssue;
    }

    public void setLicenceDateOfIssue(final Date licenceDateOfIssue) {
        this.licenceDateOfIssue = licenceDateOfIssue;
    }

}
