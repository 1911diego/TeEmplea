package com.edu.ubosque.mb;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.primefaces.PrimeFaces;
import org.primefaces.event.SelectEvent;

import com.edu.ubosque.logica.CiudadanoLogica;
import com.edu.ubosque.logica.ReferenciaLogica;
import com.edu.ubosque.model.Ciudadano;
import com.edu.ubosque.model.InformacionAcademica;
import com.edu.ubosque.model.Referencias;

public class ReferenciaMB {

	private Ciudadano ciudadano;
	private HttpSession session;
	private List<Referencias>  listaReferencias;
	private CiudadanoLogica ciudadanoLogica;
	private ReferenciaLogica referenciaLogica;
	
	private Referencias nuevaReferencia;
	private Referencias referenciaAModificar;
	
	private int idReferenciaAEliminar;
	private int idReferenciaABuscar;
	
	public ReferenciaMB() {		
		session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		ciudadano = (Ciudadano) session.getAttribute("ciudadanoLogeado");
		referenciaLogica = new ReferenciaLogica();
		nuevaReferencia = new Referencias();
		ciudadanoLogica = new CiudadanoLogica();
		inicializarLista();
	}
	
	private void inicializarLista()
	{
		ciudadano = ciudadanoLogica.buscarCiudadanoPorId(ciudadano.getId());
		listaReferencias = new ArrayList<Referencias>(ciudadano.getReferenciases());
	}
	
	
	public void agregarReferencia()
	{
		nuevaReferencia.setCiudadano(ciudadano);
		referenciaLogica.createReferencia(nuevaReferencia);
		ciudadano = ciudadanoLogica.buscarCiudadanoPorId(ciudadano.getId());
		listaReferencias = new ArrayList<Referencias>(ciudadano.getReferenciases());
		PrimeFaces.current().dialog().closeDynamic(nuevaReferencia);
		nuevaReferencia = new Referencias();
	}
	
	public void eliminarReferencia()
	{	
		referenciaLogica.deleteReferencia(idReferenciaAEliminar,ciudadano);
		ciudadano = ciudadanoLogica.buscarCiudadanoPorId(ciudadano.getId());
		listaReferencias = new ArrayList<Referencias>(ciudadano.getReferenciases());
		  FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Proceso Éxitoso","Información Académica Eliminada"); 
	        FacesContext.getCurrentInstance().addMessage(null, message);
	}
	
	
	
	 public void mensajeReferenciaAgregada(SelectEvent event) {
	        Referencias info = (Referencias) event.getObject();
	        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Información Académica Agregada",info.getNombre()); 
	        FacesContext.getCurrentInstance().addMessage(null, message);
	 }
	 
	 
	 public void asignarReferenciaAEditar()
	 {
		 referenciaAModificar = referenciaLogica.buscarReferencia(idReferenciaABuscar);
		 System.out.println(referenciaAModificar.getId());
	 }
	 
	 public void editarReferencia()
	 {
		 referenciaLogica.updateReferencia(referenciaAModificar);
	 }
	
	
	public Ciudadano getCiudadano() {
		return ciudadano;
	}
	public void setCiudadano(Ciudadano ciudadano) {
		this.ciudadano = ciudadano;
	}

	public List<Referencias> getListaReferencias() {
		return listaReferencias;
	}

	public void setListaReferencias(List<Referencias> listaReferencias) {
		this.listaReferencias = listaReferencias;
	}

	public ReferenciaLogica getReferenciaLogica() {
		return referenciaLogica;
	}

	public void setReferenciaLogica(ReferenciaLogica referenciaLogica) {
		this.referenciaLogica = referenciaLogica;
	}

	public Referencias getNuevaReferencia() {
		return nuevaReferencia;
	}

	public void setNuevaReferencia(Referencias nuevaReferencia) {
		this.nuevaReferencia = nuevaReferencia;
	}

	public Referencias getReferenciaAModificar() {
		return referenciaAModificar;
	}

	public void setReferenciaAModificar(Referencias referenciaAModificar) {
		this.referenciaAModificar = referenciaAModificar;
	}

	public int getIdReferenciaAEliminar() {
		return idReferenciaAEliminar;
	}

	public void setIdReferenciaAEliminar(int idReferenciaAEliminar) {
		this.idReferenciaAEliminar = idReferenciaAEliminar;
	}

	public int getIdReferenciaABuscar() {
		return idReferenciaABuscar;
	}

	public void setIdReferenciaABuscar(int idReferenciaABuscar) {
		this.idReferenciaABuscar = idReferenciaABuscar;
	}


	
}
