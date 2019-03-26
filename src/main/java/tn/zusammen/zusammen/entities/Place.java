package tn.zusammen.zusammen.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Document
public final class Place {

    @Id
    private String id;

    @NotNull
    @Size(min = 3)
    private String name;

    @NotNull
    private final Point location;

    @PersistenceConstructor
    public Place(@NotNull @Size(min = 3) final String name, @NotNull final Point location) {
        this.name = name;
        this.location = location;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Point getLocation() {
        return location;
    }

    public void setName(final String name) {
        this.name = name;
    }

}
