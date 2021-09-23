package com.wcs.citimmo.controller;

import com.wcs.citimmo.dto.RegisterDto;
import com.wcs.citimmo.mappers.RegisterMapper;
import com.wcs.citimmo.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
public class RegisterController {

    @Autowired
    RegisterService registerService;

    @Autowired
    RegisterMapper registerMapper;

    @PostMapping(value="/register", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public RegisterDto registerUser(@RequestBody RegisterDto registerDto){
        System.out.println(registerDto);
        return registerDto ;
    }
}
