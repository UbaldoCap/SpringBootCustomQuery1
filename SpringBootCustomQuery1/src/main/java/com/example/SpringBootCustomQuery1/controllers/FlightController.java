package com.example.SpringBootCustomQuery1.controllers;

import com.example.SpringBootCustomQuery1.Status;
import com.example.SpringBootCustomQuery1.entities.Flight;
import com.example.SpringBootCustomQuery1.repositories.FlightRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RestController
@RequestMapping("/flight")
public class FlightController {
    @Autowired
    private FlightRepo flightRepo;

    @PostMapping("/addfifty")
    public ResponseEntity<String> provisioningFiftyFlight() {
        for (int i = 0; i <= 50; i++) {
            String description = "description: " + random();
            String fromAirport = "from: " + random();
            String toAirport = "to: " + random();
            String status = Status.ONTIME.getString();
            flightRepo.insertFlight(description, fromAirport, toAirport, status);
        }
        return ResponseEntity.ok("50 flight added");
    }

    @GetMapping
    public List<Flight> getall() {
        return flightRepo.selectAll();
    }
    private String random() {
        Random random = new Random();
        return random.ints(5, 0, 100)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining());
    }
}