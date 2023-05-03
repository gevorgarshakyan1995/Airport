package com.connectto.services.implementations;

import com.connectto.DTO.FlightInfoGetDto;
import com.connectto.enums.Remarks;
import com.connectto.model.Flight;
import com.connectto.repositores.FlightRepository;
import com.connectto.services.interfaces.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LoginSeviceImpl implements LoginService {

    @Autowired
    private FlightRepository flightRepository;

    @Override
    public List<FlightInfoGetDto> login(Principal principal) {
        List<Flight> flights = flightRepository.findByBookUserEmail(principal.getName());
        List<FlightInfoGetDto> list = flights.stream()
                .map(flight -> new FlightInfoGetDto(
                        flight.getAirplane().getFlightNo(),
                        flight.getAirplane().getCityDepartune(),
                        flight.getAirplane().getCityArrival(),
                        flight.getAirplane().getTimeDepature(),
                        flight.getAirplane().getTimeArrivel(),
                        flight.getAirplane().getRemarks(),
                        flight.getPrice(),
                        flight.getCount(),
                        flight.getStatusTicket()))
                .collect(Collectors.toList());
        list.removeIf(flightInfoGetDto -> flightInfoGetDto.getRemarks() == Remarks.ON_TIME);
        return list;
    }

}
