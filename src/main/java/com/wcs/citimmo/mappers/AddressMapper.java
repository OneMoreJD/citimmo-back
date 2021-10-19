package com.wcs.citimmo.mappers;

import com.wcs.citimmo.dto.AddressDto;
import com.wcs.citimmo.entity.Address;
import org.springframework.stereotype.Component;

@Component
public class AddressMapper {

    public Address addressDtoToAddress(AddressDto addressDto){
        Address address = new Address();
        address.setNum(addressDto.getAtNumber());
        address.setCity(addressDto.getCity());
        address.setStreet(addressDto.getStreet());
        address.setZipCode(Integer.parseInt(addressDto.getZipcode()));
        return address;
    }
}
