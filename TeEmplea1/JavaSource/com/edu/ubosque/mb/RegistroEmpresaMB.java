package com.edu.ubosque.mb;

import java.util.HashMap;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.primefaces.PrimeFaces;

import com.edu.ubosque.logica.EmpresaLogica;
import com.edu.ubosque.model.Empresa;

public class RegistroEmpresaMB {

	private EmpresaLogica empresaLogica;
	private int id;
	private String nombre;
	private String sector;
	private String perfil;
	private String telefono;
	private String correo;
	private String contrasena;
	
	public RegistroEmpresaMB() {
		empresaLogica = new EmpresaLogica();
	}
	
	public void regEmpresa() {
		
		Empresa empresaNueva = new Empresa(id, nombre, perfil, sector, telefono, correo, contrasena);
		
		boolean reg = empresaLogica.createEmpresa(empresaNueva);
		
		if(reg) {
			System.out.println("Empresa registrada");
		} else {
			System.out.println("No se registro la empresa");
		}
		
	}
	
	public String validarEmpresa() {
		
		Empresa empresaId = empresaLogica.empresaPorId(id);
		Empresa empresaNombre = empresaLogica.empresaPorNombre(nombre);
		
		if(empresaId != null) {
			
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "No se puede registrar : ", "ya existe una empresa registrada con ese NIT!"));
			
		} else if(empresaNombre != null) {
			
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "No se puede registrar : ", "la empresa ya Existe!"));
			
		} else {
			
			ventanaRegistroInfoEmpresa();
			
		}
		
		return null;
	}
	
	private void ventanaRegistroInfoEmpresa() {
		
		 Map<String, Object> opciones = new HashMap<String,Object>();
		 	opciones.put("modal", true);
		 	opciones.put("resizable", false);
		 	opciones.put("width", 600);
		 	opciones.put("height", 560);
		 	opciones.put("contentWidth", "100%");
		 	opciones.put("contentHeight", "100%");
		 	opciones.put("headerElement", "customheader");
	      PrimeFaces.current().dialog().openDynamic("regInfoEmpresa", opciones, null);
		
	}

	public EmpresaLogica getEmpresaLogica() {
		return empresaLogica;
	}

	public void setEmpresaLogica(EmpresaLogica empresaLogica) {
		this.empresaLogica = empresaLogica;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getSector() {
		return sector;
	}

	public void setSector(String sector) {
		this.sector = sector;
	}

	public String getPerfil() {
		return perfil;
	}

	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

}