package com.wcs.citimmo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wcs.citimmo.model.EstateType;

@RestController
@CrossOrigin("*")
public class EstateController {

    @GetMapping(value = "/estates")
    public List<EstateType> getEstateTypes() {
        List<EstateType> types = Stream.of(EstateType.values()).collect(Collectors.toList());
        return types;
    }
}
