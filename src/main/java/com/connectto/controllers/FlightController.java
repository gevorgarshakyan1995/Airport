package com.connectto.controllers;

import com.connectto.DTO.Response.UserDto;
import com.connectto.model.Flight;
import com.connectto.services.interfaces.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/flight")
public class FlightController {
    @Autowired
    private FlightService flightService;

    @PostMapping
    ResponseEntity<Void> save(@RequestBody Flight flight) {
        flightService.save(flight);
        return ResponseEntity.ok().build();
    }
}
