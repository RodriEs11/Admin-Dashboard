package com.unla.proyectooo2.converters;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.unla.proyectooo2.entities.User;
import com.unla.proyectooo2.models.UserModel;



@Component("userConverter")
public class UserConverter {

	private final ModelMapper modelMapper;

	
	public UserConverter(ModelMapper modelMapper) {
		this.modelMapper = modelMapper;
	}

	public UserModel entityToModel(User user) {

		return modelMapper.map(user, UserModel.class);
	}

	public User modelToEntity(UserModel userModel) {

		return modelMapper.map(userModel, User.class);
	}

	/*
	 * 
	 * public UsuarioModel entityToModel(User usuario) {
	 * 
	 * return new UsuarioModel(usuario.getId(), usuario.getNombre(),
	 * usuario.getApellido(), usuario.getFechaNacimiento()); }
	 * 
	 * public User modelToEntity(UsuarioModel usuarioModel) {
	 * 
	 * return new User(usuarioModel.getId(), usuarioModel.getNombre(),
	 * usuarioModel.getApellido(), usuarioModel.getFechaNacimiento()); }
	 * 
	 */

}
