package com.wcs.citimmo.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.wcs.citimmo.model.ConditionType;
import com.wcs.citimmo.model.EstateType;
import com.wcs.citimmo.model.HeatingType;
import com.wcs.citimmo.model.TransactionType;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "advert")
@NoArgsConstructor
@Getter
@Setter
public class Advert {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private String title;
    private String description;
    private int price;
    private int rooms;
    private int bedrooms;
    private double surfaceIn;
    private double surfaceOut;
    private LocalDate publicationDate;
    private LocalDate contructionDate;
    private int nbCarInGarage;
    private ConditionType conditionType;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "status_id", referencedColumnName = "id")
    private Status status;
    
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TransactionType transactionType;
    
    @Enumerated(EnumType.STRING)
    private EstateType estateType;
    
    @Enumerated(EnumType.STRING)
    private HeatingType heatingType;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;
        
    @OneToMany(cascade = CascadeType.ALL)
    private List<Picture> pictures;    
}
