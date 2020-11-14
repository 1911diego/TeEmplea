package com.edu.ubosque.model;
// Generated 13/11/2020, 9:41:30 p. m. by Hibernate Tools 5.2.12.Final

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
 * InformacionAcademica generated by hbm2java
 */
@Entity
@Table(name = "informacion_academica")
public class InformacionAcademica implements java.io.Serializable {

	private int id;
	private Date fechaInicial;
	private Date fechaFinal;
	private String institucion;
	private String titulo;
	private String nivelEstudio;
	private Set<Ciudadano> ciudadanos = new HashSet<Ciudadano>(0);

	public InformacionAcademica() {
	}

	public InformacionAcademica(int id, Date fechaInicial, String institucion, String titulo, String nivelEstudio) {
		this.id = id;
		this.fechaInicial = fechaInicial;
		this.institucion = institucion;
		this.titulo = titulo;
		this.nivelEstudio = nivelEstudio;
	}

	public InformacionAcademica(int id, Date fechaInicial, Date fechaFinal, String institucion, String titulo,
			String nivelEstudio, Set<Ciudadano> ciudadanos) {
		this.id = id;
		this.fechaInicial = fechaInicial;
		this.fechaFinal = fechaFinal;
		this.institucion = institucion;
		this.titulo = titulo;
		this.nivelEstudio = nivelEstudio;
		this.ciudadanos = ciudadanos;
	}

	@Id

	@Column(name = "ID", unique = true, nullable = false)
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

	@Column(name = "institucion", nullable = false, length = 60)
	public String getInstitucion() {
		return this.institucion;
	}

	public void setInstitucion(String institucion) {
		this.institucion = institucion;
	}

	@Column(name = "titulo", nullable = false, length = 45)
	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	@Column(name = "nivel_estudio", nullable = false, length = 45)
	public String getNivelEstudio() {
		return this.nivelEstudio;
	}

	public void setNivelEstudio(String nivelEstudio) {
		this.nivelEstudio = nivelEstudio;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "informacionAcademica")
	public Set<Ciudadano> getCiudadanos() {
		return this.ciudadanos;
	}

	public void setCiudadanos(Set<Ciudadano> ciudadanos) {
		this.ciudadanos = ciudadanos;
	}

}
