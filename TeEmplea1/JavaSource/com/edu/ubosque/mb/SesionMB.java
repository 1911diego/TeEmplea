package com.edu.ubosque.mb;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import com.edu.ubosque.logica.CiudadanoLogica;
import com.edu.ubosque.logica.EmpresaLogica;
import com.edu.ubosque.model.Ciudadano;
import com.edu.ubosque.model.Empresa;

public class SesionMB {

	private Ciudadano ciudadano;
	private CiudadanoLogica ciudadanoLogica;
	private Empresa empresa;
	private EmpresaLogica empresaLogica;
	private String usuario;
	private String clave;
	
	public SesionMB() {
		ciudadanoLogica = new CiudadanoLogica();
		empresaLogica = new EmpresaLogica();
	}
	
	
	public String iniciarSesionCiudadano()
	{
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		
		ciudadano = ciudadanoLogica.validarUsuarioClave(usuario,clave);
		
		if(ciudadano!=null)
		{
			session.setAttribute("ciudadanoLogeado", ciudadano);
			System.out.println("si");
			return "/sesion/sesionCiudadano";
		}
		else
		{
			empresa = empresaLogica.validarEmpresaClave(usuario, clave);
			
			if(empresa != null) {
				
				session.setAttribute("empresaLogueada", empresa);
				System.out.println("si");
				return "/sesion/sesionEmpresa";
				
			} else {
				
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "No se puede Iniciar Sesión","Usuario y/o Contraseña incorrectas"));
				return null;
			}
			
		}
		
	}
	
	public boolean verificarSesionCiudadano()
	{
		if(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("ciudadano") != null)
		{
			return true;
		} else if(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("empresa") != null) {
			
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public String cerrarSesionCiudadano()
	{
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		
		return "Principal/principal";
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

	
}
