package com.connectto.services.implementations;

import com.connectto.DTO.FlightDtoReq;
import com.connectto.model.Airplane;
import com.connectto.model.Flight;
import com.connectto.repositores.AirplaneRepository;
import com.connectto.repositores.FlightRepository;
import com.connectto.services.interfaces.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FlightServiceImpl implements FlightService {

    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private AirplaneRepository airplaneRepository;

    @Override
    public void save(FlightDtoReq flightDtoReq) {
        Airplane airplane = airplaneRepository.getByFlightNo(flightDtoReq.getFlightNo());
        Flight flight = new Flight();
        flight.setCount(flightDtoReq.getCount());
        flight.setAirplane(airplane);
        flight.setPrice(flight.getPrice());
        flight.setStatusTicket(flight.getStatusTicket());
        flightRepository.save(flight);
    }
}
