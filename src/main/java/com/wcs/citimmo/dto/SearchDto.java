package com.wcs.citimmo.dto;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.wcs.citimmo.model.EstateType;
import com.wcs.citimmo.model.TransactionType;
import com.wcs.citimmo.util.Helpers;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SearchDto {

    private TransactionType type;
    private List<String> locations;
    private List<EstateType> estateTypes;
    private List<Integer> rooms;
    private List<Integer> bedrooms;
    private int budgetMin;
    private int budgetMax;
    private int intSurfaceMin;
    private int intSurfaceMax;
    private int extSurfaceMax;
    
    public SearchDto(String transactionType, String locations, Optional<String> estateType, Optional<String> rooms, Optional<String> bedrooms, Optional<String> budgetMin,
            Optional<String> budgetMax, Optional<String> intSurfaceMin, Optional<String> intSurfaceMax, Optional<String> extSurfaceMax) {
        
        super();
        
        this.type = convertToTransactionType(transactionType);
        this.locations = Helpers.convertStringToListOfStrings(locations);
        this.estateTypes = Helpers.convertStringToListOfStrings(Helpers.getValueOrNullOfOptional(estateType))
                             .stream()
                             .map(type -> convertToEstateType(type))
                             .collect(Collectors.toList());
        this.rooms = Helpers.convertStringToListOfIntegers(Helpers.getValueOrNullOfOptional(rooms));
        this.bedrooms = Helpers.convertStringToListOfIntegers(Helpers.getValueOrNullOfOptional(bedrooms));
        this.budgetMin = Helpers.getValueOrBoundOfOptional(budgetMin, 0);
        this.budgetMax = Helpers.getValueOrBoundOfOptional(budgetMax, Integer.MAX_VALUE);
        this.intSurfaceMin = Helpers.getValueOrBoundOfOptional(intSurfaceMin, 0);
        this.intSurfaceMax = Helpers.getValueOrBoundOfOptional(intSurfaceMax, Integer.MAX_VALUE);
        this.extSurfaceMax = Helpers.getValueOrBoundOfOptional(extSurfaceMax, 0);
    }

    private TransactionType convertToTransactionType(String type) {
        try {
            TransactionType transactionType = TransactionType.valueOf(type);
            return transactionType;
        } catch (IllegalArgumentException ex) {
            return TransactionType.buy;
        }
    }
    
    private EstateType convertToEstateType(String type) {
        try {
            for (EstateType es : EstateType.values()) {
                if (es.getName() == type) {
                    return es;
                }
            }
        } catch (IllegalArgumentException ex) {
            return EstateType.appartment;
        }
        return EstateType.appartment;
    }
}
