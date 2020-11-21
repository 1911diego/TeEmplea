package com.edu.ubosque.mb;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.primefaces.PrimeFaces;
import org.primefaces.event.SelectEvent;

import com.edu.ubosque.logica.CiudadanoLogica;
import com.edu.ubosque.logica.DatosAcademicosLogica;
import com.edu.ubosque.model.Ciudadano;
import com.edu.ubosque.model.InformacionAcademica;

public class InformacionAcademicaMB {

	private Ciudadano ciudadano;
	private HttpSession session;
	private List<InformacionAcademica>  listaInformacionAcademica;
	private CiudadanoLogica ciudadanoLogica;
	private DatosAcademicosLogica datosAcademicosLogica;
	
	private InformacionAcademica nuevaInformacionAcademica;
	private InformacionAcademica informacionAcademicaAModificar;
	
	private int idInfoAcademicaAEliminar;
	private int idInfoAcademicaABuscar;
	
	public InformacionAcademicaMB() {
		
		session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		ciudadano = (Ciudadano) session.getAttribute("ciudadanoLogeado");
		listaInformacionAcademica = new ArrayList<InformacionAcademica>(ciudadano.getInformacionAcademicas());
		datosAcademicosLogica = new DatosAcademicosLogica();
		nuevaInformacionAcademica = new InformacionAcademica();
		ciudadanoLogica = new CiudadanoLogica();
	}
	
	
	public void agregarInformacionAcademica()
	{
		nuevaInformacionAcademica.setCiudadano(ciudadano);
		datosAcademicosLogica.createDatoAcademico(nuevaInformacionAcademica);
		ciudadano = ciudadanoLogica.buscarCiudadanoPorId(ciudadano.getId());
		listaInformacionAcademica = new ArrayList<InformacionAcademica>(ciudadano.getInformacionAcademicas());
		
		PrimeFaces.current().dialog().closeDynamic(nuevaInformacionAcademica);
		
	}
	
	public void eliminarInformacionAcademica()
	{	
		datosAcademicosLogica.deleteInfoAcademica(idInfoAcademicaAEliminar,ciudadano);
		ciudadano = ciudadanoLogica.buscarCiudadanoPorId(ciudadano.getId());
		listaInformacionAcademica = new ArrayList<InformacionAcademica>(ciudadano.getInformacionAcademicas());
		  FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Proceso Éxitoso","Información Académica Eliminada"); 
	        FacesContext.getCurrentInstance().addMessage(null, message);
	}
	
	
	
	 public void mensajeInfoAgregada(SelectEvent event) {
	        InformacionAcademica info = (InformacionAcademica) event.getObject();
	        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Información Académica Agregada",info.getInstitucion()); 
	        FacesContext.getCurrentInstance().addMessage(null, message);
	 }
	 
	 
	 public void asignarInfoAcademicaAEditar()
	 {
		 informacionAcademicaAModificar = datosAcademicosLogica.buscarInfoAcademicaPorId(idInfoAcademicaABuscar);
		 System.out.println(informacionAcademicaAModificar.getId());
	 }
	 
	 public void editarInfoAcademica()
	 {
		 datosAcademicosLogica.updateInfoAcademica(informacionAcademicaAModificar);
	 }
	
	
	public Ciudadano getCiudadano() {
		return ciudadano;
	}
	public void setCiudadano(Ciudadano ciudadano) {
		this.ciudadano = ciudadano;
	}


	public List<InformacionAcademica> getListaInformacionAcademica() {
		return listaInformacionAcademica;
	}


	public void setListaInformacionAcademica(List<InformacionAcademica> listaInformacionAcademica) {
		this.listaInformacionAcademica = listaInformacionAcademica;
	}


	public InformacionAcademica getNuevaInformacionAcademica() {
		return nuevaInformacionAcademica;
	}


	public void setNuevaInformacionAcademica(InformacionAcademica nuevaInformacionAcademica) {
		this.nuevaInformacionAcademica = nuevaInformacionAcademica;
	}


	public InformacionAcademica getInformacionAcademicaAModificar() {
		return informacionAcademicaAModificar;
	}


	public void setInformacionAcademicaAModificar(InformacionAcademica informacionAcademicaAModificar) {
		this.informacionAcademicaAModificar = informacionAcademicaAModificar;
	}


	public int getIdInfoAcademicaAEliminar() {
		return idInfoAcademicaAEliminar;
	}


	public void setIdInfoAcademicaAEliminar(int idInfoAcademicaAEliminar) {
		this.idInfoAcademicaAEliminar = idInfoAcademicaAEliminar;
	}


	public int getIdInfoAcademicaABuscar() {
		return idInfoAcademicaABuscar;
	}


	public void setIdInfoAcademicaABuscar(int idInfoAcademicaABuscar) {
		this.idInfoAcademicaABuscar = idInfoAcademicaABuscar;
	}

	
	
}
