package com.example.SpringBootCustomQuery1.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private String from_airport;
    private String to_airport;
    private String status;

    public Flight(Long id, String description, String from_airport, String to_airport, String status) {
        this.id = id;
        this.description = description;
        this.from_airport = from_airport;
        this.to_airport = to_airport;
        this.status = status;
    }

    public Flight() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFrom_airport() {
        return from_airport;
    }

    public void setFrom_airport(String from_airport) {
        this.from_airport = from_airport;
    }

    public String getTo_airport() {
        return to_airport;
    }

    public void setTo_airport(String to_airport) {
        this.to_airport = to_airport;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
