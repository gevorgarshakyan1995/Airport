package com.connectto.controllers;

import com.connectto.DTO.Request.AirplaneSaveDtoReq;
import com.connectto.DTO.Response.AirplaneInfoGetDto;
import com.connectto.services.interfaces.AirplaneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/airplane")
public class AirplanesController {

    @Autowired
    private AirplaneService airplaneService;


    @PostMapping
    void save(@RequestBody AirplaneSaveDtoReq airplaneSaveDtoReq) {
        airplaneService.save(airplaneSaveDtoReq);
    }

    @GetMapping("/search")
    List<AirplaneInfoGetDto> getAllAndSearch(@RequestParam("cityDepartune") String cityDepartune,
                                             @RequestParam("cityArrival") String cityArrival) {
        return airplaneService.getAllAndSearch(cityDepartune, cityArrival);
    }


}
