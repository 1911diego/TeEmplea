package com.edu.ubosque.mb;

import java.util.HashMap;
import java.util.Map;

import javax.faces.application.FacesMessage;

import org.primefaces.PrimeFaces;
	
public class MostrarRegistroMB {

	public MostrarRegistroMB() {
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
		 	opciones.put("width", 1000);
		 	opciones.put("height", 400);
		 	opciones.put("contentWidth", "100%");
		 	opciones.put("contentHeight", "100%");
		 	opciones.put("headerElement", "customheader");
	      PrimeFaces.current().dialog().openDynamic("registroPersona", opciones, null);
	 }
	 
	 public void showMessage() {
		 System.out.println("entra");
	        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "What we do in life", "Echoes in eternity.");
	         
	        PrimeFaces.current().dialog().showMessageDynamic(message);
	    }
	
}
