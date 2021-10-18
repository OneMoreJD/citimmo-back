package com.wcs.citimmo.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wcs.citimmo.dto.QuickSearchDto;
import com.wcs.citimmo.dto.SearchDto;
import com.wcs.citimmo.entity.Advert;
import com.wcs.citimmo.repository.AdvertRepository;

@Service
public class AdvertService {
    
    @Autowired
    AdvertRepository advertRepo;
    
    private static final int ROOMS_LIMIT = 5;
    private static final int BEDROOMS_LIMIT = 4;
    
    public List<Advert> findAdvertsByCriteria(QuickSearchDto dto) {
        return advertRepo.quickSearch(dto.getType(), dto.getBudget(), dto.getLocations());
    }
    
    public List<Advert> findAdvertsByCriteria(SearchDto dto) {
        Stream<Advert> advertsStream = advertRepo.quickSearch(dto.getType(), dto.getBudgetMax(), dto.getLocations()).stream();
        
        if (dto.getBudgetMin() > 0) {
            advertsStream = advertsStream.filter(a -> a.getPrice() >= dto.getBudgetMin());
        }

        if (dto.getIntSurfaceMin() > 0) {
            advertsStream = advertsStream.filter(a -> a.getSurfaceIn() >= dto.getIntSurfaceMin());
        }
        
        if (dto.getIntSurfaceMax() < Integer.MAX_VALUE) {
            advertsStream = advertsStream.filter(a -> a.getSurfaceIn() <= dto.getIntSurfaceMax());
        }
        
        if (dto.getExtSurfaceMax() > 0) {
            advertsStream = advertsStream.filter(a -> a.getSurfaceOut() <= dto.getExtSurfaceMax());
        }
        
        if (!dto.getEstateTypes().isEmpty()) {
            advertsStream = advertsStream.filter(a -> dto.getEstateTypes().contains(a.getEstateType()));
        }
        
        if (!dto.getRooms().isEmpty()) {
            advertsStream = advertsStream.filter(a -> dto.getRooms().contains(a.getRooms()));
            if (dto.getRooms().contains(ROOMS_LIMIT)) {
                advertsStream.filter(a -> a.getRooms() >= ROOMS_LIMIT);
            }
        }

        if (!dto.getBedrooms().isEmpty()) {
            advertsStream = advertsStream.filter(a -> dto.getBedrooms().contains(a.getBedrooms()));
            if (dto.getBedrooms().contains(BEDROOMS_LIMIT)) {
                advertsStream.filter(a -> a.getBedrooms() >= BEDROOMS_LIMIT);
            }
        }
        
        return advertsStream.collect(Collectors.toList());
    }

}
