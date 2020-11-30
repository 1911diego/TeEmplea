package com.edu.ubosque.mb;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import com.edu.ubosque.model.Ciudadano;

/**
 * Clase manage bean del ciudadano
 * @author Nicolás Ávila, Sebastián Moncaleano, Diego Torres | Universidad El Bosque
 *
 */
public class CiudadanoMB {

	private Ciudadano ciudadano;
	private HttpSession session;
	
	/**
	 * Metodo constructor de CiudadanoMB
	 */
	public CiudadanoMB() {
		
		session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		ciudadano = (Ciudadano) session.getAttribute("ciudadanoLogeado");
		
	}
	
	/**
	 * Metodo get del objeto Ciudadano
	 * @return Objeto Ciudadano
	 */
	public Ciudadano getCiudadano() {
		return ciudadano;
	}
	
	/**
	 * Metodo set de ciudadano
	 * @param ciudadano Objeto de ciudadano
	 */
	public void setCiudadano(Ciudadano ciudadano) {
		this.ciudadano = ciudadano;
	}
	
	
	
}


