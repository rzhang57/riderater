package com.rmz.riderater;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/attractions/")
public class RideRaterController {

    private final AttractionRepo aRepo;

    @Autowired // implicit with only one constructor in controller, but might need if has multiple
    public RideRaterController(AttractionRepo aRepo) {
        this.aRepo = aRepo; // Singleton, only 1 repository, we should not be able to make new instances using new keyword
    }


    //post (create)
    @ResponseStatus(HttpStatus.CREATED) // directly tells if something was created so no need to check the database to see
    @PostMapping("")
    public void create(@Valid @RequestBody Attraction a) {
        aRepo.createAttraction(a);
    }

    //Search (Read)
    @GetMapping("")
    public List<Attraction> findAll() {
        return aRepo.getAttractions();
    }

    @GetMapping("{id}")
    public Attraction getAttraction(@PathVariable Integer id) {
        return aRepo.getAttraction(id);
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
