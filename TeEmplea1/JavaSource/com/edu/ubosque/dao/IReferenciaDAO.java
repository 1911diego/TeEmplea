package com.edu.ubosque.dao;

import java.util.List;

import com.edu.ubosque.model.ExperienciaLaboral;
import com.edu.ubosque.model.Referencias;

/**
 * Interfaz dao de las referencias
 * @author Nicolás Ávila, Sebastián Moncaleano, Diego Torres | Universidad El Bosque
 *
 */
public interface IReferenciaDAO {

	/**
	 * Metodo que crea una nueva referencia
	 * @param crearReferencia Objeto de referencia a crear
	 * @return true si la creo, false si ocurrio algun error
	 */
	boolean createReferencia(Referencias crearReferencia);
	
	List<Referencias> readReferencia(int idReferencia);
	
	/**
	 * Metodo que modifica un referencia
	 * @param referenciaAModificar objeto de referencia a modificar
	 * @return true si la modifico, false si ocurrio algun error
	 */
	boolean updateReferencia(Referencias modificarReferencias);
	
	/**
	 * Metodo que elimina una referencia
	 * @param idReferencia id de la referencia
	 * @param ciudadanoRelacionado Ciudadano relacionado a la referencia
	 * @return true si la elimino, false si ocurrio algun error
	 */
	boolean deleteReferencia(Referencias deleteReferencias);
	
	/**
	 * Metodo que buscar una referencia por la id
	 * @param idReferencia id de la referencia
	 * @return objeto de la referencia encontrada
	 */
	Referencias buscarReferencia(int idReferencia);
}
