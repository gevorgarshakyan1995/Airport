package com.connectto.services.interfaces;


import com.connectto.DTO.FlightDtoReq;
import com.connectto.model.Flight;

public interface FlightService {

    void save(FlightDtoReq flight);
}
