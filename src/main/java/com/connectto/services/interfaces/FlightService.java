package com.connectto.services.interfaces;


import com.connectto.DTO.FlightSaveDto;
import com.connectto.DTO.SearchFligtDto;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

public interface FlightService {

    void save(FlightSaveDto flight);

    ModelAndView getAirplaneByFlightTicket(SearchFligtDto fligtDto, Principal principal);

    void bookTichet(String flightNo, String statusTicket, Principal principal);

    ModelAndView addUpdateForm(String flightNo);

    void delete(String flightNo, String statusTicket);

}
