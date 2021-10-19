package com.wcs.citimmo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wcs.citimmo.dto.ReadUserDto;
import com.wcs.citimmo.entity.User;
import com.wcs.citimmo.service.UserService;

@RestController
@CrossOrigin("*")
public class UserController {

    @Autowired
    UserService userService;
    
    @GetMapping(value = "/user")
    public ReadUserDto getCurrentUser(@RequestParam String username) {
        User currentUser = userService.loadUser(username);
        return userService.MapToReadUserDto(currentUser);
    }
}
