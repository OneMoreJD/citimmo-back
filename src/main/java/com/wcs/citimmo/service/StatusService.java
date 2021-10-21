package com.wcs.citimmo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wcs.citimmo.entity.Status;
import com.wcs.citimmo.repository.StatusRepository;

@Service
public class StatusService {

    @Autowired
    StatusRepository statusRepo;
    
    public Status findStatus(int id) {
        return statusRepo.findById(id).get();
    }
}
