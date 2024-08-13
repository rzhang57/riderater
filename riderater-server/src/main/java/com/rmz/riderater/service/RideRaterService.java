package com.rmz.riderater.service;

import com.rmz.riderater.model.Attraction;
import com.rmz.riderater.model.Rating;
import com.rmz.riderater.repository.AttractionRepo;
import com.rmz.riderater.repository.RatingsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RideRaterService {

    @Autowired
    private AttractionRepo attractionRepo;
    @Autowired
    private RatingsRepo ratingsRepo;

    public Attraction getAttractionWithRatings(Integer attractionId) {
        Attraction attraction = attractionRepo.getAttraction(attractionId);

        List<Rating> ratings = ratingsRepo.getRatingAllRatingsByAttraction(attractionId);

        // check if this brute force initilization of serialized fields can be done prior to the service layer - def can be done within the repo maybe but might be able to do in base folders

        attractionRepo.updateAverageRating(attractionId);
        attraction.setRatings(ratings);


        return attraction;
    }

    public Attraction getAttractionWithRatingsWAttractionAttached(Integer attractionId) {
        Attraction attraction = attractionRepo.getAttraction(attractionId);

        List<Rating> ratings = ratingsRepo.getRatingAllRatingsByAttraction(attractionId);

        // check if this brute force initilization of serialized fields can be done prior to the service layer - def can be done within the repo maybe but might be able to do in base folders

        attraction.setRatings(ratings);
        // ^ currently dont want ratings when fetching - in future could be of use

        return attraction;
    }

    public List<Attraction> getAllAttractionsWithRatings() {
        int maxId = attractionRepo.getAttractions().size();
        List<Attraction> attractions = new ArrayList<>(maxId);

        for (Attraction attraction : attractionRepo.getAttractions()) {
            Attraction newAttraction = getAttractionWithRatings(attraction.getId());
            attractions.add(newAttraction);
        }

        return attractions;
    }

}