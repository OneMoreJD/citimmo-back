package com.wcs.citimmo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.wcs.citimmo.dto.CreateApplicationDto;
import com.wcs.citimmo.service.ApplicationService;

@RestController
@CrossOrigin("*")
public class ApplicationController {

    @Autowired
    ApplicationService appliService;
    
    @PostMapping(value = "/application")
    @ResponseBody
    public boolean createApplication(@RequestBody CreateApplicationDto dto ) {
        return appliService.createApplication(dto);
    }
}
