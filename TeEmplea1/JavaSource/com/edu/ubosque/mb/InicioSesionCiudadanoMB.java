package com.edu.ubosque.mb;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.primefaces.PrimeFaces;
import org.primefaces.event.SelectEvent;

import com.edu.ubosque.logica.CiudadanoLogica;
import com.edu.ubosque.logica.DatosAcademicosLogica;
import com.edu.ubosque.model.Ciudadano;
import com.edu.ubosque.model.InformacionAcademica;


public class InicioSesionCiudadanoMB {

	private String usuario;
	private String clave;
	private Ciudadano ciudadanoSesion;
	private CiudadanoLogica ciudadanoLogica;
	private DatosAcademicosLogica datosAcademicosLogica;
	private List<InformacionAcademica>  informacionAcademica;
	
	private InformacionAcademica nuevaInformacionAcademica;
	private InformacionAcademica informacionAcademicaAModificar;
	
	private int idInfoAcademicaAEliminar;
	private int idInfoAcademicaABuscar;
	
	
	
	public InicioSesionCiudadanoMB() {
		ciudadanoLogica = new CiudadanoLogica();
		datosAcademicosLogica = new DatosAcademicosLogica();
		nuevaInformacionAcademica = new InformacionAcademica();

	}

	
	public String validarInicioSesion()
	{
		ciudadanoSesion = ciudadanoLogica.validarUsuarioClave(usuario, clave);
		
		if(ciudadanoSesion!= null)
		{
			System.out.println("si");
			informacionAcademica = new ArrayList<InformacionAcademica>(ciudadanoSesion.getInformacionAcademicas());
			
			return "/sesion/sesionCiudadano";
		}
		else
		{
			System.out.println("no");
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "No se puede Iniciar Sesi�n","Usuario y/o Contrase�a incorrectas"));
			return null;
		}
		
	}

	
	
	public void agregarInformacionAcademica()
	{
		
		nuevaInformacionAcademica.setCiudadano(ciudadanoSesion);
		
		boolean resultado = datosAcademicosLogica.createDatoAcademico(nuevaInformacionAcademica);
		ciudadanoSesion = ciudadanoLogica.buscarCiudadanoPorId(ciudadanoSesion.getId());
		informacionAcademica = new ArrayList<InformacionAcademica>(ciudadanoSesion.getInformacionAcademicas());
		
		PrimeFaces.current().dialog().closeDynamic(nuevaInformacionAcademica);
		
	}
	
	public void eliminarInformacionAcademica()
	{	
		datosAcademicosLogica.deleteInfoAcademica(idInfoAcademicaAEliminar,ciudadanoSesion);
		ciudadanoSesion = ciudadanoLogica.buscarCiudadanoPorId(ciudadanoSesion.getId());
		informacionAcademica = new ArrayList<InformacionAcademica>(ciudadanoSesion.getInformacionAcademicas());
		  FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Proceso �xitoso","Informaci�n Acad�mica Eliminada"); 
	        FacesContext.getCurrentInstance().addMessage(null, message);
	}
	
	
	
	 public void mensajeInfoAgregada(SelectEvent event) {
	        InformacionAcademica info = (InformacionAcademica) event.getObject();
	        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Informaci�n Acad�mica Agregada",info.getInstitucion());
	         
	        FacesContext.getCurrentInstance().addMessage(null, message);
	 }
	 
	 
	 public void asignarInfoAcademicaAEditar()
	 {
		 informacionAcademicaAModificar = datosAcademicosLogica.buscarInfoAcademicaPorId(idInfoAcademicaABuscar);
		 
	 }
	 
	 public void editarInfoAcademica()
	 {
		 datosAcademicosLogica.updateInfoAcademica(informacionAcademicaAModificar);
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


	public Ciudadano getCiudadanoSesion() {
		return ciudadanoSesion;
	}


	public void setCiudadanoSesion(Ciudadano ciudadanoSesion) {
		this.ciudadanoSesion = ciudadanoSesion;
	}


	public List<InformacionAcademica> getInformacionAcademica() {
		return informacionAcademica;
	}


	public void setInformacionAcademica(List<InformacionAcademica> informacionAcademica) {
		this.informacionAcademica = informacionAcademica;
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
		informacionAcademicaAModificar = informacionAcademicaAModificar;
	}


	public int getIdInfoAcademicaAEliminar() {
		return idInfoAcademicaAEliminar;
	}


	public void setIdInfoAcademicaAEliminar(int idInfoAcademicaAEliminar) {
		this.idInfoAcademicaAEliminar = idInfoAcademicaAEliminar;
	}


	

	
	
	
	
}
