package com.wcs.citimmo.mappers;

import com.wcs.citimmo.dto.CreateAdvertDto;
import com.wcs.citimmo.entity.Address;
import com.wcs.citimmo.entity.Advert;
import com.wcs.citimmo.service.StatusService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class CreateAdvertMapper {

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

    public Advert advertDtoToAdvert(CreateAdvertDto createAdvertDto){
        Advert advert = new Advert();
        advert.setTitle(createAdvertDto.getTitle());
        advert.setDescription(createAdvertDto.getDescription());
        advert.setPrice(createAdvertDto.getPrice());
        advert.setRooms(createAdvertDto.getRooms());
        advert.setBedrooms(createAdvertDto.getBedrooms());
        advert.setSurfaceIn(createAdvertDto.getIndoorSurface());
        advert.setSurfaceOut(createAdvertDto.getOutdoorSurface());
        advert.setNbCarInGarage(createAdvertDto.getParkingQuantity());
        advert.setContructionDate(createAdvertDto.getConstructionDate());
        advert.setPublicationDate(LocalDate.now());
        advert.setTransactionType(transactionTypeMapper.valueToTransactionType(createAdvertDto.getTransactionType()));
        advert.setEstateType(estateTypeMapper.valueToEstateType(createAdvertDto.getEstateType()));
        advert.setConditionType(conditionTypeMapper.valueToConditionType(createAdvertDto.getConditionType()));
        advert.setHeatingType(heatingTypeMapper.valueToHeatingType(createAdvertDto.getHeatingType()));
        advert.setAddress(addressMapper.addressDtoToAddress(createAdvertDto.getAddress()));
        advert.setStatus(statusService.findStatus(1));
        return advert;
    }
}
