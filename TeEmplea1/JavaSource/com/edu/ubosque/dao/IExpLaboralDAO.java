package com.edu.ubosque.dao;

import java.util.List;

import com.edu.ubosque.model.ExperienciaLaboral;

/**
 * Interfaz dao de la experiencia laboral
 * @author Nicolás Ávila, Sebastián Moncaleano, Diego Torres | Universidad El Bosque
 *
 */
public interface IExpLaboralDAO {
	
	/**
	 * Metodo que guarda la info de la exp laboral en la base de datos
	 * @param crearExplaboral Objeto de la exp a guardar
	 * @return true sí la guardo, false si ocurrio algún error 
	 */
	boolean createExperienciaLaboral(ExperienciaLaboral crearExpLaboral);
	
	List<ExperienciaLaboral> readExperienciaLaboral(int idExpLaboral);
	
	/**
	 * Metodo qe modifica la exp laboral
	 * @param ExpLaboralAModificar Objeto de la exp laboral a modificar
	 * @return true sí la modificó, false sí ocurrio algún error
	 */
	boolean updateExperienciaLaboral(ExperienciaLaboral modificarExpLaboral);
	
	/**
	 * Metodo que elimina una exp laboral
	 * @param idExpLaboral id de la exp laboral
	 * @param ciudadanoRelacionado Ciudadano relacionado a la exp laboral
	 * @return true sí la eliminó, false si ucurrio algún error
	 */
	boolean deleteExperienciaLaboral(ExperienciaLaboral deleteExpLaboral);
	
	/**
	 * Metodo que busca la exp laboral por la id
	 * @param idExperienciaLaboral ide la exp laboral
	 * @return Objeto de la exp laboral
	 */
	ExperienciaLaboral buscarExperienciaLaboral(int idExpLaboral);

}
