package com.connectto.controllers;

import com.connectto.DTO.AirplaneDto;
import com.connectto.Exception.NotFoundException;
import com.connectto.services.interfaces.AirplaneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import javax.annotation.security.RolesAllowed;
import java.util.List;

@Controller
@RequestMapping(value = "/airplane")
public class AirplanesController {

    @Autowired
    private AirplaneService airplaneService;

    @RolesAllowed(value = "ROLE_ADMIN")
    @PostMapping
    ResponseEntity<Void> save(@RequestBody AirplaneDto airplaneDto) {
        airplaneService.save(airplaneDto);
        return ResponseEntity.ok().build();
    }

    @RolesAllowed(value = "ROLE_ADMIN")
    @GetMapping("/search")
    ResponseEntity<List<AirplaneDto>> getAllAndSearch(@RequestParam(value = "cityDepartune", required = false) String cityDepartune,
                                                             @RequestParam(value = "cityArrival", required = false) String cityArrival,
                                                             @RequestParam(value = "remarks", required = false) String remarks,
                                                             @RequestParam(value = "timeArrivel", required = false) String timeArrivel,
                                                             @RequestParam(value = "timeDepature", required = false) String timeDepature) {
        return ResponseEntity.ok(airplaneService.getAllAndSearch(cityDepartune, cityArrival, remarks, timeArrivel, timeDepature));
    }

    @RolesAllowed(value = "ROLE_ADMIN")
    @PostMapping("/Update")
    public String Update(@ModelAttribute AirplaneDto airplane) {
        airplaneService.Update(airplane);
        return "redirect:/flight/list";

    }

}
