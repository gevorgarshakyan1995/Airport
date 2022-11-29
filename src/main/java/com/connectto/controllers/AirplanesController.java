package com.connectto.controllers;

import com.connectto.DTO.Request.AirplaneSaveDtoReq;
import com.connectto.DTO.Response.AirplaneInfoGetDto;
import com.connectto.enums.Remarks;
import com.connectto.services.interfaces.AirplaneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;
import java.util.List;

@RestController
@RequestMapping(value = "/airplane")
public class AirplanesController {

    @Autowired
    private AirplaneService airplaneService;


    @PostMapping
    ResponseEntity<Void> save(@RequestBody AirplaneSaveDtoReq airplaneSaveDtoReq) {
        airplaneService.save(airplaneSaveDtoReq);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/search")
    ResponseEntity<List<AirplaneInfoGetDto>> getAllAndSearch(@RequestParam(value = "cityDepartune", required = false) String cityDepartune,
                                             @RequestParam(value = "cityArrival", required = false) String cityArrival,
                                             @RequestParam(value = "remarks", required = false) String remarks,
                                             @RequestParam(value = "timeArrivel", required = false) String timeArrivel,
                                             @RequestParam(value = "timeDepature", required = false) String timeDepature) {
        return ResponseEntity.ok(airplaneService.getAllAndSearch(cityDepartune, cityArrival, remarks, timeArrivel, timeDepature));
    }

    @GetMapping
    ResponseEntity<List<AirplaneInfoGetDto>> getAll(){
        return ResponseEntity.ok(airplaneService.getAll());
    }

}
