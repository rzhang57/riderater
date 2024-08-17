package com.rmz.riderater.repository;

import com.rmz.riderater.model.Attraction;
import com.rmz.riderater.model.Rating;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import java.util.List;

@Repository
public class RatingsRepo {
    private static final Logger logger = LoggerFactory.getLogger(AttractionRepo.class);
    private final JdbcClient jdbcClient;
    private final AttractionRepo attractionRepo;

    public RatingsRepo(JdbcClient jdbcClient, AttractionRepo attractionRepo) {
        this.jdbcClient = jdbcClient;
        this.attractionRepo = attractionRepo;
    }

    // Create

    public void createRating(Rating rating, Attraction attraction) {
        var updated = jdbcClient.sql("INSERT INTO Ratings(id, rating, comment, attraction_id, date) VALUES(?, ?, ?, ?, ?)")
                .params(List.of(rating.getId(), rating.getRating(), rating.getComment(), attraction.getId(), rating.getDate()))
                .update();

        if (updated == 1) {
            attraction.addRating(rating);
            attraction.updateAverageRating();

            attractionRepo.updateAverageRating(attraction.getId());
            logger.info("Updated average rating {}", attraction);
        }

        Assert.state(updated == 1, "Failed to create Rating for the given attraction @ " + rating.getAttraction().getId());

        logger.info("Updated average rating");
    }

    public void createRatingDefDate(Rating rating, Attraction attraction) {
        var updated = jdbcClient.sql("INSERT INTO Ratings(id, rating, comment, attraction_id) VALUES(?, ?, ?, ?)")
                .params(List.of(rating.getId(), rating.getRating(), rating.getComment(), attraction.getId()))
                .update();

        if (updated == 1) {
            attraction.addRating(rating);
            attraction.updateAverageRating();

            attractionRepo.updateAverageRating(attraction.getId());
            logger.info("Updated average rating {}", attraction);
        }

        Assert.state(updated == 1, "Failed to create Rating for the given attraction @ " + rating.getAttraction().getId());

        logger.info("Updated average rating");
    }

    // Retrieve
    public List<Rating> getAllRatings() {
        return jdbcClient.sql("select * from ratings")
                .query(new RatingsRowMapper(attractionRepo))
                .list();
    }

    public List<Rating> getRatingAllRatingsByAttraction(Integer id) {
        return jdbcClient.sql("select * from ratings WHERE attraction_id = ?")
                .param(id)
                .query(new RatingsRowMapper(attractionRepo))
                .list();
    }

    // Update
    public void updateRating(Rating rating, Integer id) {
        var updated = jdbcClient.sql("UPDATE Ratings SET rating = ? WHERE id = ?")
                .params(rating.getRating(), id)
                .update();

        Assert.state(updated == 1, "Couldn't update rating with ID " + id);
    }

    // Delete
    public void deleteRating(Integer id) {
        var updated = jdbcClient.sql("DELETE FROM Ratings WHERE id = ?")
                .param(id)
                .update();

        Assert.state(updated == 1, "Failed to delete rating at id " + id);
    }

}
