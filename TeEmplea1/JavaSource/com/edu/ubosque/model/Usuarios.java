package com.edu.ubosque.model;
// Generated 5 nov. 2020 20:13:35 by Hibernate Tools 5.1.10.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Usuarios generated by hbm2java
 */
@Entity
@Table(name = "usuarios", catalog = "teempleabd")
public class Usuarios implements java.io.Serializable {

	private String nombreUsuario;
	private String contrasena;

	public Usuarios() {
	}

	public Usuarios(String nombreUsuario, String contrasena) {
		this.nombreUsuario = nombreUsuario;
		this.contrasena = contrasena;
	}

	@Id

	@Column(name = "NombreUsuario", unique = true, nullable = false, length = 50)
	public String getNombreUsuario() {
		return this.nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	@Column(name = "Contrasena", nullable = false, length = 50)
	public String getContrasena() {
		return this.contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

}
