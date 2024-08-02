package com.rmz.riderater.repository;


import com.rmz.riderater.model.Attraction;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AttractionRepo {
    private static final Logger logger = LoggerFactory.getLogger(AttractionRepo.class);
    private final JdbcClient jdbcClient;

    public AttractionRepo(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

    // Create
    public List<Attraction> getAttractions() {
        return jdbcClient.sql("select * from attractions")
                .query(Attraction.class)
                .list();
    }


    // Retrieve
    // Update
    // Delete
}
