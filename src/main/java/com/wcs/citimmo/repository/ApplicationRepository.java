package com.wcs.citimmo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wcs.citimmo.entity.Application;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, Integer> {

}
