package com.unla.proyectooo2.controllers.vistas.ROLE_ADMIN;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.unla.proyectooo2.helpers.ViewRouteHelper;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("")
	public String admin() {
		
		return ViewRouteHelper.ADMIN;
	}

}
