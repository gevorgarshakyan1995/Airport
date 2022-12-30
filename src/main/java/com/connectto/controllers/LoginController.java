package com.connectto.controllers;

import com.connectto.DTO.Response.AirplaneInfoGetDto;
import com.connectto.services.interfaces.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping(value = "/")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @GetMapping
    ResponseEntity<List<AirplaneInfoGetDto>> login(Principal principal) {
        return ResponseEntity.ok(loginService.login(principal));

    }

    @GetMapping({"/list"})
    public ModelAndView getAirplaneByFlightTicket(@RequestParam(value = "cityDepartune", required = false) String cityDepartune,
                                                  @RequestParam(value = "cityArrival", required = false) String cityArrival,
                                                  @RequestParam(value = "timeFrom", required = false) String timeFrom,
                                                  @RequestParam(value = "timeTo", required = false) String timeTo) {

        return loginService.getAirplaneByFlightTicket(cityDepartune, cityArrival, timeFrom, timeTo);
    }

}