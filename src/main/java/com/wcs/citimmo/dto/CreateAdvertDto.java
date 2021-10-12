package com.wcs.citimmo.dto;

import com.wcs.citimmo.entity.Status;
import com.wcs.citimmo.model.ConditionType;
import com.wcs.citimmo.model.EstateType;
import com.wcs.citimmo.model.HeatingType;
import com.wcs.citimmo.model.TransactionType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;


import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class CreateAdvertDto {
    private String title;
    private String description;
    private int price;
    private int rooms;
    private int bedrooms;
    private double surfaceIn;
    private double surfaceOut;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate publicationDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate contructionDate;
    private int nbCarInGarage;
    private ConditionType conditionType;
    private Status status;
    private TransactionType transactionType;
    private EstateType estateType;
    private HeatingType heatingType;

}
