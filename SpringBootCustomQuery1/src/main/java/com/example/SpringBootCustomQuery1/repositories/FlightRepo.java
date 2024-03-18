package com.example.SpringBootCustomQuery1.repositories;

import com.example.SpringBootCustomQuery1.Status;
import com.example.SpringBootCustomQuery1.entities.Flight;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightRepo extends JpaRepository<Flight, Long> {
    @Modifying
    @Transactional
    @Query(value = "insert into Flight (description, from_airport, to_airport, status) " +
            "values (:description, :from_airport, :to_airport, :status)", nativeQuery = true)
    void insertFlight(@Param("description") String description,
                     @Param("from_airport") String fromAirport,
                     @Param("to_airport") String toAirport,
                     @Param("status") String status);

    @Query("select f from Flight f")
    List<Flight> selectAll();
}
