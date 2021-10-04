package com.wcs.citimmo.dto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.wcs.citimmo.model.TransactionType;

public class QuickSearchDto {

    private TransactionType type;
    private List<String> locations;
    private int budget;

    public QuickSearchDto(String type, String locations, Optional<Integer> budget) {
        super();
        
        this.type = convertToTransactionType(type);
        this.locations = convertToLocationsList(locations);
        if (budget.isPresent()) {
            this.budget = budget.get();
        } else {
            this.budget = Integer.MAX_VALUE;
        }
    }

    private List<String> convertToLocationsList(String locations) {
        return Arrays.stream(locations.split(",")).collect(Collectors.toList());
    }

    public QuickSearchDto() {
        super();
    }

    private TransactionType convertToTransactionType(String type) {
        try {
            TransactionType transactionType = TransactionType.valueOf(type);
            return transactionType;            
        } catch (IllegalArgumentException ex) {
            return TransactionType.buy;
        }
    }

    public TransactionType getType() {
        return type;
    }

    public void setType(TransactionType aType) {
        type = aType;
    }

    public List<String> getLocations() {
        return locations;
    }

    public void setLocations(List<String> aLocations) {
        locations = aLocations;
    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(int aBudget) {
        budget = aBudget;
    }
}
