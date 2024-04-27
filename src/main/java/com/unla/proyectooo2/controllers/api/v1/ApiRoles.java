package com.unla.proyectooo2.controllers.api.v1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unla.proyectooo2.entities.UserRole;
import com.unla.proyectooo2.services.IUserRoleService;

@RestController
@RequestMapping("/api/v1/roles")
public class ApiRoles {
	

	@Autowired
	@Qualifier("userRoleService")
	private IUserRoleService userRoleService;
	
	
	@GetMapping("")
	public ResponseEntity<List<UserRole>> getAllRoles(){
		
		List<UserRole> roles = userRoleService.getAll();
		
		return ResponseEntity.ok(roles);
	}
	
}
