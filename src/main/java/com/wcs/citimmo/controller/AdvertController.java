package com.wcs.citimmo.controller;

import java.util.List;
import java.util.Optional;

import com.wcs.citimmo.util.ResponseHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wcs.citimmo.dto.QuickSearchDto;
import com.wcs.citimmo.entity.Advert;
import com.wcs.citimmo.service.AdvertService;

@RestController
@CrossOrigin("*")
public class AdvertController {

    @Autowired
    AdvertService advertService;
    
    @GetMapping("/adverts/filter")
    public List<Advert> quickSearch(@RequestParam String transaction, @RequestParam String locations, @RequestParam Optional<Integer> budget) {
        QuickSearchDto dto = new QuickSearchDto(transaction, locations, budget);
        return advertService.findAdvertsByCriteria(dto);
    }

    @GetMapping("/adverts/filters/conditiontype")
    public ResponseEntity<Object> getConditionTypes(){
        return ResponseHandler.generateResponse("Condition types", HttpStatus.OK, advertService.getAllConditionTypes());
    }

    @GetMapping("/adverts/filters/transactiontype")
    public ResponseEntity<Object> getTransactionTypes(){
        return ResponseHandler.generateResponse("Transaction types", HttpStatus.OK, advertService.getAllTransactionTypes());
    }

    @GetMapping("/adverts/filters/status")
    public ResponseEntity<Object>getStatusTypes(){
        return ResponseHandler.generateResponse("Status list", HttpStatus.OK, advertService.getAllStatus());
    }

    @GetMapping("/adverts/filters/estatetype")
    public ResponseEntity<Object>getEstateTypes(){
        return ResponseHandler.generateResponse("Estate types", HttpStatus.OK, advertService.getAllTransactionTypes());
    }

    @GetMapping("/adverts/filters/heatingtype")
    public ResponseEntity<Object>getHeatingType(){
        return ResponseHandler.generateResponse("Heating types", HttpStatus.OK, advertService.getAllHeatingTypes());
    }
}
