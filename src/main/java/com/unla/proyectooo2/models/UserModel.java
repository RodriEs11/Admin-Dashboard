package com.unla.proyectooo2.models;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserModel {

	private int id;
	private String nombre;
	private String apellido;
	private LocalDate fechaNacimiento;
	private boolean enabled;
	private String username;
	private String password;
	private Set<UserRoleModel> roles = new HashSet<UserRoleModel>();
	
	public UserModel() {}

}
