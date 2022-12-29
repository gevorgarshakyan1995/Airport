package com.connectto.services.implementations;

import com.connectto.model.Flight;
import com.connectto.repositores.FlightRepository;
import com.connectto.services.interfaces.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FlightServiceImpl implements FlightService {

    @Autowired
    private FlightRepository flightRepository;

    @Override
    public void save(Flight flight) {
        flightRepository.save(flight);
    }
}
