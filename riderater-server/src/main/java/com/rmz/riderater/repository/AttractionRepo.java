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
        var updated = jdbcClient.sql("INSERT INTO Attractions(id, name, location, description) VALUES(?, ?, ?, ?)")
                .params(List.of(attraction.getId(), attraction.getName(), attraction.getLocation().toString(), attraction.getDescription()))
                .update();

        Assert.state(updated == 1, "Failed to create attraction");
    }


    // Retrieve
    public List<Attraction> getAttractions() {
        return jdbcClient.sql("select * from attractions")
                .query(Attraction.class)
                .list();
    }

    public Attraction getAttraction(Integer id) {
        return jdbcClient.sql("SELECT id, name, location, description FROM Attractions WHERE id = ?")
                .param(id) // passing in which variable to pass into the named param
                .query(Attraction.class)
                .single();
    }
    // Update
    public void update(Attraction attraction, Integer id) {
        var updated =  jdbcClient.sql("UPDATE Attractions SET name = ?, location = ?, description = ? WHERE id = ?")
                .params(List.of(attraction.getName(), attraction.getLocation().toString(), attraction.getDescription(), id))
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

    // Other sql operations

}
