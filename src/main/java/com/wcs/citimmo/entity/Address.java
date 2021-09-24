package com.wcs.citimmo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "address")
public class Address {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String num;
    private String street;
    private int zipCode;
    private String city;
    
    public Address() {
        super();
    }
    
    
    public Address(String aNum, String aStreet, int aZipCode, String aCity) {
        super();
        num = aNum;
        street = aStreet;
        zipCode = aZipCode;
        city = aCity;
    }


    public int getId() {
        return id;
    }
    public void setId(int aId) {
        id = aId;
    }
    public String getNum() {
        return num;
    }
    public void setNum(String aNum) {
        num = aNum;
    }
    public String getStreet() {
        return street;
    }
    public void setStreet(String aStreet) {
        street = aStreet;
    }
    public int getZipCode() {
        return zipCode;
    }
    public void setZipCode(int aZipCode) {
        zipCode = aZipCode;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String aCity) {
        city = aCity;
    }
}
