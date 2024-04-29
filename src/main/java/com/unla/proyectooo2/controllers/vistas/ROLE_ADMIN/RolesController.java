package com.unla.proyectooo2.controllers.vistas.ROLE_ADMIN;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.unla.proyectooo2.helpers.ViewRouteHelper;

@Controller
@PreAuthorize("hasRole('ROLE_ADMIN')")
@RequestMapping("/roles")
public class RolesController {

	
	@GetMapping("")
	public String roles() {

		return ViewRouteHelper.ROLES;
	}

}
