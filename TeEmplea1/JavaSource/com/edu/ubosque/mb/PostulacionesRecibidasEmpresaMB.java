package com.edu.ubosque.mb;

import java.util.List;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import com.edu.ubosque.logica.PostulacionLaboralLogica;
import com.edu.ubosque.model.Empresa;
import com.edu.ubosque.model.PostulacionLaboral;

public class PostulacionesRecibidasEmpresaMB {

	private Empresa empresa;
	private HttpSession session;
	private PostulacionLaboralLogica postulacionLaboralLogica;
	private List<PostulacionLaboral> listaPostulacionesRecibidas;
	private List<PostulacionLaboral> listaPostulacionesFiltradas;
	

	private PostulacionLaboral postulacionRecibida;
	
	public PostulacionesRecibidasEmpresaMB() {
		session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		empresa = (Empresa) session.getAttribute("empresaLogueada");
		postulacionLaboralLogica = new PostulacionLaboralLogica();
		inicializarLista();
	}
	
	private void inicializarLista()
	{
		listaPostulacionesRecibidas = postulacionLaboralLogica.buscarPostulacionesPorCiudadanoOEmpresa(empresa.getIdempresa(),2);
		
		for(int i=0;i<listaPostulacionesRecibidas.size();i++)
		{
			System.out.println(listaPostulacionesRecibidas.get(i).getCiudadano().getPrimerNombre());
		}
	}

	public List<PostulacionLaboral> getListaPostulacionesRecibidas() {
		return listaPostulacionesRecibidas;
	}

	public void setListaPostulacionesRecibidas(List<PostulacionLaboral> listaPostulacionesRecibidas) {
		this.listaPostulacionesRecibidas = listaPostulacionesRecibidas;
	}

	public List<PostulacionLaboral> getListaPostulacionesFiltradas() {
		return listaPostulacionesFiltradas;
	}

	public void setListaPostulacionesFiltradas(List<PostulacionLaboral> listaPostulacionesFiltradas) {
		this.listaPostulacionesFiltradas = listaPostulacionesFiltradas;
	}

	public PostulacionLaboral getPostulacionRecibida() {
		return postulacionRecibida;
	}

	public void setPostulacionRecibida(PostulacionLaboral postulacionRecibida) {
		this.postulacionRecibida = postulacionRecibida;
	}

	
}
