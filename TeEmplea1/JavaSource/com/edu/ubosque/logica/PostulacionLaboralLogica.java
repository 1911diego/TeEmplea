package com.edu.ubosque.logica;

import java.util.ArrayList;
import java.util.List;

import com.edu.ubosque.dao.IPostulacionLaboralDAO;
import com.edu.ubosque.dao.impl.PostulacionLaboralDAOHibernate;
import com.edu.ubosque.model.Ciudadano;
import com.edu.ubosque.model.OfertaLaboral;
import com.edu.ubosque.model.PostulacionLaboral;

/**
 * Clase logica de la postulacion laboral
 * @author Nicolás Ávila, Sebastián Moncaleano, Diego Torres | Universidad El Bosque
 *
 */
public class PostulacionLaboralLogica {

	private IPostulacionLaboralDAO dao;
	
	/**
	 * Metodo contructor de PostulacionLaboralLogica
	 */
	public PostulacionLaboralLogica() {
		dao = new PostulacionLaboralDAOHibernate();
	}
	
	/**
	 * Metodo que crea una postulacion laboral
	 * @param postulacionLaboralACrear Objeto de la postulacion laboral
	 * @param idOferta id de la oferta laboral
	 * @return true sí la creó, false sí ocurri algun error
	 */
	public boolean createPostulacionLaboral(PostulacionLaboral postulacionLaboralACrear, int idOferta) {
			
		PostulacionLaboral postulacionBuscada = dao.buscarPostulacionLaboralPorId(idOferta,postulacionLaboralACrear.getCiudadano().getId(), 2);
		
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
	
	/**
	 * Metodo que modifica una postulacion laboral
	 * @param postulacionLaboralAModificar Objeto de postulacion laboral a modificar
	 * @return true si la modifico, false si ocurrio algun error
	 */
	public boolean updatePostulacionLaboral(PostulacionLaboral postulacionLaboralAModificar) {
		
		return dao.updatePostulacionLaboral(postulacionLaboralAModificar);
		
	}
	
	
	/**
	 * Metodo que elimina un postulacion laboral
	 * @param postulacionAEliminar Objeto de postulacion laboral a eliminar
	 * @return true si la elimino, false si ocurrio algun error
	 */
	public boolean deletePostulacionLaboral(PostulacionLaboral postulacionAEliminar)
	{
			return dao.deletePostulacionLaboral(postulacionAEliminar);
	}
	
	
	/**
	 * Metodo que busca una postulacion por ciudadano o empresa
	 * @param id id de la postulacion
	 * @param opcion opcion de busqueda
	 * @return Objeto de la postulacion laboral
	 */
	public List<PostulacionLaboral> buscarPostulacionesPorCiudadanoOEmpresa(int id, int opcion)
	{
		return dao.buscarPostulacionLaboralPorCiudadanoOEmpresa(id,opcion);
	}

}
