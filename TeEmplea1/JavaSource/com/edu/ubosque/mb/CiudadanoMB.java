package com.edu.ubosque.mb;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import com.edu.ubosque.model.Ciudadano;

public class CiudadanoMB {

	private Ciudadano ciudadano;
	private HttpSession session;
	public CiudadanoMB() {
		
		session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		ciudadano = (Ciudadano) session.getAttribute("ciudadanoLogeado");
		
	}
	
	
	
	public Ciudadano getCiudadano() {
		return ciudadano;
	}
	public void setCiudadano(Ciudadano ciudadano) {
		this.ciudadano = ciudadano;
	}
	
	
	
}


