package com.example.SpringBootCustomQuery1.repositories;

import com.example.SpringBootCustomQuery1.entities.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightRepo extends JpaRepository<Flight, Long> {
}
