package com.wcs.citimmo.dto;

public class ProfileDto {
    public int id;
    public String label;

    public ProfileDto(int id, String label) {
        this.id = id;
        this.label = label;
    }

    public ProfileDto(String label) {
        this.label = label;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
