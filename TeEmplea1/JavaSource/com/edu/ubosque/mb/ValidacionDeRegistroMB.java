package com.edu.ubosque.mb;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.primefaces.PrimeFaces;

import com.edu.ubosque.logica.CiudadanoLogica;
import com.edu.ubosque.model.Ciudadano;

public class ValidacionDeRegistroMB {

	private CiudadanoLogica ciudadanoLogica;
	private int id;
	private String usuario;
	private String primerNombre;
	private String segundoNombre;
	private String primerApellido;
	private String segundoApellido;
	private Date fechaNacimiento;
	private String lugarNacimiento;
	private String direccion;
	private String telefono;
	private String estadoCivil;
	private String correoElectronico;
	private String perfilProfesional;
	private double aspiracionLaboral;
	private String horario;
	private String clave;

	
	
	public ValidacionDeRegistroMB() {
		ciudadanoLogica = new CiudadanoLogica();
		
	}

	
	public void registrarCiudadano()
	{
		

			Ciudadano ciudadanoNuevo = new Ciudadano(id,usuario,clave,primerNombre,segundoNombre, primerApellido,
			segundoApellido,fechaNacimiento,lugarNacimiento,direccion,telefono,estadoCivil,correoElectronico,perfilProfesional,aspiracionLaboral,horario); 
			
			boolean registrado = ciudadanoLogica.createCiudadano(ciudadanoNuevo);

			if(registrado)
			{
				System.out.println("Registrado");
			}
			else
			{
				System.out.println("No registrado");
				
			}
	}
	
	public void mensajes()
	{
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuario Registrado!","Inicie sesión con su Usuario y Contraseña"));
	}
	
	public String validarCiudadano()
	{
		
		Ciudadano ciudadanoPorId = ciudadanoLogica.buscarCiudadanoPorId(id);
		Ciudadano ciudadanoPorUsuario = ciudadanoLogica.buscarCiudadanoPorUsuario(usuario);
		
		if(ciudadanoPorUsuario != null)
		{
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "No se puede registrar : ", "el Usuario ya Existe!"));
		}
		else if (ciudadanoPorId!= null)
		{
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "No se puede registrar : ", "ya existe un Usuario con este Número de Documento"));
		}
		else
		{
			ventanaRegistroPersonasDatosAdicionales();
		}
		
		return null;
	}

	
	private void ventanaRegistroPersonasDatosAdicionales()
	 {
		 Map<String, Object> opciones = new HashMap<String,Object>();
		 	opciones.put("modal", true);
		 	opciones.put("resizable", false);
		 	opciones.put("width", 1000);
		 	opciones.put("height", 560);
		 	opciones.put("contentWidth", "100%");
		 	opciones.put("contentHeight", "100%");
		 	opciones.put("headerElement", "customheader");
	      PrimeFaces.current().dialog().openDynamic("registroPersona", opciones, null);
	 }
	

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getUsuario() {
		return usuario;
	}


	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}




	public CiudadanoLogica getCiudadanoLogica() {
		return ciudadanoLogica;
	}




	public void setCiudadanoLogica(CiudadanoLogica ciudadanoLogica) {
		this.ciudadanoLogica = ciudadanoLogica;
	}




	public String getPrimerNombre() {
		return primerNombre;
	}




	public void setPrimerNombre(String primerNombre) {
		this.primerNombre = primerNombre;
	}




	public String getSegundoNombre() {
		return segundoNombre;
	}




	public void setSegundoNombre(String segundoNombre) {
		this.segundoNombre = segundoNombre;
	}




	public String getPrimerApellido() {
		return primerApellido;
	}




	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}




	public String getSegundoApellido() {
		return segundoApellido;
	}




	public void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
	}




	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}




	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}




	public String getLugarNacimiento() {
		return lugarNacimiento;
	}




	public void setLugarNacimiento(String lugarNacimiento) {
		this.lugarNacimiento = lugarNacimiento;
	}




	public String getDireccion() {
		return direccion;
	}




	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}




	public String getTelefono() {
		return telefono;
	}




	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}




	public String getEstadoCivil() {
		return estadoCivil;
	}




	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}




	public String getCorreoElectronico() {
		return correoElectronico;
	}




	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}




	public String getPerfilProfesional() {
		return perfilProfesional;
	}




	public void setPerfilProfesional(String perfilProfesional) {
		this.perfilProfesional = perfilProfesional;
	}




	public double getAspiracionLaboral() {
		return aspiracionLaboral;
	}




	public void setAspiracionLaboral(double aspiracionLaboral) {
		this.aspiracionLaboral = aspiracionLaboral;
	}




	public String getHorario() {
		return horario;
	}




	public void setHorario(String horario) {
		this.horario = horario;
	}


	public String getClave() {
		return clave;
	}


	public void setClave(String clave) {
		this.clave = clave;
	}
	
	
}

