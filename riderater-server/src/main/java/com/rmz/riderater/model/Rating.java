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
    private String comment;
    // date CREATED

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "attraction_id", nullable = false)
    private Attraction attraction;
    //private String review;

    public Rating(Integer id, Integer rating, String comment, Attraction attraction) {
        this.id = id;
        this.rating = rating;
        this.comment = comment;
        this.attraction = attraction;
    }

    public Rating(Integer id, Integer rating, String comment) {
        this.id = id;
        this.rating = rating;
        this.comment = comment;
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

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getComment() {
        return comment;
    }

    public Attraction getAttraction() {
        return attraction;
    }

    public void setAttraction(Attraction attraction) {
        this.attraction = attraction;
    }
}
