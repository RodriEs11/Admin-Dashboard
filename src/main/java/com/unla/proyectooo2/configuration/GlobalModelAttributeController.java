package com.unla.proyectooo2.configuration;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
public class GlobalModelAttributeController {

	// OBTIENE EL NOMBRE DE USUARIO AUTENTICADO, PARA AGREGARLO AL MODEL Y MOSTRARLO
	// DESDE TODAS LAS VISTAS
	@ModelAttribute
	public void AddUserToModel(Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		if (auth != null && auth.isAuthenticated() && auth.getPrincipal() instanceof UserDetails) {
			UserDetails userDetails = (UserDetails) auth.getPrincipal();

			String username = userDetails.getUsername();

			String userAdminRole = auth.getAuthorities().stream().map(authorization -> authorization.getAuthority())
					.findFirst().orElse("ROLE_ADMIN");

			model.addAttribute("currentUser", username);
			model.addAttribute("userAdminRole", userAdminRole);
		}
	}
}
