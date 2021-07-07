package com.bf1el.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.bf1el.common.CustomRepository;
import com.bf1el.model.DriverTeam;

@Repository
public interface DriverTeamRepository extends CustomRepository<DriverTeam, Long> {


	Optional<DriverTeam> findById(Long drtId);

	DriverTeam save(DriverTeam driverTeam);

	List<DriverTeam> findAll();
}
