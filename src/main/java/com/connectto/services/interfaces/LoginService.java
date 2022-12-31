package com.connectto.services.interfaces;

import com.connectto.DTO.Response.AirplaneInfoGetDto;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.List;

public interface LoginService {

    List<AirplaneInfoGetDto> login (Principal principal);

    public ModelAndView getAirplaneByFlightTicket(String cityDepartune,String cityArrival,String timeFrom,String timeTo);

    void bookTichet(String flightNo,String statusTicket, Principal principal);
}
