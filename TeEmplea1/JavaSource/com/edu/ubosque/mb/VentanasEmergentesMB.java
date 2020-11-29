package com.edu.ubosque.mb;

import java.util.HashMap;
import java.util.Map;

import javax.faces.application.FacesMessage;

import org.primefaces.PrimeFaces;
	
public class VentanasEmergentesMB {

	private String render;
	
	public VentanasEmergentesMB() {
		// TODO Auto-generated constructor stub
	}
	
	 public void ventanaRegistro() {
		 Map<String, Object> opciones = new HashMap<String,Object>();
		 	opciones.put("modal", true);
		 	opciones.put("width", 340);
		 	opciones.put("height", 170);
		 	opciones.put("contentWidth", "100%");
		 	opciones.put("contentHeight", "100%");
		 	opciones.put("headerElement", "customheader");
	      PrimeFaces.current().dialog().openDynamic("registro", opciones, null);
	  }
	 
	 public void ventanaRegistroPersonas()
	 {
		 Map<String, Object> opciones = new HashMap<String,Object>();
		 	opciones.put("modal", true);
		 	opciones.put("resizable", false);
		 	opciones.put("width", 340);
		 	opciones.put("height", 360);
		 	opciones.put("contentWidth", "100%");
		 	opciones.put("contentHeight", "100%");
		 	opciones.put("headerElement", "customheader");
	      PrimeFaces.current().dialog().openDynamic("regPer", opciones, null);
	 }
	 
	 public void ventanaAgregarInfoAcademica()
	 {
		 Map<String, Object> opciones = new HashMap<String,Object>();
		 	opciones.put("modal", true);
		 	opciones.put("resizable", false);
		 	opciones.put("width", 600);
		 	opciones.put("height", 500);
		 	opciones.put("contentWidth", "100%");
		 	opciones.put("contentHeight", "100%");
		 	opciones.put("headerElement", "customheader");
	      PrimeFaces.current().dialog().openDynamic("agregarInfoAcademica", opciones, null);
	 }
	 
	 public void ventanaAgregarExperienciaLaboral()
	 {
		 Map<String, Object> opciones = new HashMap<String,Object>();
		 	opciones.put("modal", true);
		 	opciones.put("resizable", false);
		 	opciones.put("width", 600);
		 	opciones.put("height", 600);
		 	opciones.put("contentWidth", "100%");
		 	opciones.put("contentHeight", "100%");
		 	opciones.put("headerElement", "customheader");
	      PrimeFaces.current().dialog().openDynamic("agregarExperienciaLaboral", opciones, null);
	 }
	 
	 public void ventanaAgregarReferencias()
	 {
		 Map<String, Object> opciones = new HashMap<String,Object>();
		 	opciones.put("modal", true);
		 	opciones.put("resizable", false);
		 	opciones.put("width", 600);
		 	opciones.put("height", 600);
		 	opciones.put("contentWidth", "100%");
		 	opciones.put("contentHeight", "100%");
		 	opciones.put("headerElement", "customheader");
	      PrimeFaces.current().dialog().openDynamic("agregarReferencias", opciones, null);
	 }
	 
	 public void ventanaEditarInfoAcademica()
	 {
		 Map<String, Object> opciones = new HashMap<String,Object>();
		 	opciones.put("modal", true);
		 	opciones.put("resizable", false);
		 	opciones.put("width", 700);
		 	opciones.put("height", 360);
		 	opciones.put("contentWidth", "100%");
		 	opciones.put("contentHeight", "100%");
		 	opciones.put("headerElement", "customheader");
	      PrimeFaces.current().dialog().openDynamic("editarInfoAcademica", opciones, null);
	 }
	 
	 public void registroEmpresa() 
	 {
		 Map<String, Object> opciones = new HashMap<String, Object>();
		 opciones.put("modal", true);
		 opciones.put("resizable", false);
		 opciones.put("width", 340);
		 opciones.put("height", 170);
		 opciones.put("contentWidth", "100%");
		 opciones.put("contentHeight", "100%");
		 opciones.put("headerElement", "customheader");
	     PrimeFaces.current().dialog().openDynamic("registroEmpresa", opciones, null);     
	 }
	 
	 public void ventanaAgregarOferta() 
	 {
		 Map<String, Object> opciones = new HashMap<String, Object>();
		 opciones.put("modal", true);
		 opciones.put("resizable", false);
		 opciones.put("width", 700);
		 opciones.put("height", 600);
		 opciones.put("contentWidth", "100%");
		 opciones.put("contentHeight", "100%");
		 opciones.put("headerElement", "customheader");
		 PrimeFaces.current().dialog().openDynamic("agregarOferta", opciones, null);
	 }
	 
	 public void ventanaDetallesOfertaLaboral() 
	 {
		 Map<String, Object> opciones = new HashMap<String, Object>();
		 opciones.put("modal", true);
		 opciones.put("resizable", false);
		 opciones.put("width", 700);
		 opciones.put("height", 600);
		 opciones.put("contentWidth", "100%");
		 opciones.put("contentHeight", "100%");
		 opciones.put("headerElement", "customheader");
		 PrimeFaces.current().dialog().openDynamic("detallesOfertaLaboral", opciones, null);
	 }

	 public void ventanaDetallesPostulacionCiudadano(String datosVentana)
	 {
		 render = datosVentana;
		 System.out.println(render);
		 Map<String, Object> opciones = new HashMap<String, Object>();
		 opciones.put("modal", true);
		 opciones.put("resizable", false);
		 opciones.put("width", 500);
		 opciones.put("height", 300);
		 opciones.put("contentWidth", "100%");
		 opciones.put("contentHeight", "100%");
		 opciones.put("headerElement", "customheader");
		 PrimeFaces.current().dialog().openDynamic("detallesPostulacion", opciones, null);
	 }
	 
	 
	public String getRender() {
		return render;
	}

	public void setRender(String render) {
		this.render = render;
	}
	 
	 
	 
}
