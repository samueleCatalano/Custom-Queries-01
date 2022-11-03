package com.customqueries01.customqueries01.controllers;

import com.customqueries01.customqueries01.entities.Flight;
import com.customqueries01.customqueries01.status.Status;
import com.customqueries01.customqueries01.repositories.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/flights")
public class FlightController {


    @Autowired
    private FlightRepository flightRepository;

    @PostMapping("")
    public void createFlight50(){
        Random random = new Random();
        for(int i = 0;i<50;i++){
            Flight flight = new Flight();
            String randomstring = random.ints(1,  100,8)
                    .collect(StringBuilder::new,
                            StringBuilder::appendCodePoint,
                            StringBuilder::append)
                    .toString();
            flight.setDescription(randomstring+""+randomstring+""+randomstring);
            flight.setFromAirport(randomstring);
            flight.setToAirport(randomstring);
            flight.setStatus(Status.ONTIME);
            flightRepository.save(flight);


        }

    }

    @GetMapping("")
    public List<Flight> getFlightList(){
        return flightRepository.findAll();
    }

}
