package com.rmz.riderater.repository;

import com.rmz.riderater.model.Attraction;
import com.rmz.riderater.model.Rating;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RatingsRowMapper implements RowMapper {
    private final AttractionRepo attractionRepo;

    public RatingsRowMapper(AttractionRepo attractionRepo) {
        this.attractionRepo = attractionRepo;
    }

    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        // initial creation of rating
        Rating rating = new Rating(rs.getInt("id"), rs.getInt("rating"), rs.getString("comment"), rs.getDate("date").toLocalDate());

        // extrapolates attraction from foreign key, maps it to rating
/*
        Attraction attraction = attractionRepo.getAttraction(rs.getInt("attraction_id"));
        rating.setAttraction(attraction);
*/

        return rating;
    }
}
