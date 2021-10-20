package com.wcs.citimmo.dto;

import com.wcs.citimmo.entity.Picture;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class UpdateAdvertDto {
    private String title;
    private String description;
    private int price;
    private int rooms;
    private int bedrooms;
    private double indoorSurface;
    private double outdoorSurface;
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate constructionDate;
    private int parkingQuantity;
    private String conditionType;
    private String transactionType;
    private String estateType;
    private String heatingType;
    private AddressDto address;
    private List<Picture> pictures;
}
