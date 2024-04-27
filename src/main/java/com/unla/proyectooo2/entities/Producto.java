package com.unla.proyectooo2.entities;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "producto")
public class Producto {

	@Id
	@GeneratedValue()
	private int codigoUnico;

	@Column(name = "nombre", unique = true, nullable = false, length = 100)
	private String nombre;

	@Column(name = "descripcion", nullable = false)
	private String descripcion;

	@Column(name = "costo", nullable = false)
	private int costo;

	@Column(name = "precioVenta", nullable = false)
	private int precioVenta;

	@Column(name = "createat")
	@CreationTimestamp
	private LocalDateTime createdAt;

	@Column(name = "updateat")
	@UpdateTimestamp
	private LocalDateTime updatedAt;
}
