package com.wcs.citimmo.controller;

import com.wcs.citimmo.dto.RegisterDto;
import com.wcs.citimmo.mappers.RegisterMapper;
import com.wcs.citimmo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
public class RegisterController {

    @Autowired
    UserService userService;

    @Autowired
    RegisterMapper registerMapper;

    @PostMapping(value="/register", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<String> registerUser(@RequestBody RegisterDto registerDto){
        if(userService.registerUser(registerDto)){
            return ResponseEntity.status(HttpStatus.OK)
                    .body("Registration Complete");
        } else {
            return ResponseEntity.badRequest()
                    .body("Registration failed. An account already exists with that email.");
        }
    }
}
