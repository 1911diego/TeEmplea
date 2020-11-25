package com.edu.ubosque.mb;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.primefaces.PrimeFaces;
import org.primefaces.event.SelectEvent;

import com.edu.ubosque.logica.CiudadanoLogica;
import com.edu.ubosque.logica.ExperienciaLaboralLogica;
import com.edu.ubosque.model.Ciudadano;
import com.edu.ubosque.model.ExperienciaLaboral;

public class ExperienciaLaboralMB {

	private Ciudadano ciudadano;
	private HttpSession session;
	private List<ExperienciaLaboral>  listaExperienciaLaboral;
	private CiudadanoLogica ciudadanoLogica;
	private ExperienciaLaboralLogica expLaboralLogica;
	
	private ExperienciaLaboral nuevaExperienciaLaboral;
	private ExperienciaLaboral experienciaLaboralaAModificar;
	
	private int idExpLaboralAEliminar;
	private int idExpLaboralABuscar;
	
	public ExperienciaLaboralMB() {	
		
		session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		ciudadano = (Ciudadano) session.getAttribute("ciudadanoLogeado");
		expLaboralLogica = new ExperienciaLaboralLogica();
		nuevaExperienciaLaboral = new ExperienciaLaboral();
		ciudadanoLogica = new CiudadanoLogica();
		inicializarLista();
	}
	
	private void inicializarLista()
	{
		ciudadano = ciudadanoLogica.buscarCiudadanoPorId(ciudadano.getId());
		listaExperienciaLaboral = new ArrayList<ExperienciaLaboral>(ciudadano.getExperienciaLaborals());
	}
	
	
	public void agregarExperienciaLaboral()
	{
		nuevaExperienciaLaboral.setCiudadano(ciudadano);
		expLaboralLogica.createExperienciaLaboral(nuevaExperienciaLaboral);
		ciudadano = ciudadanoLogica.buscarCiudadanoPorId(ciudadano.getId());
		listaExperienciaLaboral = new ArrayList<ExperienciaLaboral>(ciudadano.getExperienciaLaborals());
		PrimeFaces.current().dialog().closeDynamic(nuevaExperienciaLaboral);
		nuevaExperienciaLaboral = new ExperienciaLaboral();
	}
	
	public void eliminarExperienciaLaboral()
	{	
		expLaboralLogica.deleteExperienciaLaboral(idExpLaboralAEliminar,ciudadano);
		ciudadano = ciudadanoLogica.buscarCiudadanoPorId(ciudadano.getId());
		listaExperienciaLaboral = new ArrayList<ExperienciaLaboral>(ciudadano.getExperienciaLaborals());
		  FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Proceso Éxitoso","Experiencia Laboral Eliminada"); 
	        FacesContext.getCurrentInstance().addMessage(null, message);
	}
	
	
	
	 public void mensajeExpAgregada(SelectEvent event) {
	        ExperienciaLaboral info = (ExperienciaLaboral) event.getObject();
	        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Experiencia Laboral Agregada",info.getEmpresa()); 
	        FacesContext.getCurrentInstance().addMessage(null, message);
	 }
	 
	 
	 public void asignarExperienciaLaboralAEditar()
	 {
		 experienciaLaboralaAModificar = expLaboralLogica.buscarInfoAcademicaPorId(idExpLaboralABuscar);
		 System.out.println(experienciaLaboralaAModificar.getId());
	 }
	 
	 public void editarInfoAcademica()
	 {
		 expLaboralLogica.updateExperienciaLaboral(experienciaLaboralaAModificar);
	 }

	public List<ExperienciaLaboral> getListaExperienciaLaboral() {
		return listaExperienciaLaboral;
	}

	public void setListaExperienciaLaboral(List<ExperienciaLaboral> listaExperienciaLaboral) {
		this.listaExperienciaLaboral = listaExperienciaLaboral;
	}

	public CiudadanoLogica getCiudadanoLogica() {
		return ciudadanoLogica;
	}

	public void setCiudadanoLogica(CiudadanoLogica ciudadanoLogica) {
		this.ciudadanoLogica = ciudadanoLogica;
	}

	public ExperienciaLaboralLogica getExpLaboralLogica() {
		return expLaboralLogica;
	}

	public void setExpLaboralLogica(ExperienciaLaboralLogica expLaboralLogica) {
		this.expLaboralLogica = expLaboralLogica;
	}

	public ExperienciaLaboral getNuevaExperienciaLaboral() {
		return nuevaExperienciaLaboral;
	}

	public void setNuevaExperienciaLaboral(ExperienciaLaboral nuevaExperienciaLaboral) {
		this.nuevaExperienciaLaboral = nuevaExperienciaLaboral;
	}

	public ExperienciaLaboral getExperienciaLaboralaAModificar() {
		return experienciaLaboralaAModificar;
	}

	public void setExperienciaLaboralaAModificar(ExperienciaLaboral experienciaLaboralaAModificar) {
		this.experienciaLaboralaAModificar = experienciaLaboralaAModificar;
	}

	public int getIdExpLaboralAEliminar() {
		return idExpLaboralAEliminar;
	}

	public void setIdExpLaboralAEliminar(int idExpLaboralAEliminar) {
		this.idExpLaboralAEliminar = idExpLaboralAEliminar;
	}

	public int getIdExpLaboralABuscar() {
		return idExpLaboralABuscar;
	}

	public void setIdExpLaboralABuscar(int idExpLaboralABuscar) {
		this.idExpLaboralABuscar = idExpLaboralABuscar;
	}

	 
	 
}
