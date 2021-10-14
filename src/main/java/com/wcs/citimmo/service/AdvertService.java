package com.wcs.citimmo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.wcs.citimmo.dto.CreateAdvertDto;
import com.wcs.citimmo.mappers.CreateAdvertMapper;
import com.wcs.citimmo.model.ConditionType;
import com.wcs.citimmo.model.EstateType;
import com.wcs.citimmo.model.HeatingType;
import com.wcs.citimmo.repository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wcs.citimmo.dto.QuickSearchDto;
import com.wcs.citimmo.entity.Address;
import com.wcs.citimmo.entity.Advert;
import com.wcs.citimmo.model.TransactionType;
import com.wcs.citimmo.repository.AdvertRepository;

@Service
public class AdvertService {
    
    @Autowired
    AdvertRepository advertRepo;

    @Autowired
    CreateAdvertMapper createAdvertMapper;

    @Autowired
    StatusRepository statusRepo;

    private List<Advert> adverts = new ArrayList<Advert>();

    public List<Advert> findAdvertsByCriteria(QuickSearchDto dto) {
        return advertRepo.quickSearch(dto.getType(), dto.getBudget(), dto.getLocations());
    }

    public Boolean createAdvert(CreateAdvertDto createAdvertDto){
        try {
            advertRepo.save(createAdvertMapper.advertDtoToAdvert(createAdvertDto));
        } catch (Exception e){
            System.out.println(e);
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    public List<String> getAllTransactionTypes(){
        return Stream.of(TransactionType.values())
                .map(TransactionType::name)
                .collect(Collectors.toList());
    }

    public List<String> getAllEstateTypes(){
        return Stream.of(EstateType.values())
                .map(EstateType::name)
                .collect(Collectors.toList());
    }

    public List<String> getAllConditionTypes(){
        return Stream.of(ConditionType.values())
                .map(ConditionType::name)
                .collect(Collectors.toList());
    }

    public List<String> getAllStatus(){
        return Stream.of(statusRepo.findAll())
                .map(e -> e.toString())
                .collect(Collectors.toList());
    }

    public List<String> getAllHeatingTypes(){
        return Stream.of(HeatingType.values())
                .map(HeatingType::name)
                .collect(Collectors.toList());
    }

}
