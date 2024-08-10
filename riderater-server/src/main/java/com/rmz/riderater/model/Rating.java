package com.rmz.riderater.model;

import jakarta.persistence.*;

@Entity
public class Rating {

    //FOREIGN KEY
    //Category of ratings

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer rating;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "attraction_id", nullable = false)
    private Attraction attraction;
    //private String review;

    public Rating(Integer id, Integer rating, Attraction attraction) {
        this.id = id;
        this.rating = rating;
        this.attraction = attraction;
    }

    public Rating() {

    }

    // Getters and setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public Attraction getAttraction() {
        return attraction;
    }

    public void setAttraction(Attraction attraction) {
        this.attraction = attraction;
    }
}
