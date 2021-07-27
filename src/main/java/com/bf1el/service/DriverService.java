package com.bf1el.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bf1el.common.EntityNotFoundException;
import com.bf1el.model.Driver;
import com.bf1el.model.Nationality;
import com.bf1el.model.Team;
import com.bf1el.repository.DriverRepository;



@Service
public class DriverService {
	
	
	private DriverRepository driverRepository;
	
	@Autowired
	public DriverService(DriverRepository driverRepository) {
		this.driverRepository = driverRepository;
	}
	
	public List<Driver>getAll(){
		return driverRepository.findAll();
	}
	
	public List<Driver> getDriversByPoints(){
		return driverRepository.findDriversByStandings();
	}
	
	public Driver findById(Long id) {
		Optional<Driver> driver = driverRepository.findById(id);
		if(!driver.isPresent()) {
			throw new EntityNotFoundException("Driver with id:" + id + " doesn't exists."); 
		}
		return driver.get();
	}
	
	@Transactional
	public Driver create(Driver driver) {
		
		Driver drv = driverRepository.save(driver);
		return drv;
		
	}
	
	@Transactional
	public Driver importNewDriver(Driver driverForm, Nationality nat, Team team) {
		Driver drv = new Driver();
		drv.setDrvFirstName(driverForm.getDrvFirstName());
		drv.setDrvLastName(driverForm.getDrvLastName());
		drv.setDrvUsername(driverForm.getDrvUsername());
		drv.setDrvBirthDate(driverForm.getDrvBirthDate());
		drv.setDrvPoints(driverForm.getDrvPoints());
		drv.setDrvNumber(driverForm.getDrvNumber());
		drv.setDrvPodiums(driverForm.getDrvPodiums());
		drv.setDrvWins(driverForm.getDrvWins());
		drv.setTeam(team);
		drv.setNationality(nat);
		
		return driverRepository.save(drv);
	}
}
