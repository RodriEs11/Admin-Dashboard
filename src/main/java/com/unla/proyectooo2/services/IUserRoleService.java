package com.unla.proyectooo2.services;

import java.util.List;

import com.unla.proyectooo2.entities.UserRole;
import com.unla.proyectooo2.models.UserRoleModel;

public interface IUserRoleService {
	
	public List<UserRole> getAll();
	public UserRoleModel insertOrUpdate(UserRoleModel userRoleModel);
	public UserRole getByRole(String role);
}
