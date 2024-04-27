package com.unla.proyectooo2.controllers.vistas.ROLE_ADMIN;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.unla.proyectooo2.entities.User;
import com.unla.proyectooo2.helpers.ViewRouteHelper;
import com.unla.proyectooo2.models.UserModel;
import com.unla.proyectooo2.services.implementation.UserService;

@Controller
@PreAuthorize("hasRole('ROLE_ADMIN')")
@RequestMapping("/usuarios")
public class UsuariosController {

	@Autowired
	@Qualifier("userService")
	private UserService userService;

	@GetMapping("")
	public ModelAndView usuarios() {

		ModelAndView vista = new ModelAndView(ViewRouteHelper.USUARIOS);
		List<User> users = userService.getAll();

		vista.addObject("users", users);

		return vista;
	}

	@GetMapping("/editar/{id}")
	public ModelAndView editarUsuario(@PathVariable("id") int id, UserModel userModel) {

		ModelAndView vista = new ModelAndView(ViewRouteHelper.EDITAR_USUARIOS);
		vista.addObject("userId", id);
		
		return vista;
	}
}
