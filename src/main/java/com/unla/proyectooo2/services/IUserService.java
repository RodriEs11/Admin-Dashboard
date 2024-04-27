package com.unla.proyectooo2.services;

import java.util.List;

import com.unla.proyectooo2.entities.User;
import com.unla.proyectooo2.models.UserModel;

public interface IUserService {
	
	public List<User> getAll();
	public UserModel getUserByUsername(String username);
	public UserModel insertOrUpdate(UserModel usuarioModel);
	public boolean remove(int id);
	
	
}
