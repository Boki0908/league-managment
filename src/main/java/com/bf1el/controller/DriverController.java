package com.bf1el.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


import com.bf1el.model.Driver;

import com.bf1el.service.DriverService;

@Controller
public class DriverController {
	
	private DriverService driverService;
	
	@Autowired
	public DriverController(DriverService driverService) {
		this.driverService = driverService;
	}
	
	@GetMapping("/drivers")
	//responsen entity je tip koji vracamo 
	public  String drivers(Model model){
		List<Driver> drivers = driverService.getAll();
		model.addAttribute("drivers", drivers);

	    return "drivers";
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<?>findById(@PathVariable("id")Long id){
		return new ResponseEntity(driverService.findById(id), HttpStatus.OK);
		
	}
	
	@PostMapping
	public ResponseEntity<?> add(@RequestBody Driver input) throws Exception {
		Driver driverDB = driverService.create(input);
		
		return new ResponseEntity(driverDB,HttpStatus.CREATED);
	}
	
	@GetMapping("/driver_standings")
	//responsen entity je tip koji vracamo 
	public  String driverStandings(Model model){
		List<Driver> drivers = driverService.getDriversByPoints();
		model.addAttribute("drivers", drivers);

	    return "driver_standings";
	}

}


