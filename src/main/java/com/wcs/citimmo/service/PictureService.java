package com.wcs.citimmo.service;

import com.wcs.citimmo.repository.PictureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PictureService {
    @Autowired
    PictureRepository pictureRepository;


}
