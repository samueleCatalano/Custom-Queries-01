package com.customqueries01.customqueries01.repositories;

import com.customqueries01.customqueries01.entities.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FlightRepository extends JpaRepository <Flight,Long>{

    @Query(value = "SELECT f FROM Flights f WHERE f.status =ONTIME",nativeQuery = true)
    List<Flight> findByStatusOnTime();
}
