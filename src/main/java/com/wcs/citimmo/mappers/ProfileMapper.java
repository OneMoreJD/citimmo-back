package com.wcs.citimmo.mappers;

import com.wcs.citimmo.dto.ProfileDto;
import com.wcs.citimmo.entity.Profile;
import org.springframework.stereotype.Component;

@Component
public class ProfileMapper {
    public ProfileDto getProfileDto(Profile profile){
         return new ProfileDto(profile.getId(), profile.getLabel());
    }

    public Profile getProfileEntity(ProfileDto profileDto){
        return new Profile(profileDto.getLabel());
    }
}
