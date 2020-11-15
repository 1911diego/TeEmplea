package com.edu.ubosque.model;
// Generated 14/11/2020, 11:42:56 a. m. by Hibernate Tools 5.2.12.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * ExperienciaLaboral generated by hbm2java
 */
@Entity
@Table(name = "experiencia_laboral")
public class ExperienciaLaboral implements java.io.Serializable {

	private int id;
	private Date fechaInicial;
	private Date fechaFinal;
	private String empresa;
	private String sector;
	private String cargo;
	private String funciones;
	private Set<Ciudadano> ciudadanos = new HashSet<Ciudadano>(0);

	public ExperienciaLaboral() {
	}

	public ExperienciaLaboral(int id, Date fechaInicial, String empresa, String sector, String cargo,
			String funciones) {
		this.id = id;
		this.fechaInicial = fechaInicial;
		this.empresa = empresa;
		this.sector = sector;
		this.cargo = cargo;
		this.funciones = funciones;
	}

	public ExperienciaLaboral(int id, Date fechaInicial, Date fechaFinal, String empresa, String sector, String cargo,
			String funciones, Set<Ciudadano> ciudadanos) {
		this.id = id;
		this.fechaInicial = fechaInicial;
		this.fechaFinal = fechaFinal;
		this.empresa = empresa;
		this.sector = sector;
		this.cargo = cargo;
		this.funciones = funciones;
		this.ciudadanos = ciudadanos;
	}

	@Id

	@Column(name = "id", unique = true, nullable = false)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_inicial", nullable = false, length = 10)
	public Date getFechaInicial() {
		return this.fechaInicial;
	}

	public void setFechaInicial(Date fechaInicial) {
		this.fechaInicial = fechaInicial;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_final", length = 10)
	public Date getFechaFinal() {
		return this.fechaFinal;
	}

	public void setFechaFinal(Date fechaFinal) {
		this.fechaFinal = fechaFinal;
	}

	@Column(name = "empresa", nullable = false, length = 45)
	public String getEmpresa() {
		return this.empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	@Column(name = "sector", nullable = false, length = 45)
	public String getSector() {
		return this.sector;
	}

	public void setSector(String sector) {
		this.sector = sector;
	}

	@Column(name = "cargo", nullable = false, length = 45)
	public String getCargo() {
		return this.cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	@Column(name = "funciones", nullable = false, length = 200)
	public String getFunciones() {
		return this.funciones;
	}

	public void setFunciones(String funciones) {
		this.funciones = funciones;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "experienciaLaboral")
	public Set<Ciudadano> getCiudadanos() {
		return this.ciudadanos;
	}

	public void setCiudadanos(Set<Ciudadano> ciudadanos) {
		this.ciudadanos = ciudadanos;
	}

}
