package com.wcs.citimmo.repository;

import com.wcs.citimmo.entity.Picture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PictureRepository extends JpaRepository<Picture, Integer> {
}
