package com.wcs.citimmo.mappers;

import com.wcs.citimmo.dto.UpdateAdvertDto;
import com.wcs.citimmo.entity.Advert;

import com.wcs.citimmo.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;


@Component
public class UpdateAdvertMapper {

    @Autowired
    TransactionTypeMapper transactionTypeMapper;
    @Autowired
    EstateTypeMapper estateTypeMapper;
    @Autowired
    ConditionTypeMapper conditionTypeMapper;
    @Autowired
    HeatingTypeMapper heatingTypeMapper;
    @Autowired
    AddressMapper addressMapper;
    @Autowired
    StatusService statusService;

    public Advert advertDtoToAdvert(UpdateAdvertDto updateAdvertDto){
        Advert advert = new Advert();
        advert.setTitle(updateAdvertDto.getTitle());
        advert.setDescription(updateAdvertDto.getDescription());
        advert.setPrice(updateAdvertDto.getPrice());
        advert.setRooms(updateAdvertDto.getRooms());
        advert.setBedrooms(updateAdvertDto.getBedrooms());
        advert.setSurfaceIn(updateAdvertDto.getIndoorSurface());
        advert.setSurfaceOut(updateAdvertDto.getOutdoorSurface());
        advert.setNbCarInGarage(updateAdvertDto.getParkingQuantity());
        advert.setContructionDate(updateAdvertDto.getConstructionDate());
        advert.setPublicationDate(LocalDate.now());
        advert.setTransactionType(transactionTypeMapper.valueToTransactionType(updateAdvertDto.getTransactionType()));
        advert.setEstateType(estateTypeMapper.valueToEstateType(updateAdvertDto.getEstateType()));
        advert.setConditionType(conditionTypeMapper.valueToConditionType(updateAdvertDto.getConditionType()));
        advert.setHeatingType(heatingTypeMapper.valueToHeatingType(updateAdvertDto.getHeatingType()));
        advert.setAddress(addressMapper.addressDtoToAddress(updateAdvertDto.getAddress()));
        advert.setPictures(updateAdvertDto.getPictures());
        advert.setStatus(statusService.findStatus(1));
        return advert;
    }
}
