package com.bf1el.repository;

import java.util.List;
import java.util.Optional;

import com.bf1el.common.CustomRepository;
import com.bf1el.model.Driver;

public interface DriverRepository extends CustomRepository<Driver, Long> {

	Driver findOneByDrvUsername(String name);

	Optional<Driver> findById(Long id);

	Driver save(Driver user);

	List<Driver> findAll();
}
