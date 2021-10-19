package com.wcs.citimmo.controller;

import java.util.List;
import java.util.Optional;

import com.wcs.citimmo.dto.CreateAdvertDto;
import com.wcs.citimmo.util.ResponseHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.wcs.citimmo.dto.QuickSearchDto;
import com.wcs.citimmo.dto.SearchDto;
import com.wcs.citimmo.entity.Advert;
import com.wcs.citimmo.service.AdvertService;

@RestController
@CrossOrigin("*")
public class AdvertController {

    @Autowired
    AdvertService advertService;

    @GetMapping(value = "/adverts/quicksearch")
    public List<Advert> quickSearch(
            @RequestParam String transaction,
            @RequestParam String locations,
            @RequestParam Optional<Integer> budget) {
        QuickSearchDto dto = new QuickSearchDto(transaction, locations, budget);
        return advertService.findAdvertsByCriteria(dto);
    }

    @GetMapping(value = "/adverts/search")
    public List<Advert> search(
            @RequestParam String transactionType,
            @RequestParam String locations,
            @RequestParam Optional<String> estateType,
            @RequestParam Optional<String> rooms,
            @RequestParam Optional<String> bedrooms,
            @RequestParam Optional<String> intSurfaceMin,
            @RequestParam Optional<String> intSurfaceMax,
            @RequestParam Optional<String> extSurfaceMax,
            @RequestParam Optional<String> budgetMin,
            @RequestParam Optional<String> budgetMax) {

        SearchDto dto = new SearchDto(
                transactionType,
                locations,
                estateType,
                rooms,
                bedrooms,
                budgetMin,
                budgetMax,
                intSurfaceMin,
                intSurfaceMax,
                extSurfaceMax);
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
    public ResponseEntity<Object> getStatusTypes(){
        return ResponseHandler.generateResponse("Status list", HttpStatus.OK, advertService.getAllStatus());
    }

    @GetMapping("/adverts/filters/estatetype")
    public ResponseEntity<Object> getEstateTypes(){
        return ResponseHandler.generateResponse("Estate types", HttpStatus.OK, advertService.getAllEstateTypes());
    }

    @GetMapping("/adverts/filters/heatingtype")
    public ResponseEntity<Object> getHeatingType(){
        return ResponseHandler.generateResponse("Heating types", HttpStatus.OK, advertService.getAllHeatingTypes());
    }

    @PostMapping(value="/adverts/create", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Object> createAdvert(@RequestBody CreateAdvertDto createAdvertDto){
        if(advertService.createAdvert(createAdvertDto)) {
            return ResponseHandler.generateResponse("Creation Done", HttpStatus.OK, "Advert Successfully created");
        } else {
            return ResponseHandler.generateResponse("Creation Failed", HttpStatus.INTERNAL_SERVER_ERROR, "Advert Creation Failed");
        }
    }
}
