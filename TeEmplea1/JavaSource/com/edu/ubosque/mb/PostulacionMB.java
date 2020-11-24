package com.edu.ubosque.mb;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;


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
	
	private PostulacionLaboral nuevaPostulacion;
	private OfertaLaboral ofertaNuevaPostulacion;
	
	private int idNuevaPostulacion;

	
	public PostulacionMB() {		
		session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		ciudadano = (Ciudadano) session.getAttribute("ciudadanoLogeado");
		ofertaLaboralLogica = new OfertaLaboralLogica();
		postulacionLaboralLogica = new PostulacionLaboralLogica();
		inicializarLista();
		
	}
	
	private void inicializarLista()
	{
		listaOfertasLaborales = ofertaLaboralLogica.readOferta();
	}
	
	
	public void agregarEmpleo()
	{
		ofertaNuevaPostulacion = ofertaLaboralLogica.buscarOfertaPorId(idNuevaPostulacion);
		nuevaPostulacion = new PostulacionLaboral(ciudadano,ofertaNuevaPostulacion);
		postulacionLaboralLogica.createOferta(nuevaPostulacion);	
		 FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Proceso Éxitoso","Has agregado una nueva postulación"); 
	        FacesContext.getCurrentInstance().addMessage(null, message);
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
		return idNuevaPostulacion;
	}

	public void setIdNuevaPostulacion(int idNuevaPostulacion) {
		this.idNuevaPostulacion = idNuevaPostulacion;
	}
	
	
	

}
