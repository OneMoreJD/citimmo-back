package com.wcs.citimmo.controller;

import com.wcs.citimmo.dto.RegisterDto;
import com.wcs.citimmo.mappers.RegisterMapper;
import com.wcs.citimmo.service.UserService;
import com.wcs.citimmo.util.ResponseHandler;
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

    @PostMapping(value="/register", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Object> registerUser(@RequestBody RegisterDto registerDto){
        if(userService.registerUser(registerDto)){
            return ResponseHandler.generateResponse("Account successfully created", HttpStatus.OK, "");
        } else {
            return ResponseHandler.generateResponse("text:Registration failed. An account already exists with that email.", HttpStatus.CONFLICT, "");
        }
    }
}
