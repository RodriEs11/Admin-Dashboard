package com.unla.proyectooo2.controllers.vistas;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.unla.proyectooo2.helpers.ViewRouteHelper;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("")
public class SessionController {

	@GetMapping("/login")
	public String login(Model model, @RequestParam(name = "error", required = false) String error,
			@RequestParam(name = "logout", required = false) String logout) {

		model.addAttribute("error", error);
		model.addAttribute("logout", logout);

		return  ViewRouteHelper.LOGIN;
	}

	@GetMapping("/logout")
	public String logout(Model model, HttpServletRequest request, HttpServletResponse response) throws IOException {

		try {
			request.logout();
		} catch (ServletException e) {
			e.printStackTrace();
		}

		return "redirect:/login?logout=true";

	}

}
