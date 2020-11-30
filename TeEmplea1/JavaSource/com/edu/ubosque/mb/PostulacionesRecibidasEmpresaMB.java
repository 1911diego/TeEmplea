package com.edu.ubosque.mb;

import java.util.ArrayList;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import com.edu.ubosque.logica.PostulacionLaboralLogica;
import com.edu.ubosque.model.Ciudadano;
import com.edu.ubosque.model.Empresa;
import com.edu.ubosque.model.ExperienciaLaboral;
import com.edu.ubosque.model.InformacionAcademica;
import com.edu.ubosque.model.PostulacionLaboral;
import com.edu.ubosque.model.Referencias;

/**
 * Clase manage bean de las postulaciones laborales
 * @author Nicolás Ávila, Sebastián Moncaleano, Diego Torres | Universidad El Bosque
 *
 */
public class PostulacionesRecibidasEmpresaMB {

	private Empresa empresa;
	private HttpSession session;
	private PostulacionLaboralLogica postulacionLaboralLogica;
	private List<PostulacionLaboral> listaPostulacionesRecibidas;
	private List<PostulacionLaboral> listaPostulacionesFiltradas;
	

	private PostulacionLaboral postulacionRecibida;
	private List<InformacionAcademica> listaInformacionAcademicaCiudadano;
	private List<ExperienciaLaboral> listaExperienciaLaboralCiudadano;
	private List<Referencias> listaReferenciasCiudadano;
	private int render;
	
	/**
	 * Metodo constructor de PostulacionesRecibidasEmpresaMB
	 */
	public PostulacionesRecibidasEmpresaMB() {
		session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		empresa = (Empresa) session.getAttribute("empresaLogueada");
		postulacionLaboralLogica = new PostulacionLaboralLogica();
		inicializarLista();
	}
	
	/**
	 * Metodo que inicializa la lista
	 */
	private void inicializarLista()
	{
		listaPostulacionesRecibidas = postulacionLaboralLogica.buscarPostulacionesPorCiudadanoOEmpresa(empresa.getIdempresa(),2);
		
	}
	
	/**
	 * Metodo que llena la lista del ciudadano
	 * @param render numero de render
	 */
	public void llenarListasCiudadano(int render)
	{
		
		listaInformacionAcademicaCiudadano = new ArrayList<InformacionAcademica>(postulacionRecibida.getCiudadano().getInformacionAcademicas());
		listaExperienciaLaboralCiudadano = new ArrayList<ExperienciaLaboral>(postulacionRecibida.getCiudadano().getExperienciaLaborals());
		listaReferenciasCiudadano = new ArrayList<Referencias>(postulacionRecibida.getCiudadano().getReferenciases());
		
		this.render = render;
		VentanasEmergentesMB ventanaemergente = new VentanasEmergentesMB();
		
		ventanaemergente.ventanaDetallesPostulacionCiudadano();
	}

	public List<PostulacionLaboral> getListaPostulacionesRecibidas() {
		return listaPostulacionesRecibidas;
	}

	public void setListaPostulacionesRecibidas(List<PostulacionLaboral> listaPostulacionesRecibidas) {
		this.listaPostulacionesRecibidas = listaPostulacionesRecibidas;
	}

	public List<PostulacionLaboral> getListaPostulacionesFiltradas() {
		return listaPostulacionesFiltradas;
	}

	public void setListaPostulacionesFiltradas(List<PostulacionLaboral> listaPostulacionesFiltradas) {
		this.listaPostulacionesFiltradas = listaPostulacionesFiltradas;
	}

	public PostulacionLaboral getPostulacionRecibida() {
		return postulacionRecibida;
	}

	public void setPostulacionRecibida(PostulacionLaboral postulacionRecibida) {
		this.postulacionRecibida = postulacionRecibida;
	}

	public List<InformacionAcademica> getListaInformacionAcademicaCiudadano() {
		return listaInformacionAcademicaCiudadano;
	}

	public void setListaInformacionAcademicaCiudadano(List<InformacionAcademica> listaInformacionAcademicaCiudadano) {
		this.listaInformacionAcademicaCiudadano = listaInformacionAcademicaCiudadano;
	}

	public List<ExperienciaLaboral> getListaExperienciaLaboralCiudadano() {
		return listaExperienciaLaboralCiudadano;
	}

	public void setListaExperienciaLaboralCiudadano(List<ExperienciaLaboral> listaExperienciaLaboralCiudadano) {
		this.listaExperienciaLaboralCiudadano = listaExperienciaLaboralCiudadano;
	}

	public List<Referencias> getListaReferenciasCiudadano() {
		return listaReferenciasCiudadano;
	}

	public void setListaReferenciasCiudadano(List<Referencias> listaReferenciasCiudadano) {
		this.listaReferenciasCiudadano = listaReferenciasCiudadano;
	}

	public int getRender() {
		return render;
	}

	public void setRender(int render) {
		this.render = render;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	
	
	
}
