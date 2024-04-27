package com.unla.proyectooo2.controllers.vistas;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.unla.proyectooo2.converters.UserRoleConverter;
import com.unla.proyectooo2.helpers.ViewRouteHelper;
import com.unla.proyectooo2.models.UserModel;
import com.unla.proyectooo2.models.UserRoleModel;
import com.unla.proyectooo2.services.IUserRoleService;
import com.unla.proyectooo2.services.IUserService;

@Controller
public class RegistrarUsuarioController {

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	@Qualifier("userService")
	private IUserService userService;

	@Autowired
	@Qualifier("userRoleService")
	private IUserRoleService userRoleService;

	@Autowired
	@Qualifier("userRoleConverter")
	private UserRoleConverter userRoleConverter;

	@GetMapping("/registrar")
	public ModelAndView registrar(Model model, @RequestParam(name = "success", required = false) String success,
			@RequestParam(name = "error", required = false) String error) {

		ModelAndView modelView = new ModelAndView(ViewRouteHelper.REGISTRAR);

		modelView.addObject("user", new UserModel());

		model.addAttribute("success", success);
		model.addAttribute("error", error);
		return modelView;
	}

	@PostMapping("/registrar")
	public RedirectView registrar(@ModelAttribute("user") UserModel userModel) {
	
		String encodedPassword = passwordEncoder.encode(userModel.getPassword());
		userModel.setPassword(encodedPassword);
		userModel.setEnabled(true); // POR DEFAULT, EL USUARIO SE REGISTRA COMO ACTIVO
		UserRoleModel roleModel = userRoleConverter.entityToModel(userRoleService.getByRole("ROLE_USER"));
		userModel.getRoles().add(roleModel);

		userService.insertOrUpdate(userModel);

		return new RedirectView("/registrar?success=true");
	}

	@GetMapping("/rol/agregar")
	public ModelAndView agregarRol(Model model, @RequestParam(name = "success", required = false) String success,
			@RequestParam(name = "error", required = false) String error) {

		ModelAndView modelView = new ModelAndView(ViewRouteHelper.AGREGAR_ROL);

		modelView.addObject("userRole", new UserRoleModel());

		model.addAttribute("success", success);
		model.addAttribute("error", error);
		return modelView;
	}

	@PostMapping("/rol/agregar")
	public RedirectView agregarRol(@ModelAttribute("userRole") UserRoleModel userRoleModel) {

		userRoleService.insertOrUpdate(userRoleModel);

		return new RedirectView("/rol/agregar?success=true");
	}
}
