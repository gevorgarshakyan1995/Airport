package com.connectto.controllers;

import com.connectto.DTO.Request.AirplaneSaveDtoReq;
import com.connectto.DTO.Response.AirplaneInfoGetDto;
import com.connectto.Exception.NotFoundException;
import com.connectto.model.Airplane;
import com.connectto.services.interfaces.AirplaneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.annotation.security.RolesAllowed;
import java.util.List;

@RestController
@RequestMapping(value = "/airplane")
public class AirplanesController {

    @Autowired
    private AirplaneService airplaneService;

    @RolesAllowed(value = "ROLE_ADMIN")
    @PostMapping
    ResponseEntity<Void> save(@RequestBody AirplaneSaveDtoReq airplaneSaveDtoReq) {
        airplaneService.save(airplaneSaveDtoReq);
        return ResponseEntity.ok().build();
    }
    @RolesAllowed(value = "ROLE_ADMIN")
    @GetMapping("/search")
    ResponseEntity<List<AirplaneInfoGetDto>> getAllAndSearch(@RequestParam(value = "cityDepartune", required = false) String cityDepartune,
                                                             @RequestParam(value = "cityArrival", required = false) String cityArrival,
                                                             @RequestParam(value = "remarks", required = false) String remarks,
                                                             @RequestParam(value = "timeArrivel", required = false) String timeArrivel,
                                                             @RequestParam(value = "timeDepature", required = false) String timeDepature) {
        return ResponseEntity.ok(airplaneService.getAllAndSearch(cityDepartune, cityArrival, remarks, timeArrivel, timeDepature));
    }
    @RolesAllowed(value = "ROLE_ADMIN")
    @GetMapping
    ResponseEntity<List<AirplaneInfoGetDto>> getAll() {
        return ResponseEntity.ok(airplaneService.getAll());
    }

    @RolesAllowed(value = "ROLE_ADMIN")
    @PutMapping
    ResponseEntity<Void> update(@RequestParam("flightNo") String flightNo,
                                @RequestParam("remarks") String remarks) throws NotFoundException {
        airplaneService.update(flightNo, remarks);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/serch-by-flight-No")
    ResponseEntity<AirplaneInfoGetDto> serchByFlidgtNo(@RequestParam("flightNo") String flightNo) throws NotFoundException {
        return ResponseEntity.ok(airplaneService.getByFlightNoSearch(flightNo));
    }

}
