package com.wcs.citimmo.mappers;

import com.wcs.citimmo.model.HeatingType;
import org.springframework.stereotype.Component;

@Component
public class HeatingTypeMapper {
    public HeatingType valueToHeatingType(String value){
        return HeatingType.valueOf(value);
    }
}
