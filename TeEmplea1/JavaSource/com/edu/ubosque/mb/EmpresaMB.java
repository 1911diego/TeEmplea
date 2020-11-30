package com.edu.ubosque.mb;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import com.edu.ubosque.model.Empresa;

/**
 * clase manage bean de empresa
 * @author Nicolás Ávila, Sebastián Moncaleano, Diego Torres | Universidad El Bosque
 *
 */
public class EmpresaMB {

	private Empresa empresa;
	private HttpSession session;
	
	/**
	 * Metodo constructor de EmpresaMB
	 */
	public EmpresaMB() {
		
		session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		empresa = (Empresa) session.getAttribute("empresaLogueada");
		
	}

	/**
	 * Metodo get de empresa
	 * @return objeto Empresa
	 */
	public Empresa getEmpresa() {
		return empresa;
	}

	/**
	 * Metodo set de empresa
	 * @param empresa Objeto Empresa
	 */
	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

}
