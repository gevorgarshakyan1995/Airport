package com.connectto.controllers;

import com.connectto.DTO.Response.AirplaneInfoGetDto;

import com.connectto.services.interfaces.AirplaneService;
import com.connectto.services.interfaces.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping(value = "/")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @GetMapping
    ResponseEntity<List<AirplaneInfoGetDto>> login(Principal principal) {
        return  ResponseEntity.ok(loginService.login(principal));

    }

}
