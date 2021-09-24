package com.wcs.citimmo.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;

import com.wcs.citimmo.dto.QuickSearchDto;
import com.wcs.citimmo.entity.Address;
import com.wcs.citimmo.entity.Advert;
import com.wcs.citimmo.entity.TransactionType;

@Service
public class AdvertService {
    
    private List<Advert> adverts = new ArrayList<Advert>();

    public List<Advert> findAdvertsByCriteria(QuickSearchDto dto) {
        adverts.add(new Advert(200000, TransactionType.buy, new Address("88 ter", "rue des cerisiers", 94000, "Creteil")));
        adverts.add(new Advert(250000, TransactionType.buy, new Address("23", "rue des rosiers", 94000, "Creteil")));
        adverts.add(new Advert(400000, TransactionType.buy, new Address("4 bis", "rue des cerisiers", 94300, "Vincennes")));
        adverts.add(new Advert(200000, TransactionType.buy, new Address("14", "rue des cerisiers", 94300, "Vincennes")));
        adverts.add(new Advert(1500, TransactionType.rent, new Address("54", "rue des pommiers", 94300, "Vincennes")));
        
        List<Advert> filteredList = new ArrayList<Advert>();
        Iterator locIterator = dto.getLocations().iterator();
        
        while (locIterator.hasNext()) {
            String location = locIterator.next().toString();
            List<Advert> filtered = new ArrayList<Advert>();
            filtered = adverts.stream()
                  .filter(a -> a.getTransactionType() == dto.getType())
                  .filter(a -> a.getPrice() <= dto.getBudget())
                  .filter(a -> a.getAddress().getCity().equals(location))
                  .collect(Collectors.toList());
            filteredList.addAll(filtered);
        }
        
        return filteredList;
    }

}
