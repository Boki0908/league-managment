package com.bf1el.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bf1el.common.EntityNotFoundException;
import com.bf1el.model.DriverTeam;
import com.bf1el.repository.DriverTeamRepository;

@Service
public class DriverTeamService {

	
	private DriverTeamRepository driverTeamRepository;
	
	@Autowired
	public DriverTeamService(DriverTeamRepository driverTeamRepository) {
		this.driverTeamRepository=driverTeamRepository;
	}
	
		public List<DriverTeam>getAll(){
			return driverTeamRepository.findAll();
		}
		public DriverTeam findById(Long id) {
			Optional<DriverTeam> driverTeam = driverTeamRepository.findById(id);
			if(!driverTeam.isPresent()) {
				throw new EntityNotFoundException("DriverTeam with id:" + id + " doesn't exists."); 
			}
			return driverTeam.get();
		}

		@Transactional
		public DriverTeam create(DriverTeam driverTeam) {
			
			
			DriverTeam drvTeam = driverTeamRepository.save(driverTeam);
			return drvTeam;
			
		}	
}
