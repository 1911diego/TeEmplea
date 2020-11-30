package com.edu.ubosque.mb;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.digest.DigestUtils;

import com.edu.ubosque.logica.CiudadanoLogica;
import com.edu.ubosque.logica.EmpresaLogica;
import com.edu.ubosque.model.Ciudadano;
import com.edu.ubosque.model.Empresa;

/**
 * clase manage bean de la sesion
 * @author Nicolás Ávila, Sebastián Moncaleano, Diego Torres | Universidad El Bosque
 *
 */
public class SesionMB {

	private Ciudadano ciudadano;
	private CiudadanoLogica ciudadanoLogica;
	private Empresa empresa;
	private EmpresaLogica empresaLogica;
	private String usuario;
	private String clave;
	
	/**
	 * Metodo constructor de SesionMB
	 */
	public SesionMB() {
		ciudadanoLogica = new CiudadanoLogica();
		empresaLogica = new EmpresaLogica();
	}
	
	
	/**
	 * Metodo de inicio de sesion
	 * @return la pagina a la que se dirige
	 */
	public String iniciarSesion()
	{
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		
		String encript = DigestUtils.sha1Hex(clave);
		
		ciudadano = ciudadanoLogica.validarUsuarioClave(usuario,encript);
		
		if(ciudadano!=null)
		{
			session.setAttribute("ciudadanoLogeado", ciudadano);
			return "/sesion/sesionCiudadano";
		}
		else
		{
			empresa = empresaLogica.validarEmpresaClave(usuario, encript);
			
			if(empresa != null) {
				
				session.setAttribute("empresaLogueada", empresa);
				return "/sesion/sesionEmpresa";
				
			} else {
				
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "No se puede Iniciar Sesión","Usuario y/o Contraseña incorrectas"));
				return null;
			}
			
		}
		
	}
	
	/**
	 * Metodo que verifica el usuario
	 * @return true si esta, false si no
	 */
	public boolean verificarUsuario()
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
	
	/**
	 * Metodo de cerrar sesion
	 * @return se dirige a la pagina de inicio
	 */
	public String cerrarSesion()
	{
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		
		return "/Principal/principal";
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
