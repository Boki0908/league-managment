package com.bf1el.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.bf1el.service.UserService;


@Controller
public class AppController {
	
	private UserService userService;
	
	@Autowired
	public AppController(UserService userService) {
		this.userService=userService;
	}
	
	@GetMapping("/")
    public String welcome(Model model) {
		Boolean hasRole = this.userService.userHasRole(this.userService.getLoggedRoles());
		Boolean hasAdminRole = false;
		if(userService.getLoggedInUserRole() != null) {
    		if (userService.getLoggedInUserRole().equals("ADMIN")) {
    			hasAdminRole = true;
    			}
    	}
		model.addAttribute("hasRole", hasRole);
		model.addAttribute("hasAdminRole", hasAdminRole);
		return "home";
    }
	
	@GetMapping("/home")
    public String welcomeConvert(Model model) {
        return "redirect:/";
    }
	
//	@GetMapping("/logout")
//    public String logout(Model model) {
//        return "redirect:/";
//    }
	
	@GetMapping("/rules")
    public String rules(Model model) {
        return "rules";
    }
	@GetMapping("/history")
    public String history(Model model) {
        return "history";
    }
}