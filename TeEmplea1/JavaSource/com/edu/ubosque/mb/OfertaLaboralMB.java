package com.edu.ubosque.mb;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.primefaces.PrimeFaces;

import com.edu.ubosque.logica.EmpresaLogica;
import com.edu.ubosque.logica.OfertaLaboralLogica;
import com.edu.ubosque.model.Empresa;
import com.edu.ubosque.model.OfertaLaboral;

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
	
	public OfertaLaboralMB() {

		session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		empresa = (Empresa) session.getAttribute("empresaLogueada");
		listaOfertasLaborales = new ArrayList<OfertaLaboral>(empresa.getOfertaLaborals());
		ofertaLogica = new OfertaLaboralLogica();
		ofertaLaboralNueva = new OfertaLaboral();
		empresaLogica = new EmpresaLogica();
	}
	
	public void agregarOfertaLaboral() {
		
		ofertaLaboralNueva.setEmpresa(empresa);
		ofertaLogica.createOferta(ofertaLaboralNueva);
		empresa = empresaLogica.empresaPorId(empresa.getIdempresa());
		listaOfertasLaborales = new ArrayList<OfertaLaboral>(empresa.getOfertaLaborals());
		PrimeFaces.current().dialog().closeDynamic(ofertaLaboralNueva);
	}
	
	public void eliminarOfertaLaboral() {
		
		ofertaLogica.deleteOferta(idOfertaAEliminar, empresa);
		empresa = empresaLogica.empresaPorId(empresa.getIdempresa());
		listaOfertasLaborales = new ArrayList<OfertaLaboral>(empresa.getOfertaLaborals());
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Proceso Éxitoso","Oferta Laboral Eliminada"); 
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
