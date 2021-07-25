package com.bf1el.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AppController {

	@GetMapping("/")
    public String welcome(Model model) {
        return "home";
    }
	
	@GetMapping("/home")
    public String welcomeConvert(Model model) {
        return "redirect:/";
    }
	
	@GetMapping("/logout")
    public String logout(Model model) {
        return "redirect:/";
    }
	@GetMapping("/contact")
    public String contact(Model model) {
        return "contact";
    }
	@GetMapping("/rules")
    public String rules(Model model) {
        return "rules";
    }
	@GetMapping("/history")
    public String history(Model model) {
        return "history";
    }
}