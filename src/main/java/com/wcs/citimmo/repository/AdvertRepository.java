package com.wcs.citimmo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.wcs.citimmo.entity.Advert;
import com.wcs.citimmo.model.TransactionType;

@Repository
public interface AdvertRepository extends JpaRepository<Advert, Integer> {

    @Query("SELECT adv FROM Advert adv JOIN adv.address add"
            + " WHERE adv.transactionType = :type"
            + " AND adv.price <= :maxprice"
            + " AND add.city IN (:locations)")
    List<Advert> quickSearch(@Param("type") TransactionType transactionType, @Param("maxprice") int price, @Param("locations") List<String> locations);

}
