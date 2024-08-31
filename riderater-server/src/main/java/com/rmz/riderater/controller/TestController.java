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

@RestController
public class TestController {

    @GetMapping("/")
    public String index() {
        return "Hello World";
    }

    @GetMapping("/test")
    public String test() {
        return "Hello World";
    }
}