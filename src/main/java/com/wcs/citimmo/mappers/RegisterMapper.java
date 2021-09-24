package com.wcs.citimmo.mappers;

import com.wcs.citimmo.dto.RegisterDto;
import com.wcs.citimmo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Base64;

@Component
public class RegisterMapper {

    @Autowired
    ProfileMapper profileMapper;

    public User registerDtoToNewUser(RegisterDto registerDto){
        return new User(registerDto.getFirstname(), registerDto.getLastname(), registerDto.getEmail(), registerDto.getPhone(), new String(Base64.getDecoder().decode(registerDto.getPassword())), profileMapper.getProfileEntity(registerDto.getProfileDto()));
    }
}
