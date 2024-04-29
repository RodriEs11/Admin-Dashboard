package com.unla.proyectooo2.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.unla.proyectooo2.models.UserRoleModel;
import com.unla.proyectooo2.services.implementation.UserRoleService;

import jakarta.transaction.Transactional;

@Component
public class RoleInitializer implements CommandLineRunner {

	@Autowired
	@Qualifier("userRoleService")
	private UserRoleService userRoleService;

	
	//Al iniciar la aplicacion, chequea si existen los roles en la DB, sino los agrega
	@Override
	@Transactional
	public void run(String... args) throws Exception {

		String[] requiredRoles = { "ROLE_ADMIN", "ROLE_USER" };

		for (String roleName : requiredRoles) {

			if (userRoleService.getByRole(roleName) == null) {
				UserRoleModel newRole = new UserRoleModel();
				newRole.setRole(roleName);
				userRoleService.insertOrUpdate(newRole);
			}
		}
	}

}
