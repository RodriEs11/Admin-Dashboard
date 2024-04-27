package com.unla.proyectooo2.controllers.vistas;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.unla.proyectooo2.helpers.ViewRouteHelper;


@Controller
@RequestMapping("/perfiles")
public class PerfilesController {
	
	@GetMapping("")
	public String home() {
	
		return ViewRouteHelper.PERFILES;
	}
	
}
