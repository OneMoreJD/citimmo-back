package com.wcs.citimmo.dto;

import com.wcs.citimmo.entity.TransactionType;

public class QuickSearchDto {

    private TransactionType type;
    private String location;
    private int budget;
    
    public QuickSearchDto(TransactionType type, String location, int budget) {
        super();
        this.type = type;
        this.location = location;
        this.budget = budget;
    }

    public TransactionType getType() {
        return type;
    }

    public void setType(TransactionType aType) {
        type = aType;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String aLocation) {
        location = aLocation;
    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(int aBudget) {
        budget = aBudget;
    }
}
