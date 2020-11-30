package com.edu.ubosque.model;
// Generated 23/11/2020, 6:36:43 p.�m. by Hibernate Tools 5.2.12.Final

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Clase que modela la info academica
 * InformacionAcademica generated by hbm2java
 * @author Nicol�s �vila, Sebasti�n Moncaleano, Diego Torres | Universidad El Bosque
 */
@Entity
@Table(name = "informacion_academica")
public class InformacionAcademica implements java.io.Serializable {

	private int id;
	private Ciudadano ciudadano;
	private Date fechaInicial;
	private Date fechaFinal;
	private String institucion;
	private String titulo;
	private String nivelEstudio;

	public InformacionAcademica() {
	}

	public InformacionAcademica(int id, Ciudadano ciudadano, Date fechaInicial, String institucion, String titulo,
			String nivelEstudio) {
		this.id = id;
		this.ciudadano = ciudadano;
		this.fechaInicial = fechaInicial;
		this.institucion = institucion;
		this.titulo = titulo;
		this.nivelEstudio = nivelEstudio;
	}

	public InformacionAcademica(int id, Ciudadano ciudadano, Date fechaInicial, Date fechaFinal, String institucion,
			String titulo, String nivelEstudio) {
		this.id = id;
		this.ciudadano = ciudadano;
		this.fechaInicial = fechaInicial;
		this.fechaFinal = fechaFinal;
		this.institucion = institucion;
		this.titulo = titulo;
		this.nivelEstudio = nivelEstudio;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", unique = true, nullable = false)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_ciudadano", nullable = false)
	public Ciudadano getCiudadano() {
		return this.ciudadano;
	}

	public void setCiudadano(Ciudadano ciudadano) {
		this.ciudadano = ciudadano;
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

}
