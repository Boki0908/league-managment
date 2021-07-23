package com.bf1el.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.bf1el.dto.TeamCustom;
import com.bf1el.model.Team;


import com.bf1el.service.TeamsService;

@Controller
public class TeamsController {
	
	private TeamsService teamsService;
	
	@Autowired
	public TeamsController(TeamsService teamsService) {
		this.teamsService = teamsService;
	}
	
	@GetMapping("/teams")
	//responsen entity je tip koji vracamo 
	public  String teams(Model model){
		//List<Team> teams = teamsService.getAll();
		List<TeamCustom> teams = teamsService.getCustomTeams();
		model.addAttribute("teams", teams);
		//toDo mora da se napravi customMapping za novu klasu gde ce biti team i lista vozaca
	    return "teams";
	}
	
	
}


