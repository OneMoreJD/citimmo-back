package com.wcs.citimmo.service;

import com.wcs.citimmo.dto.RegisterDto;
import com.wcs.citimmo.mappers.RegisterMapper;
import com.wcs.citimmo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    RegisterMapper registerMapper;

    @Autowired
    ProfileService profileService;

    public RegisterDto registerUser(RegisterDto registerDto){
        if(!isAlreadyRegistered(registerDto.getEmail())){
            registerDto.setProfileDto(profileService.getUserProfileDto());
            userRepository.save(registerMapper.registerDtoToNewUser(registerDto));
        }
        return registerDto;
    }

    private boolean isAlreadyRegistered(String email){
        if(userRepository.findByEmail(email) != null){
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }
}
