package com.connectto.controllers;

import com.connectto.DTO.FlightDtoReq;
import com.connectto.model.Flight;
import com.connectto.services.interfaces.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;

@RestController
@RequestMapping(value = "/flight")
public class FlightController {
    @Autowired
    private FlightService flightService;

    @RolesAllowed(value = "ROLE_ADMIN")
    @PostMapping
    ResponseEntity<Void> save(@RequestBody FlightDtoReq flight) {
        flightService.save(flight);
        return ResponseEntity.ok().build();
    }
}
