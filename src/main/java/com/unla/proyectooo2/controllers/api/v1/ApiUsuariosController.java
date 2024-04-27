package com.unla.proyectooo2.controllers.api.v1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.unla.proyectooo2.entities.ErrorResponse;
import com.unla.proyectooo2.entities.User;
import com.unla.proyectooo2.repositories.IUserRepository;
import com.unla.proyectooo2.services.implementation.UserService;

@RestController
@RequestMapping("/api/v1/usuarios")
public class ApiUsuariosController {

	@Autowired
	@Qualifier("userRepository")
	private IUserRepository userRepository;

	@Autowired
	@Qualifier("userService")
	private UserService userService;

	@GetMapping("")
	public ResponseEntity<List<User>> getAllUsuarios() {

		List<User> usuarios = userRepository.findAll();

		return ResponseEntity.ok(usuarios);
	}

	//SE OBTIENEN LOS DETALLES DEL USUARIO SEGUN ID
	// Ejemplo: api/v1/usuarios/detalles?id=11
	@GetMapping("/detalles")
	@ResponseBody
	public ResponseEntity<?> getUsuariosDetalles(@RequestParam("id") int userId) throws Exception {
		User user = userService.findUserById(userId);
		
		
		if (user != null) {
			return new ResponseEntity<>(user, HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>(new ErrorResponse("UserNotFound", "Usuario no encontrado"), HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/agregar")
	public ResponseEntity<User> agregarUsuario(@RequestBody User usuario) {

		User savedUsuario = userRepository.save(usuario);

		return new ResponseEntity<>(savedUsuario, HttpStatus.CREATED);
	}

}
