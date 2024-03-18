package com.example.SpringBootCustomQuery1.controllers;

import com.example.SpringBootCustomQuery1.Status;
import com.example.SpringBootCustomQuery1.entities.Flight;
import com.example.SpringBootCustomQuery1.repositories.FlightRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RestController
@RequestMapping("/flight")
public class FlightController {
    @Autowired
    private FlightRepo flightRepo;

    @PostMapping("/provisioning")
    public List<Flight> provisioning() {
        List<Flight> flightList = new ArrayList<>();
        for (int i = 0; i <= 50; i++) {
            Flight flight = new Flight();
            flight.setDescription("description: " + random());
            flight.setFromAirport("from: " + random());
            flight.setToAirport("to: " + random());
            flight.setStatus(Status.ONTIME);
            flightList.add(flight);
        }
        return flightRepo.saveAll(flightList);
    }

    @GetMapping
    public List<Flight> getall() {
        return flightRepo.findAll();
    }
    private String random() {
        Random random = new Random();
        return random.ints(5, 0, 100)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining());
    }
}