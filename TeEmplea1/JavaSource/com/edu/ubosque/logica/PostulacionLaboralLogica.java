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
	
public boolean createOferta(PostulacionLaboral postulacionLaboralACrear) {
		
		return dao.createPostulacionLaboral(postulacionLaboralACrear);
		
	}
	
	public List<OfertaLaboral> readPostulacionLaboral(){
		
		return null;
		
	}
	
	public boolean updatePostulacionLaboral(PostulacionLaboral postulacionLaboralAModificar) {
		
		return dao.updatePostulacionLaboral(postulacionLaboralAModificar);
		
	}
	
	public boolean deletePostulacionLaboral(int idPostulacionLaboral, Ciudadano ciudadanoRelacionado) {
		
		List<PostulacionLaboral> postulaciones = new ArrayList<PostulacionLaboral>(ciudadanoRelacionado.getPostulacionLaborals());
		PostulacionLaboral postulacionLaboralAEliminar = null;
		
		for (int i = 0; i < postulaciones.size(); i++) {
			
			if(postulaciones.get(i).getId() == idPostulacionLaboral) {
				
				postulacionLaboralAEliminar = postulaciones.get(i);
			}
			
		}
		
		return dao.deletePostulacionLaboral(postulacionLaboralAEliminar);
		
	}

}
