package com.edu.ubosque.mb;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import com.edu.ubosque.model.Empresa;

public class EmpresaMB {

	private Empresa empresa;
	private HttpSession session;
	
	public EmpresaMB() {
		
		session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		empresa = (Empresa) session.getAttribute("empresaLogueada");
		
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

}
