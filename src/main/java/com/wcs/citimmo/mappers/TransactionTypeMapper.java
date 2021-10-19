package com.wcs.citimmo.mappers;

import com.wcs.citimmo.model.TransactionType;
import org.springframework.stereotype.Component;

@Component
public class TransactionTypeMapper {

    public TransactionType valueToTransactionType(String value){
        return TransactionType.valueOf(value);
    }
}
