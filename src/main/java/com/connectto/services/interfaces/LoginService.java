package com.connectto.services.interfaces;

import com.connectto.DTO.AirplaneSaveDtoReq;
import com.connectto.DTO.FlightInfoGetDto;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.List;

public interface LoginService {

    List<FlightInfoGetDto> login(Principal principal);

    ModelAndView getAirplaneByFlightTicket(String cityDepartune, String cityArrival, String timeFrom,
                                                  String timeTo,Principal principal);

    void bookTichet(String flightNo, String statusTicket, Principal principal);

    ModelAndView addUpdateForm(String flightNo);

    void Update(AirplaneSaveDtoReq airplane);

    void delete(String flightNo, String statusTicket);

}
