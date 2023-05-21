package com.connectto.controllers;

import com.connectto.DTO.AirplaneDto;

import com.connectto.DTO.FlightSaveDto;
import com.connectto.DTO.SearchFligtDto;
import com.connectto.services.interfaces.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.security.RolesAllowed;
import java.security.Principal;

@Controller
@RequestMapping(value = "/flight")
public class FlightController {
    @Autowired
    private FlightService flightService;

    @RolesAllowed(value = "ROLE_ADMIN")
    @PostMapping
    ResponseEntity<Void> save(@RequestBody FlightSaveDto flight) {
        flightService.save(flight);
        return ResponseEntity.ok().build();
    }
    @GetMapping({"/list"})
    public ModelAndView getAirplaneByFlightTicket(@ModelAttribute SearchFligtDto fligtDto,
                                                  Principal principal) {
        return flightService.getAirplaneByFlightTicket(fligtDto,principal);
    }

    @GetMapping("/book")
    public String bookTichet(@RequestParam("flightNo") String flightNo,
                             @RequestParam("statusTicket") String statusTicket, Principal principal) {
        flightService.bookTichet(flightNo, statusTicket, principal);
        return "redirect:/flight/list";
    }

    @RolesAllowed(value = "ROLE_ADMIN")
    @GetMapping("/add-form")
    public ModelAndView addUpdateForm(@RequestParam("flightNo") String flightNo) {
        return flightService.addUpdateForm(flightNo);
    }

    @RolesAllowed(value = "ROLE_ADMIN")
    @GetMapping("/delete")
    public String delete(@RequestParam("flightNo") String flightNo,
                         @RequestParam("statusTicket") String statusTicket) {
        flightService.delete(flightNo, statusTicket);
        return "redirect:/flight/list";
    }
}
