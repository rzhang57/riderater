package com.rmz.riderater.repository;


import com.rmz.riderater.model.Attraction;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import java.util.List;

@Repository
public class AttractionRepo {
    private static final Logger logger = LoggerFactory.getLogger(AttractionRepo.class);
    private final JdbcClient jdbcClient;

    public AttractionRepo(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

    // Create
    public void createAttraction(Attraction attraction) {
        var updated = jdbcClient.sql("INSERT INTO Attractions(id, name, location, description, averageRating) VALUES(?, ?, ?, ?, ?)")
                .params(List.of(attraction.getId(), attraction.getName(), attraction.getLocation().toString(), attraction.getDescription(), attraction.updateAverageRating()))
                .update();

        Assert.state(updated == 1, "Failed to create attraction");
    }


    // Retrieve

    // should create a system so that get request for a given attraction shows a transient list of TOP REVIEWS for a given attraction
    public List<Attraction> getAttractions() {
        return jdbcClient.sql("select * from attractions")
                .query(Attraction.class)
                .list();
    }

    public List<Attraction> getAttractionsByPark() {
        return jdbcClient.sql("select * from attractions")
                .query(Attraction.class)
                .list();
    }

    public List<String> getAttractionNames() {
        return jdbcClient.sql("select name from attractions")
                .query(String.class)
                .list();
    }

    public Attraction getAttraction(Integer id) {
        return jdbcClient.sql("SELECT * FROM Attractions WHERE id = ?")
                .param(id) // passing in which variable to pass into the named param
                .query(Attraction.class)
                .single();
    }


    // Update
    public void update(Attraction attraction, Integer id) {
        var updated =  jdbcClient.sql("UPDATE Attractions SET name = ?, location = ?, description = ?, average_rating = ? WHERE id = ?")
                .params(List.of(attraction.getName(), attraction.getLocation().toString(), attraction.getDescription(), attraction.updateAverageRating(), id))
                .update();

        Assert.state(updated == 1, "Failed to update attraction at id " + id);
    }

    // Delete

    public void delete(Integer id) {
        var updated = jdbcClient.sql("DELETE FROM Attractions WHERE id = ?")
                .params(id)
                .update();
        Assert.state(updated == 1, "Failed to delete attraction at id " + id);
    }

    // instead average rating inside attractions table, should put into a view instead of directly in schema, done in database directly - get data from view instead of calculating through jdbc

    public void updateAverageRating(Integer attractionId) {
        var updated = jdbcClient.sql(
                        "UPDATE Attractions " +
                                "SET averageRating = (" +
                                "    SELECT AVG(rating) " +
                                "    FROM Ratings " +
                                "    WHERE attraction_id = ?" +
                                ") " +
                                "WHERE id = ?"
                )
                .params(attractionId, attractionId)
                .update();
    }

    // Other sql operations

}
