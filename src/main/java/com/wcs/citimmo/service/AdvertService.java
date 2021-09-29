package com.wcs.citimmo.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wcs.citimmo.dto.QuickSearchDto;
import com.wcs.citimmo.entity.Address;
import com.wcs.citimmo.entity.Advert;
import com.wcs.citimmo.entity.TransactionType;
import com.wcs.citimmo.repository.AdvertRepository;

@Service
public class AdvertService {
    
    @Autowired
    AdvertRepository advertRepo;
    
    private List<Advert> adverts = new ArrayList<Advert>();

    public List<Advert> findAdvertsByCriteria(QuickSearchDto dto) {
        return advertRepo.quickSearch(dto.getType(), dto.getBudget(), dto.getLocations());
    }

}
