package com.unla.proyectooo2.controllers.vistas;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.unla.proyectooo2.helpers.ViewRouteHelper;



@Controller
@RequestMapping("/")
public class IndexController {
	
	@GetMapping("")
	public String index() {
		return "redirect:/home";
	}
	
	@GetMapping("/home")
	public String home(Model model) {
	
		return ViewRouteHelper.INDEX;
	}
}
