package com.edu.ubosque.model;
// Generated 16 nov. 2020 22:30:43 by Hibernate Tools 5.2.12.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Empresa generated by hbm2java
 */
@Entity
@Table(name = "empresa")
public class Empresa implements java.io.Serializable {

	private int idempresa;
	private String nombre;
	private String perfil;
	private String sector;
	private String telefono;
	private String correo;
	private Set<OfertaLaboral> ofertaLaborals = new HashSet<OfertaLaboral>(0);

	public Empresa() {
	}

	public Empresa(int idempresa, String nombre, String perfil, String sector, String telefono, String correo) {
		this.idempresa = idempresa;
		this.nombre = nombre;
		this.perfil = perfil;
		this.sector = sector;
		this.telefono = telefono;
		this.correo = correo;
	}

	public Empresa(int idempresa, String nombre, String perfil, String sector, String telefono, String correo,
			Set<OfertaLaboral> ofertaLaborals) {
		this.idempresa = idempresa;
		this.nombre = nombre;
		this.perfil = perfil;
		this.sector = sector;
		this.telefono = telefono;
		this.correo = correo;
		this.ofertaLaborals = ofertaLaborals;
	}

	@Id

	@Column(name = "idempresa", unique = true, nullable = false)
	public int getIdempresa() {
		return this.idempresa;
	}

	public void setIdempresa(int idempresa) {
		this.idempresa = idempresa;
	}

	@Column(name = "nombre", nullable = false, length = 50)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column(name = "perfil", nullable = false, length = 45)
	public String getPerfil() {
		return this.perfil;
	}

	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}

	@Column(name = "sector", nullable = false, length = 45)
	public String getSector() {
		return this.sector;
	}

	public void setSector(String sector) {
		this.sector = sector;
	}

	@Column(name = "telefono", nullable = false, length = 15)
	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	@Column(name = "correo", nullable = false, length = 45)
	public String getCorreo() {
		return this.correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "empresa")
	public Set<OfertaLaboral> getOfertaLaborals() {
		return this.ofertaLaborals;
	}

	public void setOfertaLaborals(Set<OfertaLaboral> ofertaLaborals) {
		this.ofertaLaborals = ofertaLaborals;
	}

}
