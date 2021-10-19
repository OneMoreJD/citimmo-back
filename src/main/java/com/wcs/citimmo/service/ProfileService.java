package com.wcs.citimmo.service;

import com.wcs.citimmo.dto.ProfileDto;
import com.wcs.citimmo.entity.Profile;
import com.wcs.citimmo.mappers.ProfileMapper;
import com.wcs.citimmo.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfileService {
    @Autowired
    ProfileRepository profileRepository;

    @Autowired
    ProfileMapper profileMapper;

    public ProfileDto getProfileDto(){
        return profileMapper.getProfileDto(profileRepository.findProfileByLabel("USER"));
    }

    public Profile getProfileLabelledUser(){
        return profileRepository.findProfileByLabel("USER");
    }

}
