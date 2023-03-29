package com.connectto.services.interfaces;


import com.connectto.DTO.AirplaneSaveDtoReq;
import com.connectto.DTO.FlightDtoReq;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

public interface FlightService {

    void save(FlightDtoReq flight);

    ModelAndView getAirplaneByFlightTicket(String cityDepartune, String cityArrival, String timeFrom,
                                           String timeTo, Principal principal);

    void bookTichet(String flightNo, String statusTicket, Principal principal);

    ModelAndView addUpdateForm(String flightNo);

    void Update(AirplaneSaveDtoReq airplane);

    void delete(String flightNo, String statusTicket);

}
