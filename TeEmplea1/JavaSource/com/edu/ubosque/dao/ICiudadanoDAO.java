package com.edu.ubosque.dao;

import java.util.List;

import com.edu.ubosque.model.Ciudadano;


/**
 * Interfaz dao del ciudadano
 * @author Nicolás Ávila, Sebastián Moncaleano, Diego Torres | Universidad El Bosque
 *
 */
public interface ICiudadanoDAO {
	
	/**
	 * Metodo que crea un ciudadano
	 * @param ciudadanoACrear objeto de ciudadano a crear
	 * @return true si lo creo, false si ocurrio algun error
	 */
	boolean createCiudadano(Ciudadano ciudadanoACrear);
	
	/**
	 * Metodo que lista a los ciudadanos
	 * @return Lista de los ciudadanos
	 */
	List<Ciudadano> readCiudadano();
	
	/**
	 * Metodo que modifica un ciudadano
	 * @param ciudadanoAModificar objeto de ciudadano a modificar
	 * @return true si lo modifico, false si ocurrio algun error
	 */
	boolean updateCiudadano(Ciudadano ciudadanoAModificar);
	
	/**
	 * Metodo que elimina un ciudadano
	 * @param ciudadanoAEliminar objeto de ciudadano a eliminar
	 * @return true si lo elimino, false si ocurrio algun error
	 */
	boolean deleteCiudadano(Ciudadano ciudadanoAEliminar);
	
	/**
	 * Metodo que busca un ciudadano por su id
	 * @param id id del ciudadano
	 * @return objeto del ciudadano encontrado
	 */
	Ciudadano buscarCiudadanoPorId(int id);
	
	/**
	 * Metodo que busca un ciudadano por su usuario
	 * @param usuario el usuario del ciudadano
	 * @return objeto de ciudadano encontrado
	 */
	Ciudadano buscarCiudadanoPorUsuario(String usuario);
}
