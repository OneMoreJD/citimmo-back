package com.wcs.citimmo.mappers;

import com.wcs.citimmo.dto.CreateAdvertDto;
import com.wcs.citimmo.entity.Advert;
import com.wcs.citimmo.model.TransactionType;
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

    public Advert advertDtoToAdvert(CreateAdvertDto createAdvertDto){
        Advert advert = new Advert(
                createAdvertDto.getTitle(),
                createAdvertDto.getDescription(),
                createAdvertDto.getPrice(),
                createAdvertDto.getRooms(),
                createAdvertDto.getBedrooms(),
                createAdvertDto.getIndoorSurface(),
                createAdvertDto.getOutdoorSurface(),
                createAdvertDto.getParkingQuantity(),
                createAdvertDto.getConstructionDate(),
                LocalDate.now()
        );
        advert.setTransactionType(transactionTypeMapper.valueToTransactionType(createAdvertDto.getTransactionType()));
        advert.setEstateType(estateTypeMapper.valueToEstateType(createAdvertDto.getEstateType()));
        advert.setConditionType(conditionTypeMapper.valueToConditionType(createAdvertDto.getConditionType()));
        advert.setHeatingType(heatingTypeMapper.valueToHeatingType(createAdvertDto.getHeatingType()));
        return advert;
    }
}
