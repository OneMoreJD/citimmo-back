package com.wcs.citimmo.mappers;

import com.wcs.citimmo.model.ConditionType;
import org.springframework.stereotype.Component;

@Component
public class ConditionTypeMapper {
    public ConditionType valueToConditionType(String value){
        return ConditionType.valueOf(value);
    }
}
