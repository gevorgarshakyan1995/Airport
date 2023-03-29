package com.connectto.controllers;


import com.connectto.DTO.FlightInfoGetDto;
import com.connectto.services.interfaces.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping(value = "/")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @GetMapping
    ResponseEntity<List<FlightInfoGetDto>> login(Principal principal) {
        return ResponseEntity.ok(loginService.login(principal));

    }

}