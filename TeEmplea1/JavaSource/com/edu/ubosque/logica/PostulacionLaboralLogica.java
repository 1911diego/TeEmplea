package com.edu.ubosque.logica;

import java.util.ArrayList;
import java.util.List;

import com.edu.ubosque.dao.IPostulacionLaboralDAO;
import com.edu.ubosque.dao.impl.PostulacionLaboralDAOHibernate;
import com.edu.ubosque.model.Ciudadano;
import com.edu.ubosque.model.OfertaLaboral;
import com.edu.ubosque.model.PostulacionLaboral;

public class PostulacionLaboralLogica {

	private IPostulacionLaboralDAO dao;
	
	public PostulacionLaboralLogica() {
		dao = new PostulacionLaboralDAOHibernate();
	}
	
public boolean createPostulacionLaboral(PostulacionLaboral postulacionLaboralACrear, int idOferta) {
		
	PostulacionLaboral postulacionBuscada = dao.buscarPostulacionLaboralPorId(idOferta, 2);
	
	if(postulacionBuscada == null)
	{
		dao.createPostulacionLaboral(postulacionLaboralACrear);
		return true;
	}
		else
		{
			return false;
		}
	}
	
	public List<OfertaLaboral> readPostulacionLaboral(){
		
		return null;
		
	}
	
	public boolean updatePostulacionLaboral(PostulacionLaboral postulacionLaboralAModificar) {
		
		return dao.updatePostulacionLaboral(postulacionLaboralAModificar);
		
	}
	
	
	public boolean deletePostulacionLaboral(PostulacionLaboral postulacionAEliminar)
	{
			return dao.deletePostulacionLaboral(postulacionAEliminar);
	}
	
	
	public List<PostulacionLaboral> buscarPostulacionesPorCiudadanoOEmpresa(int id, int opcion)
	{
		return dao.buscarPostulacionLaboralPorCiudadanoOEmpresa(id,opcion);
	}

}
