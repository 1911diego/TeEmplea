package com.edu.ubosque.mb;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.primefaces.PrimeFaces;
import org.primefaces.event.SelectEvent;

import com.edu.ubosque.logica.EmpresaLogica;
import com.edu.ubosque.logica.OfertaLaboralLogica;
import com.edu.ubosque.model.Empresa;
import com.edu.ubosque.model.OfertaLaboral;

/**
 * Clase manage bean de la oferta laboral
 * @author Nicolás Ávila, Sebastián Moncaleano, Diego Torres | Universidad El Bosque
 *
 */
public class OfertaLaboralMB {

	private Empresa empresa;
	private HttpSession session;
	private List<OfertaLaboral> listaOfertasLaborales;
	private EmpresaLogica empresaLogica;
	private OfertaLaboralLogica ofertaLogica;
	private OfertaLaboral ofertaLaboralNueva;
	private OfertaLaboral ofertaLaboralAModificar;
	private int idOfertaAModificar;
	private int idOfertaAEliminar;
	
	/**
	 * Metodo constructor de OfertaLaboralMB
	 */
	public OfertaLaboralMB() {

		session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		empresa = (Empresa) session.getAttribute("empresaLogueada");
		listaOfertasLaborales = new ArrayList<OfertaLaboral>(empresa.getOfertaLaborals());
		ofertaLogica = new OfertaLaboralLogica();
		ofertaLaboralNueva = new OfertaLaboral();
		empresaLogica = new EmpresaLogica();
	}
	
	/**
	 * Metodo que agrega un oferta laboral
	 */
	public void agregarOfertaLaboral() {
		
		ofertaLaboralNueva.setEmpresa(empresa);
		ofertaLogica.createOferta(ofertaLaboralNueva);
		empresa = empresaLogica.empresaPorId(empresa.getIdempresa());
		listaOfertasLaborales = new ArrayList<OfertaLaboral>(empresa.getOfertaLaborals());
		PrimeFaces.current().dialog().closeDynamic(ofertaLaboralNueva);
		ofertaLaboralNueva = new OfertaLaboral();
	}
	
	/**
	 * Metodo que elimina una oferta laboral
	 */
	public void eliminarOfertaLaboral() {
		
		ofertaLogica.deleteOferta(idOfertaAEliminar, empresa);
		empresa = empresaLogica.empresaPorId(empresa.getIdempresa());
		listaOfertasLaborales = new ArrayList<OfertaLaboral>(empresa.getOfertaLaborals());
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Proceso Éxitoso","Oferta Laboral Eliminada"); 
        FacesContext.getCurrentInstance().addMessage(null, message);
	}
	
	/**
	 * Metodo que muestra un mensaje
	 * @param event evento de la pagina
	 */
	public void mensajeOfertaAgregada(SelectEvent event) {
        OfertaLaboral oferta = (OfertaLaboral) event.getObject();
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Oferta laboral agregada",oferta.getArea()); 
        FacesContext.getCurrentInstance().addMessage(null, message);
 }

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public HttpSession getSession() {
		return session;
	}

	public void setSession(HttpSession session) {
		this.session = session;
	}

	public List<OfertaLaboral> getListaOfertasLaborales() {
		return listaOfertasLaborales;
	}

	public void setListaOfertasLaborales(List<OfertaLaboral> listaOfertasLaborales) {
		this.listaOfertasLaborales = listaOfertasLaborales;
	}

	public EmpresaLogica getEmpresaLogica() {
		return empresaLogica;
	}

	public void setEmpresaLogica(EmpresaLogica empresaLogica) {
		this.empresaLogica = empresaLogica;
	}

	public OfertaLaboralLogica getOfertaLogica() {
		return ofertaLogica;
	}

	public void setOfertaLogica(OfertaLaboralLogica ofertaLogica) {
		this.ofertaLogica = ofertaLogica;
	}

	public OfertaLaboral getOfertaLaboralNueva() {
		return ofertaLaboralNueva;
	}

	public void setOfertaLaboralNueva(OfertaLaboral ofertaLaboralNueva) {
		this.ofertaLaboralNueva = ofertaLaboralNueva;
	}

	public OfertaLaboral getOfertaLaboralAModificar() {
		return ofertaLaboralAModificar;
	}

	public void setOfertaLaboralAModificar(OfertaLaboral ofertaLaboralAModificar) {
		this.ofertaLaboralAModificar = ofertaLaboralAModificar;
	}

	public int getIdOfertaAModificar() {
		return idOfertaAModificar;
	}

	public void setIdOfertaAModificar(int idOfertaAModificar) {
		this.idOfertaAModificar = idOfertaAModificar;
	}

	public int getIdOfertaAEliminar() {
		return idOfertaAEliminar;
	}

	public void setIdOfertaAEliminar(int idOfertaAEliminar) {
		this.idOfertaAEliminar = idOfertaAEliminar;
	}

}
