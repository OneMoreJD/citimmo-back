package com.wcs.citimmo.dto;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import com.wcs.citimmo.entity.TransactionType;

public class QuickSearchDto {

    private TransactionType type;
    private Set locations;
    private int budget;

    public QuickSearchDto(String type, String locations, Optional<Integer> budget) {
        super();
        
        this.type = convertToTransactionType(type);
        this.locations = convertToLocationsSet(locations);
        if (budget.isPresent()) {
            this.budget = budget.get();
        } else {
            this.budget = Integer.MAX_VALUE;
        }
    }

    private Set convertToLocationsSet(String locations) {
        Set<String> locs = new HashSet<String>();
        locs = Arrays.stream(locations.split(",")).collect(Collectors.toSet());
        return locs;
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

    public Set getLocations() {
        return locations;
    }

    public void setLocations(Set aLocations) {
        locations = aLocations;
    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(int aBudget) {
        budget = aBudget;
    }
}
