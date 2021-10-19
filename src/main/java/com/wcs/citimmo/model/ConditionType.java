package com.wcs.citimmo.model;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ConditionType {
    fresh("fresh", "Neuf"),
    recent("recent","Récent"),
    toRefresh("toRefresh","travaux à prévoir"),
    old("old","ancien");


    private final String name;
    private final String frLabel;

    private ConditionType(String name, String frLabel) {
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
