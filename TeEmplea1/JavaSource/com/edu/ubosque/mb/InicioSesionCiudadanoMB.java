package com.edu.ubosque.mb;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;


import com.edu.ubosque.logica.CiudadanoLogica;
import com.edu.ubosque.logica.DatosAcademicosLogica;
import com.edu.ubosque.model.Ciudadano;
import com.edu.ubosque.model.InformacionAcademica;


public class InicioSesionCiudadanoMB {

	private String usuario;
	private String clave;
	private Ciudadano ciudadanoSesion;
	private CiudadanoLogica ciudadanoLogica;
	private DatosAcademicosLogica datosAcademicosLogica;
	private List<InformacionAcademica>  informacionAcademica;
	private InformacionAcademica nuevaInformacionAcademica;
	
	public InicioSesionCiudadanoMB() {
		ciudadanoLogica = new CiudadanoLogica();
		datosAcademicosLogica = new DatosAcademicosLogica();
		nuevaInformacionAcademica = new InformacionAcademica();

	}

	
	public String validarInicioSesion()
	{
		ciudadanoSesion = ciudadanoLogica.validarUsuarioClave(usuario, clave);
		
		if(ciudadanoSesion!= null)
		{
			System.out.println("si");
			informacionAcademica = new ArrayList<InformacionAcademica>(ciudadanoSesion.getInformacionAcademicas());
			
			return "/sesion/sesionCiudadano";
		}
		else
		{
			System.out.println("no");
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "No se puede Iniciar Sesión","Usuario y/o Contraseña incorrectas"));
			return null;
		}
		
	}

	
	
	public void agregarInformacionAcademica()
	{
		
		nuevaInformacionAcademica.setCiudadano(ciudadanoSesion);
		
		boolean resultado = datosAcademicosLogica.createDatoAcademico(nuevaInformacionAcademica);
		informacionAcademica = new ArrayList<InformacionAcademica>(ciudadanoSesion.getInformacionAcademicas());
		
		if(resultado)
		{
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Proceso Exitoso","Información Agregada Exitosamente"));
		}
		
		else
		{
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "No se puede Agregar","Información Incorrecta"));
		}
		
	}
	
	
	
	public String getUsuario() {
		return usuario;
	}


	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}


	public String getClave() {
		return clave;
	}


	public void setClave(String clave) {
		this.clave = clave;
	}


	public Ciudadano getCiudadanoSesion() {
		return ciudadanoSesion;
	}


	public void setCiudadanoSesion(Ciudadano ciudadanoSesion) {
		this.ciudadanoSesion = ciudadanoSesion;
	}


	public List<InformacionAcademica> getInformacionAcademica() {
		return informacionAcademica;
	}


	public void setInformacionAcademica(List<InformacionAcademica> informacionAcademica) {
		this.informacionAcademica = informacionAcademica;
	}


	public InformacionAcademica getNuevaInformacionAcademica() {
		return nuevaInformacionAcademica;
	}


	public void setNuevaInformacionAcademica(InformacionAcademica nuevaInformacionAcademica) {
		this.nuevaInformacionAcademica = nuevaInformacionAcademica;
	}



	
	
	
	
}
