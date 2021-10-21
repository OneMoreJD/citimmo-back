package com.wcs.citimmo.service;

import javax.persistence.criteria.Predicate.BooleanOperator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wcs.citimmo.dto.CreateApplicationDto;
import com.wcs.citimmo.entity.Advert;
import com.wcs.citimmo.entity.Application;
import com.wcs.citimmo.repository.ApplicationRepository;

@Service
public class ApplicationService {

    @Autowired
    ApplicationRepository applyRepo;
    
    @Autowired
    AdvertService advertService;
    
    @Autowired
    UserService userService;
    
    @Autowired
    StatusService statusService;
    
    public Boolean createApplication(CreateApplicationDto dto) {
        Advert currentAdvert = advertService.findAdvertById(dto.getAdvertId()).get();
        try {            
            Application appli = new Application();
            appli.setAdvert(currentAdvert);
            appli.setUser(userService.loadUser(dto.getUsername()));
            appli.setAccepted(false);
            applyRepo.save(appli);
        } catch (Exception ex) {
            return Boolean.FALSE;
        }
        currentAdvert.setStatus(statusService.findStatus(2));
        advertService.updateStatus(currentAdvert);
        return Boolean.TRUE;
    }
}
