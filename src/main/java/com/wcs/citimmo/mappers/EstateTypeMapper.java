package com.wcs.citimmo.mappers;

import com.wcs.citimmo.model.EstateType;
import org.springframework.stereotype.Component;

@Component
public class EstateTypeMapper {
    public EstateType valueToEstateType(String value){
        return EstateType.valueOf(value);
    }
}
