package com.edu.ubosque.dao;

import java.util.List;

import com.edu.ubosque.model.ExperienciaLaboral;

/**
 * Interfaz dao de la experiencia laboral
 * @author Nicol�s �vila, Sebasti�n Moncaleano, Diego Torres | Universidad El Bosque
 *
 */
public interface IExpLaboralDAO {
	
	/**
	 * Metodo que guarda la info de la exp laboral en la base de datos
	 * @param crearExplaboral Objeto de la exp a guardar
	 * @return true s� la guardo, false si ocurrio alg�n error 
	 */
	boolean createExperienciaLaboral(ExperienciaLaboral crearExpLaboral);
	
	List<ExperienciaLaboral> readExperienciaLaboral(int idExpLaboral);
	
	/**
	 * Metodo qe modifica la exp laboral
	 * @param ExpLaboralAModificar Objeto de la exp laboral a modificar
	 * @return true s� la modific�, false s� ocurrio alg�n error
	 */
	boolean updateExperienciaLaboral(ExperienciaLaboral modificarExpLaboral);
	
	/**
	 * Metodo que elimina una exp laboral
	 * @param idExpLaboral id de la exp laboral
	 * @param ciudadanoRelacionado Ciudadano relacionado a la exp laboral
	 * @return true s� la elimin�, false si ucurrio alg�n error
	 */
	boolean deleteExperienciaLaboral(ExperienciaLaboral deleteExpLaboral);
	
	/**
	 * Metodo que busca la exp laboral por la id
	 * @param idExperienciaLaboral ide la exp laboral
	 * @return Objeto de la exp laboral
	 */
	ExperienciaLaboral buscarExperienciaLaboral(int idExpLaboral);

}
