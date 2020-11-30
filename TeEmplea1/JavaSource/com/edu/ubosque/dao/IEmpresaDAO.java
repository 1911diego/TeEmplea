package com.edu.ubosque.dao;

import java.util.List;

import com.edu.ubosque.model.Empresa;

/**
 * Interfaz dao de empresa
 * @author Nicolás Ávila, Sebastián Moncaleano, Diego Torres | Universidad El Bosque
 *
 */
public interface IEmpresaDAO {
	
	/**
	 * Metodo que almacena la empresa en la base de datos
	 * @param empresaACrear objeto de la empresa a crear
	 * @returntrue sí logro guardar la empresa, false si ocurrio algun error
	 */
	boolean createEmpresa(Empresa empresaACrear);
	
	/**
	 * Metodo que lista las empresa
	 * @return devuelve una lista de las empresa
	 */
	List<Empresa> readEmpresa();
	
	/**
	 * Metodo que modifica una empresa
	 * @param empresaAModificar obejeto de la empresa a modificar
	 * @return true si la modifcó, false sí ocurrio algún error 
	 */
	boolean updateEmpresa(Empresa empresaAModificar);
	
	/**
	 * Metodo que elimina una empresa
	 * @param empresaAEliminar Objeto de la empresa a eliminar
	 * @return true sí la eliminó, false sí ocurrio algun error
	 */
	boolean deleteEmpresa(Empresa empresaAEliminar);
	
	/**
	 * Metodo que busca una empresa por la id
	 * @param id Es el NIT de la empresa
	 * @return Objeto de la empresa encontrada
	 */
	Empresa readEmpresaPorId(int id);
	
	/**
	 * Metodo que busca una empresa por su nombre
	 * @param nombre Es el nombre de la empresa
	 * @return Objeto de la empresa encontrado
	 */
	Empresa readEmpresaPorNombre(String nombre);
	
}
