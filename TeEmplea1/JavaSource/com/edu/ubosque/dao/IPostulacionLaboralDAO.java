package com.edu.ubosque.dao;

import java.util.List;


import com.edu.ubosque.model.PostulacionLaboral;

/**
 * Interfaz dao de la postulacion laboral
 * @author Nicolás Ávila, Sebastián Moncaleano, Diego Torres | Universidad El Bosque
 *
 */
public interface IPostulacionLaboralDAO {

	/**
	 * Metodo que crea una postulacion laboral
	 * @param postulacionLaboralACrear Objeto de la postulacion laboral
	 * @param idOferta id de la oferta laboral
	 * @return true sí la creó, false sí ocurri algun error
	 */
	boolean createPostulacionLaboral(PostulacionLaboral crearPostulacionLaboral);
	
	List<PostulacionLaboral> readPostulacionLaboral(int idPostulacionLaboral);
	
	/**
	 * Metodo que modifica una postulacion laboral
	 * @param postulacionLaboralAModificar Objeto de postulacion laboral a modificar
	 * @return true si la modifico, false si ocurrio algun error
	 */
	boolean updatePostulacionLaboral(PostulacionLaboral modificarPostulacionLaboral);
	
	/**
	 * Metodo que elimina un postulacion laboral
	 * @param postulacionAEliminar Objeto de postulacion laboral a eliminar
	 * @return true si la elimino, false si ocurrio algun error
	 */
	boolean deletePostulacionLaboral(PostulacionLaboral eliminarPostulacionLaboral);
	
	PostulacionLaboral buscarPostulacionLaboralPorId(int idOferta,int idCiudadano, int opcion);
	
	/**
	 * Metodo que busca una postulacion por ciudadano o empresa
	 * @param id id de la postulacion
	 * @param opcion opcion de busqueda
	 * @return Objeto de la postulacion laboral
	 */
	List<PostulacionLaboral> buscarPostulacionLaboralPorCiudadanoOEmpresa(int idCiudadano, int opcion);
	
}
