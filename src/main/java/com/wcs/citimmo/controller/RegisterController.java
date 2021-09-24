package com.wcs.citimmo.controller;

import com.wcs.citimmo.dto.RegisterDto;
import com.wcs.citimmo.mappers.RegisterMapper;
import com.wcs.citimmo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public ResponseEntity<?> registerUser(@RequestBody RegisterDto registerDto){
        return ResponseEntity.ok(userService.registerUser(registerDto));
    }
}
