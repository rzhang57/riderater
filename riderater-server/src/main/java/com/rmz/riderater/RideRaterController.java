package com.rmz.riderater;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RideRaterController {

    @GetMapping("/")
    public String homePage() {
        return "Hello world!";
    }
}
