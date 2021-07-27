package com.bf1el.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.bf1el.model.Contact;
import com.bf1el.service.MailService;

@Controller
public class ContactController {
	
	@Autowired
	public MailService mailService;

	@GetMapping("/contact")
	public String contact(ModelMap modelMap) {
		modelMap.put("contact", new Contact());
		return "contact";
	}

	@PostMapping("/send")
	public String send(@ModelAttribute("contact") Contact contact, ModelMap modelMap) {
		try {
		String contentHeader= "Name:" + contact.getName(); 
		String content = contentHeader + "<br>" + contact.getContent();
		mailService.sendEmail("bojanobradovic@gmail.com", contact.getEmail(), contact.getSubject(), content);
		modelMap.put("msg", "Done");
		} catch (Exception e) {
		modelMap.put("msg", e.getMessage());
		}
		return "redirect:/";
	}
}