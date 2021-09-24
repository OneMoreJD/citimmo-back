package com.wcs.citimmo.mappers;

import com.wcs.citimmo.dto.ProfileDto;
import com.wcs.citimmo.entity.Profile;
import org.springframework.stereotype.Component;

@Component
public class ProfileMapper {
    public ProfileDto getUserProfileDto(Profile userProfile){
         return new ProfileDto(userProfile.getId(), userProfile.getLabel());
    }

    public Profile getProfileEntity(ProfileDto profileDto){
        return new Profile(profileDto.getId(), profileDto.getLabel());
    }
}
