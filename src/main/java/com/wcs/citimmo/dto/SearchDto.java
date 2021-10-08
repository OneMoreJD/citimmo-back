package com.wcs.citimmo.dto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.wcs.citimmo.model.EstateType;
import com.wcs.citimmo.model.TransactionType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SearchDto {

    private TransactionType type;
    private List<String> locations;
    private EstateType estateType;
    private List<Integer> rooms;
    private List<Integer> bedrooms;
    private int budgetMin;
    private int budgetMax;
    private int intSurfaceMin;
    private int intSurfaceMax;
    private int extSurfaceMin;
    private int extSurfaceMax;
    
    public SearchDto(String aType, String aLocations, EstateType aEstateType, List<Integer> aRooms, List<Integer> aBedrooms, int aBudgetMin, int aBudgetMax, int aIntSurfaceMin,
            int aIntSurfaceMax, int aExtSurfaceMin, int aExtSurfaceMax) {
        super();
        type = convertToTransactionType(aType);
        locations = convertToLocationsList(aLocations);
        estateType = aEstateType;
        rooms = aRooms;
        bedrooms = aBedrooms;
        budgetMin = aBudgetMin;
        budgetMax = aBudgetMax;
        intSurfaceMin = aIntSurfaceMin;
        intSurfaceMax = aIntSurfaceMax;
        extSurfaceMin = aExtSurfaceMin;
        extSurfaceMax = aExtSurfaceMax;
    }
    
    private List<String> convertToLocationsList(String locations) {
        return Arrays.stream(locations.split(",")).collect(Collectors.toList());
    }
    
    private TransactionType convertToTransactionType(String type) {
        try {
            TransactionType transactionType = TransactionType.valueOf(type);
            return transactionType;            
        } catch (IllegalArgumentException ex) {
            return TransactionType.buy;
        }
    }
}
