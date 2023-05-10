package com.connectto.controllers;

import com.connectto.DTO.UserDto;
import com.connectto.Exception.NotFoundException;
import com.connectto.services.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

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

    @GetMapping
    ResponseEntity<UserDto> login(Principal principal) throws NotFoundException {
        return ResponseEntity.ok(userService.getBYEmail(principal.getName()));
    }


}
