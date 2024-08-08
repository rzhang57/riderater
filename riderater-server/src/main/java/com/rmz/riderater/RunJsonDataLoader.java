package com.rmz.riderater;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rmz.riderater.model.Attraction;
import com.rmz.riderater.repository.AttractionRepo;

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
    private final ObjectMapper objectMapper;

    public RunJsonDataLoader(AttractionRepo attractionRepo, ObjectMapper objectMapper) {
        this.attractionRepo = attractionRepo;
        this.objectMapper = objectMapper;
    }

    @Override
    public void run(String... args) throws Exception {
        Resource resource = new ClassPathResource("/data/attractions.json");
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
            log.info("Not injecting JSON, data exists already");
        }
    }
}
