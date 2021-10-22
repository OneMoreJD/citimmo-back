package com.wcs.citimmo.model;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum EstateType {
    house("house", "Maison"),
    appartment("appartment", "Appartement"),
    garage("garage", "Garage"),
    other("other", "Autre");
    
    private final String name;
    private final String frLabel;

    private EstateType(String name, String frLabel) {
        this.name = name;
        this.frLabel = frLabel;
    }

    public String getName() {
        return name;
    }

    public String getFrLabel() {
        return frLabel;
    }
}
