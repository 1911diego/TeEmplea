package com.edu.ubosque.dao;

import java.util.List;

import com.edu.ubosque.model.InformacionAcademica;

/**
 * interfaz dao de los datos academicos
 * @author Nicolás Ávila, Sebastián Moncaleano, Diego Torres | Universidad El Bosque
 *
 */
public interface IDatosAcademicosDAO {

	/**
	 * Metodo que guarda la info academica en la base de datos
	 * @param crearInfoAcademica informacion academica a crear
	 * @return true si se logro guardar, false si ocurrio algun error
	 */
	boolean createInfoAcademica(InformacionAcademica infoAcademicaACrear);
	
	List<InformacionAcademica> readInfoAcademica(int idCiudadano);
	
	/**
	 * Metodo que modifica una info academica
	 * @param DatoAcademicoAModificar info academica a modificar
	 * @return true si logro modificarla, false si ocurrio algun error
	 */
	boolean updateInfoAcademica(InformacionAcademica infoAcademicaAModificar);
	
	/**
	 * Metodo que elimina una info academica
	 * @param idInfoAcademica id de la info academica
	 * @param ciudadanoRelacionado ciudadano relacionado a la info
	 * @return true si logro eliminarla, false si ocurrio algun error
	 */
	boolean deleteInfoAcademica(InformacionAcademica inforAcademicaAEliminar);
	
	/**
	 * Metodo que buscar una info academica por su id
	 * @param idInfoAcademicaBuscada id de la info academica
	 * @return devuelve la info academica encontrada
	 */
	InformacionAcademica buscarInfoAcademicaPorId(int idInfoAcademica);
	
}
