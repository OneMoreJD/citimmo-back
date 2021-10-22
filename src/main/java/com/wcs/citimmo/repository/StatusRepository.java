package com.wcs.citimmo.repository;

import com.wcs.citimmo.entity.Status;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusRepository  extends JpaRepository<Status, Integer> {
}
