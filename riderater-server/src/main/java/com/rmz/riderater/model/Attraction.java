package com.rmz.riderater.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;


@Entity
public class Attraction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty
    private String name;
    private Location location;
    private String description;

    public Attraction(Integer id, String name, Location location, String description) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.description = description;
    }

    public Attraction() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
