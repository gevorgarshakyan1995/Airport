package com.connectto.services.interfaces;

import com.connectto.DTO.AirplaneInfoGetDto;
import com.connectto.DTO.AirplaneSaveDtoReq;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.List;

public interface LoginService {

    List<AirplaneInfoGetDto> login(Principal principal);

    public ModelAndView getAirplaneByFlightTicket(String cityDepartune, String cityArrival, String timeFrom, String timeTo);

    void bookTichet(String flightNo, String statusTicket, Principal principal);

    ModelAndView addUpdateForm(String flightNo);

    void Update(AirplaneSaveDtoReq airplane);

    void delete(String flightNo, String statusTicket);

}
