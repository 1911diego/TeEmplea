package com.edu.ubosque.mb;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import com.edu.ubosque.logica.CiudadanoLogica;
import com.edu.ubosque.logica.OfertaLaboralLogica;
import com.edu.ubosque.logica.PostulacionLaboralLogica;
import com.edu.ubosque.model.Ciudadano;
import com.edu.ubosque.model.OfertaLaboral;
import com.edu.ubosque.model.PostulacionLaboral;


public class PostulacionMB {

	private Ciudadano ciudadano;
	private HttpSession session;
	private List<OfertaLaboral>  listaOfertasLaborales;
	private List<OfertaLaboral> ofertasFiltradas;
	private PostulacionLaboralLogica postulacionLaboralLogica;
	private OfertaLaboralLogica ofertaLaboralLogica;
	private List<PostulacionLaboral> listaPostulacionesCiudadano;
	
	private PostulacionLaboral nuevaPostulacion;
	private OfertaLaboral ofertaNuevaPostulacion;
	private CiudadanoLogica ciudadanoLogica;
	
	private int idOfertaNuevaPostulacion;
	
	
	private OfertaLaboral nuevo;
	private PostulacionLaboral postulacionAEliminar;

	
	public PostulacionMB() {		
		session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		ciudadano = (Ciudadano) session.getAttribute("ciudadanoLogeado");
		ofertaLaboralLogica = new OfertaLaboralLogica();
		postulacionLaboralLogica = new PostulacionLaboralLogica();
		ciudadanoLogica = new CiudadanoLogica();
		inicializarListas();
		
	}
	
	private void inicializarListas()
	{
		listaOfertasLaborales = ofertaLaboralLogica.readOferta();
		listaPostulacionesCiudadano = postulacionLaboralLogica.buscarPostulacionesPorCiudadanoOEmpresa(ciudadano.getId(),1);
	}
	
	
	public void agregarEmpleo()
	{
		ofertaNuevaPostulacion = ofertaLaboralLogica.buscarOfertaPorId(idOfertaNuevaPostulacion);
		nuevaPostulacion = new PostulacionLaboral(ciudadano,ofertaNuevaPostulacion);
		boolean agregado = postulacionLaboralLogica.createPostulacionLaboral(nuevaPostulacion,idOfertaNuevaPostulacion);
		
		if(agregado)
		{
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Proceso Éxitoso","Has agregado una nueva postulación"); 
		    FacesContext.getCurrentInstance().addMessage(null, message);
		    System.out.println("Agregado exitoso");
		}
		else
		{
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "No se puede Agregar","ya has agregado esta postulación"); 
		    FacesContext.getCurrentInstance().addMessage(null, message);
		    System.out.println("No agregado");
		}
		
	}
	
	public void eliminarEmpleo()
	{
		boolean eliminado = postulacionLaboralLogica.deletePostulacionLaboral(postulacionAEliminar);
		
		
		if(eliminado)
		{
			ciudadano = ciudadanoLogica.buscarCiudadanoPorId(ciudadano.getId());
			listaPostulacionesCiudadano = postulacionLaboralLogica.buscarPostulacionesPorCiudadanoOEmpresa(ciudadano.getId(),1);
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Proceso Éxitoso","Has eliminado esta postulación"); 
		    FacesContext.getCurrentInstance().addMessage(null, message);
		    System.out.println("Eliminado exitoso");
		}
		
		else
		{
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "No se puede Eliminar!","ya has agregado esta postulación"); 
		    FacesContext.getCurrentInstance().addMessage(null, message);
		    System.out.println("No Eliminado");
		}
	}
	
	

	public List<OfertaLaboral> getListaOfertasLaborales() {
		return listaOfertasLaborales;
	}
	

	public void setListaOfertasLaborales(List<OfertaLaboral> listaOfertasLaborales) {
		this.listaOfertasLaborales = listaOfertasLaborales;
	}

	public OfertaLaboralLogica getOfertaLaboralLogica() {
		return ofertaLaboralLogica;
	}

	public void setOfertaLaboralLogica(OfertaLaboralLogica ofertaLaboralLogica) {
		this.ofertaLaboralLogica = ofertaLaboralLogica;
	}

	public List<OfertaLaboral> getOfertasFiltradas() {
		return ofertasFiltradas;
	}

	public void setOfertasFiltradas(List<OfertaLaboral> ofertasFiltradas) {
		this.ofertasFiltradas = ofertasFiltradas;
	}

	public int getIdNuevaPostulacion() {
		return idOfertaNuevaPostulacion;
	}

	public void setIdNuevaPostulacion(int idNuevaPostulacion) {
		this.idOfertaNuevaPostulacion = idNuevaPostulacion;
	}

	public List<PostulacionLaboral> getListaPostulacionesCiudadano() {
		return listaPostulacionesCiudadano;
	}

	public void setListaPostulacionesCiudadano(List<PostulacionLaboral> listaPostulacionesCiudadano) {
		this.listaPostulacionesCiudadano = listaPostulacionesCiudadano;
	}

	public OfertaLaboral getNuevo() {
		return nuevo;
	}

	public void setNuevo(OfertaLaboral nuevo) {
		this.nuevo = nuevo;
	}

	public PostulacionLaboral getPostulacionAEliminar() {
		return postulacionAEliminar;
	}

	public void setPostulacionAEliminar(PostulacionLaboral postulacionAEliminar) {
		this.postulacionAEliminar = postulacionAEliminar;
	}
	
	
	

}
