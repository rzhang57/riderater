package com.rmz.riderater.service;

import com.rmz.riderater.model.Attraction;
import com.rmz.riderater.model.Rating;
import com.rmz.riderater.repository.AttractionRepo;
import com.rmz.riderater.repository.RatingsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttractionService {

    @Autowired
    private AttractionRepo attractionRepo;

    @Autowired
    private RatingsRepo ratingsRepo;

    public Attraction getAttractionWithRatings(Integer attractionId) {
        Attraction attraction = attractionRepo.getAttraction(attractionId);

        List<Rating> ratings = ratingsRepo.getRatingAllRatingsByAttraction(attractionId);

        // check if this brute force initilization of serialized fields can be done prior to the service layer - def can be done within the repo maybe but might be able to do in base folders
        attraction.setRatings(ratings);

        return attraction;
    }
}