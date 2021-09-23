package com.wcs.citimmo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wcs.citimmo.dto.QuickSearchDto;
import com.wcs.citimmo.entity.Advert;
import com.wcs.citimmo.entity.TransactionType;
import com.wcs.citimmo.service.AdvertService;

@RestController
@CrossOrigin("*")
public class AdvertController {

    @Autowired
    AdvertService advertService;
    
    @GetMapping("/adverts/filter")
    public List<Advert> quickSearch(@RequestParam String transaction, @RequestParam String location, @RequestParam int budget) {
        TransactionType type = TransactionType.valueOf(transaction);
        QuickSearchDto dto = new QuickSearchDto(type, location, budget);
        return advertService.findAdvertsByCriteria(dto);
    }
}
