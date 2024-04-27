package com.unla.proyectooo2.models;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRoleModel {

	private int id;
	private String role;
	
	
	public UserRoleModel(String role) {
		super();
		this.role = role;
	}
	
	public UserRoleModel() {}
	
	
}
