package com.wcs.citimmo.model;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum TransactionType {
    buy("buy","Achat"),
    rent("rent","Location"),
    life("life","Viager");

    private final String name;
    private final String frLabel;

    private TransactionType(String name, String frLabel) {
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
