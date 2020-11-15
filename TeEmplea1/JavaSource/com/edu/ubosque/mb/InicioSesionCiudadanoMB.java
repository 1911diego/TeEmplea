package com.edu.ubosque.mb;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import com.edu.ubosque.logica.CiudadanoLogica;
import com.edu.ubosque.logica.UsuarioLogica;
import com.edu.ubosque.model.Ciudadano;

public class InicioSesionCiudadanoMB {

	private String usuario;
	private String clave;
	private Ciudadano ciudadanoSesion;
	private CiudadanoLogica ciudadanoLogica;
	
	public InicioSesionCiudadanoMB() {
		ciudadanoLogica = new CiudadanoLogica();
	}

	
	public String validarInicioSesion()
	{
		Ciudadano ciudadanoSesion = ciudadanoLogica.validarUsuarioClave(usuario, clave);
		
		if(ciudadanoSesion!= null)
		{
			System.out.println("si");
			return "/sesion/sesionCiudadano";
		}
		else
		{
			System.out.println("no");
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "No se puede Iniciar Sesión","Usuario y/o Contraseña incorrectas"));
			return null;
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
	
	
	
}
