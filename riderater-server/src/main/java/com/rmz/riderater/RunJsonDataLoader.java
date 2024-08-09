package com.rmz.riderater;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rmz.riderater.model.Attraction;
import com.rmz.riderater.model.Rating;
import com.rmz.riderater.repository.AttractionRepo;

import com.rmz.riderater.repository.RatingsRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Component
public class RunJsonDataLoader implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(RunJsonDataLoader.class);
    private final AttractionRepo attractionRepo;
    private final RatingsRepo ratingsRepo;
    private final ObjectMapper objectMapper;

    public RunJsonDataLoader(AttractionRepo attractionRepo, RatingsRepo ratingsRepo, ObjectMapper objectMapper) {
        this.attractionRepo = attractionRepo;
        this.ratingsRepo = ratingsRepo;
        this.objectMapper = objectMapper;
    }

    @Override
    public void run(String... args) throws Exception {
        Resource resource = new ClassPathResource("/data/attractions.json");
        Resource resource2 = new ClassPathResource("/data/ratings.json");
        if (attractionRepo.getAttractions().size() == 0) {
            try (InputStream inputStream = resource.getInputStream();) {
                List<Attraction> attractions = objectMapper.readValue(inputStream, new TypeReference<List<Attraction>>() {});
                for (Attraction attraction : attractions) {
                    attractionRepo.createAttraction(attraction);
                }
            } catch (IOException e) {
                throw new RuntimeException("Failed to read JSON data", e);
            }
        } else {
            log.info("Not injecting JSON, already ");
        }

        if (ratingsRepo.getAllRatings().size() == 0) {
            try (InputStream inputStream = resource2.getInputStream();) {
                List<Rating> ratings = objectMapper.readValue(inputStream, new TypeReference<List<Rating>>() {});

                for (Rating rating : ratings) {
                    Attraction a = attractionRepo.getAttraction(rating.getAttraction().getId());
                    ratingsRepo.createRating(rating, a);
                }
            } catch (IOException e) {
                throw new RuntimeException("Failed to read JSON data", e);
            }
        } else {
            log.info("Not injecting JSON, already ");
        }
    }
}
