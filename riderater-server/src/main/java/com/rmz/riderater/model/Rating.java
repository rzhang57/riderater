package com.rmz.riderater.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
public class Rating {

    //FOREIGN KEY
    //Category of ratings

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer rating;
    private String comment;

    @Column(nullable = false, updatable = false)
    private LocalDate date;

/*    @PrePersist
    protected void onCreate() {
        this.date = LocalDate.now();
    }*/

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


    public Rating(Integer id, Integer rating, String comment, LocalDate date, Attraction attraction) {
        this.id = id;
        this.rating = rating;
        this.comment = comment;
        this.date = date;
        this.attraction = attraction;
    }

    public Rating(Integer id, Integer rating, String comment, LocalDate date) {
        this.id = id;
        this.rating = rating;
        this.comment = comment;
        this.date = date;
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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Attraction getAttraction() {
        return attraction;
    }

    public void setAttraction(Attraction attraction) {
        this.attraction = attraction;
    }
}
