package com.connectto.controllers;

import com.connectto.DTO.Response.UserDto;
import com.connectto.services.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    ResponseEntity<Void> save(@RequestBody UserDto userDto) {
        userService.save(userDto);
        return ResponseEntity.ok().build();
    }


}
