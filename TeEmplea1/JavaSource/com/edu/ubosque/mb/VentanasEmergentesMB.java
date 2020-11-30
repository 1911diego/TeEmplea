package com.edu.ubosque.mb;

import java.util.HashMap;
import java.util.Map;

import javax.faces.application.FacesMessage;

import org.primefaces.PrimeFaces;
	
/**
 * clase manage bean de las ventanas emergentes
 * @author Nicolás Ávila, Sebastián Moncaleano, Diego Torres | Universidad El Bosque
 *
 */
public class VentanasEmergentesMB {

	/**
	 * Metodo constructor de VentanasEmergentesMB
	 */
	public VentanasEmergentesMB() {
		// TODO Auto-generated constructor stub
	}
	
	 /**
	 * Ventana de registro
	 */
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
	 
	 /**
	 * Ventana de registro de personas
	 */
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
	 
	 /**
	 * Ventana para agregar info academica
	 */
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
	 
	 /**
	 * Ventana para agregar experiencia laboral
	 */
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
	 
	 /**
	 * Ventana para agregar referencias
	 */
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
	 
	 /**
	 * Ventana para editar info academica
	 */
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
	 
	 /**
	 * Ventana de registro de empresa
	 */
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
	 
	 /**
	 * Ventana para agregar ofertas laborales
	 */
	public void ventanaAgregarOferta() 
	 {
		 Map<String, Object> opciones = new HashMap<String, Object>();
		 opciones.put("modal", true);
		 opciones.put("resizable", false);
		 opciones.put("width", 650);
		 opciones.put("height", 400);
		 opciones.put("contentWidth", "100%");
		 opciones.put("contentHeight", "100%");
		 opciones.put("headerElement", "customheader");
		 PrimeFaces.current().dialog().openDynamic("agregarOferta", opciones, null);
	 }
	 
	 /**
	 * Ventana para los detalles de las ofertas laborales
	 */
	public void ventanaDetallesOfertaLaboral() 
	 {
		 Map<String, Object> opciones = new HashMap<String, Object>();
		 opciones.put("modal", true);
		 opciones.put("resizable", false);
		 opciones.put("width", 400);
		 opciones.put("height",450);
		 opciones.put("contentWidth", "100%");
		 opciones.put("contentHeight", "100%");
		 opciones.put("headerElement", "customheader");
		 PrimeFaces.current().dialog().openDynamic("detallesOfertaLaboral", opciones, null);
	 }

	 /**
	 * Ventana de los detalles de postulacion del ciudadano
	 */
	public void ventanaDetallesPostulacionCiudadano()
	 {
		 Map<String, Object> opciones = new HashMap<String, Object>();
		 opciones.put("modal", true);
		 opciones.put("resizable", true);
		 opciones.put("width", 500);
		 opciones.put("height", 300);
		 opciones.put("contentWidth", "100%");
		 opciones.put("contentHeight", "100%");
		 opciones.put("headerElement", "customheader");
		 PrimeFaces.current().dialog().openDynamic("detallesPostulacion", opciones, null);
		
	 }
	 
	 
}
