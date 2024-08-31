package com.rmz.riderater.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;

import java.util.ArrayList;
import java.util.List;


@Entity
public class Attraction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty
    private String name;

    @Enumerated(EnumType.STRING)
    private Location location;
    private String description;
    private double averageRating;

    @OneToMany(mappedBy = "attraction", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Rating> ratings = new ArrayList<>();

    public Attraction(Integer id, String name, Location location, String description, double averageRating, List <Rating> ratings) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.description = description;
        this.averageRating = averageRating;
        this.ratings = ratings;
    }

    public Attraction(Integer id, String name, String location, String description, double averageRating, List<Rating> ratings) {
        this.id = id;
        this.name = name;
        this.location = Location.valueOf(location);
        this.description = description;
        this.averageRating = averageRating;
        this.ratings = ratings;
    }

    public Attraction(Integer id, String name, Location location, String description) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.description = description;
        this.averageRating = updateAverageRating();
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

    public double updateAverageRating() {
        if (ratings != null && !ratings.isEmpty()) {
            double counter = 0;
            for (Rating rating : ratings) {
                counter += (double) rating.getRating();
            }
            averageRating = counter / ratings.size();
            return averageRating;
        }
        return 0.0;
    }

    public double getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(double averageRating) {
        this.averageRating = averageRating;
    }

    public List<Rating> getRatings() {
        return ratings;
    }

    public void addRating(Rating rating) {
        ratings.add(rating);
        rating.setAttraction(this);
        updateAverageRating();
    }

    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
    }
}
