package com.rmz.riderater.controller;

import com.rmz.riderater.model.Attraction;
import com.rmz.riderater.model.Rating;
import com.rmz.riderater.repository.AttractionRepo;
import com.rmz.riderater.repository.RatingsRepo;
import com.rmz.riderater.service.RideRaterService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;

//AUTHORIZATION/ AUTHENTICATION - permissions (admin)
// change this class to attractionscontroller, make a new class for ratings that allows lower level users (even anon maybe) to make ratings
// who can read vs. who can write (3 levels) permissions

//paging for get requests - don't send all ratings at once

@RestController
@RequestMapping("api/attractions/")
public class RideRaterController {

    private final AttractionRepo aRepo;
    private final RatingsRepo rRepo;
    private final RideRaterService aService;

    @Autowired // implicit with only one constructor in controller, but might need if has multiple
    public RideRaterController(AttractionRepo aRepo, RatingsRepo rRepo, RideRaterService aService) {
        this.aRepo = aRepo; // Singleton, only 1 repository, we should not be able to make new instances using new keyword
        this.rRepo = rRepo;
        this.aService = aService;
    }

    @GetMapping("/")
    public List<Attraction> findAll() {
        return aService.getAllAttractionsWithRatings();
    }


    //post (create)
    // create attraction
    @ResponseStatus(HttpStatus.CREATED) // directly tells if something was created so no need to check the database to see
    @PostMapping("/")
    public void create(@Valid @RequestBody Attraction a) {
        aRepo.createAttraction(a);
    }

    //create rating
    @ResponseStatus(HttpStatus.CREATED) // directly tells if something was created so no need to check the database to see
    @PostMapping("/{id}")
    public void createRating(@Valid @RequestBody Rating r, @PathVariable Integer id) {
        Attraction a = aRepo.getAttraction(id);
        rRepo.createRating(r, a);
    }

    //Search (Read)
    @GetMapping("/{id}")
    public Attraction getAttraction(@PathVariable Integer id) {
        Attraction attraction = aService.getAttractionWithRatings(id);
        if (attraction == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Attraction not found");
        }
        return attraction;
    }

    @GetMapping("/{id}/ratings")
    public List<Rating> getRatings(@PathVariable Integer id) {
        return rRepo.getRatingAllRatingsByAttraction(id);
    }

    //put (update)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("{id}")
    public void update(@Valid @RequestBody Attraction a, @PathVariable Integer id) {
        aRepo.update(a, id);
    }

    //delete (delete)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id) {
        aRepo.delete(id);
    }
}
