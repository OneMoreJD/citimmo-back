package com.wcs.citimmo.model;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum HeatingType {
    electric("electric","Electrique"),
    gas("gas","Gaz"),
    oil("oil","Fuel");

    private final String name;
    private final String frLabel;

    private HeatingType(String name, String frLabel) {
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
