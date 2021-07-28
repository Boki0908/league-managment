package com.bf1el.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.bf1el.model.Driver;
import com.bf1el.model.Nationality;
import com.bf1el.model.Team;
import com.bf1el.model.User;
import com.bf1el.service.DriverService;
import com.bf1el.service.NationalityService;
import com.bf1el.service.TeamsService;

@Controller
public class DriverController {

	private DriverService driverService;

	private NationalityService nationalityService;

	private TeamsService teamsService;

	@Autowired
	public DriverController(DriverService driverService, NationalityService nationalityService,
			TeamsService teamsService) {
		this.driverService = driverService;
		this.nationalityService = nationalityService;
		this.teamsService = teamsService;
	}
	//ENDPOINT
	@GetMapping("/drivers")
	public String drivers(Model model) {
		List<Driver> drivers = driverService.getAll();
		model.addAttribute("drivers", drivers);
		return "drivers";
	}


	@GetMapping("/driver_standings")
	public String driverStandings(Model model) {
		List<Driver> drivers = driverService.getDriversByPoints();
		model.addAttribute("drivers", drivers);

		return "driver_standings";
	}


	@GetMapping("/admin/new_driver")
	public String newDriver(Model model) {
		Driver driver = new Driver();
		List<Nationality> nations = nationalityService.getAll();
		List<Team> teams = teamsService.getAll();
		model.addAttribute("driverForm", driver);
		model.addAttribute("nations", nations);
		model.addAttribute("teams", teams);

		return "new_driver";
	}

	@PostMapping("/admin/new_driver")
	public String newDriver(@ModelAttribute("nations") Nationality nationality,
			@ModelAttribute("driverForm") Driver driverForm, @ModelAttribute("teams") Team team) {
		driverService.importNewDriver(driverForm, nationality, team);
		return "redirect:/drivers";
	}

}
