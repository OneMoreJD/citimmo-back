package com.wcs.citimmo.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "advert")
public class Advert {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String description;
    private int price;
    @Enumerated(EnumType.STRING)
    private TransactionType transactionType;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;

    public int getId() {
        return id;
    }

    public void setId(int aId) {
        id = aId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String aTitle) {
        title = aTitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String aDescription) {
        description = aDescription;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int aPrice) {
        price = aPrice;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address aAddress) {
        address = aAddress;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType aTransactionType) {
        transactionType = aTransactionType;
    }

    public Advert() {
        super();
    }

    public Advert(int aPrice, TransactionType aTransactionType, Address aAddress) {
        super();
        price = aPrice;
        transactionType = aTransactionType;
        address = aAddress;
    }
    
}
