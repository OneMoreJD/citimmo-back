package com.wcs.citimmo.repository;

import com.wcs.citimmo.entity.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<Profile, Integer> {
    Profile findProfileByLabel(String label);
}
