/*
package com.rmz.riderater.repository;

import com.rmz.riderater.model.Attraction;
import com.rmz.riderater.model.Location;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AttractionRepoTester {

    private List<Attraction> attractions = new ArrayList<>();

    public List<Attraction> getAttractions() {
        return attractions;
    }

    public Attraction getAttraction(Integer id) {
        for (Attraction a : attractions) {
            if (a.getId() == id) {
                return a;
            }
        }

        return null;
    }

    public void createAttraction(Attraction a) {
        attractions.add(a);
    }

    @PostConstruct // adds attractions after running for testing purposes
    private void init() {
        attractions.add(new Attraction(1, "Jack", Location.CALIFORNIA, "Boat ride"
        ));

        attractions.add(new Attraction(2, "Jack", Location.SHANGHAI, "Boat ride"
        ));
    }

    //update

    public void update (Attraction a, Integer id) {
        Attraction old = getAttraction(id);
        attractions.set(attractions.indexOf(old), a);
    }

    //delete

    public void delete (Integer id) {
        attractions.removeIf(attraction -> attraction.getId() == id);
    }
}
*/
