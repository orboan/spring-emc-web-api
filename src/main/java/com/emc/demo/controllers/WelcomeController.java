package com.emc.demo.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

//Semblant al RestController
//Però la difència és que gestiona peticions
//des de HTML o JSP
//No poso cap RequestMapping pq vull accedir a la URL sense path addicional
@Controller
public class WelcomeController {
	
	//inject via application.properties
	@Value("$welcome.message")
	private String message;
	
	@GetMapping("/")
	public String mainWithParam() {
		return "index"; //view
	}

	//sempre que vulgui comunicar des del controlador
	//a la vista ho faré amb l'objecte de tipus Model
	// /hello?name=kotlin
	@GetMapping("/hello")
	public String mainWithParam(
			@RequestParam(name = "name", required = false, defaultValue = "") 
			String name, Model model) {
		if(name.equals("")) {
			model.addAttribute("message", message);
		}else {
			model.addAttribute("message", name);
		}
		return "welcome"; //view
	}
}
