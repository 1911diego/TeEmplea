package com.edu.ubosque.logica;

import java.util.List;

import com.edu.ubosque.dao.IEmpresaDAO;
import com.edu.ubosque.dao.impl.EmpresaDAOHibernate;
import com.edu.ubosque.model.Empresa;

/**
 * Clase logica de empresa
 * @author Nicolás Ávila, Sebastián Moncaleano, Diego Torres | Universidad El Bosque
 *
 */
public class EmpresaLogica {

	private IEmpresaDAO dao;
	
	/**
	 * Metodo constructo de EmpresaLogica
	 */
	public EmpresaLogica() {
		dao = new EmpresaDAOHibernate();
	}
	
	/**
	 * Metodo que almacena la empresa en la base de datos
	 * @param empresaACrear objeto de la empresa a crear
	 * @returntrue sí logro guardar la empresa, false si ocurrio algun error
	 */
	public boolean createEmpresa(Empresa empresaACrear) {
		
		return dao.createEmpresa(empresaACrear);
		
	}
	
	/**
	 * Metodo que lista las empresa
	 * @return devuelve una lista de las empresa
	 */
	public List<Empresa> readEmpresa() {
		
		return dao.readEmpresa();
		
	}
	
	/**
	 * Metodo que modifica una empresa
	 * @param empresaAModificar obejeto de la empresa a modificar
	 * @return true si la modifcó, false sí ocurrio algún error 
	 */
	public boolean updateEmpresa(Empresa empresaAModificar) {
		
		return dao.updateEmpresa(empresaAModificar);
		
	}
	
	/**
	 * Metodo que elimina una empresa
	 * @param empresaAEliminar Objeto de la empresa a eliminar
	 * @return true sí la eliminó, false sí ocurrio algun error
	 */
	public boolean deleteEmpresa(Empresa empresaAEliminar) {
		
		return dao.deleteEmpresa(empresaAEliminar);
		
	}
	
	/**
	 * Metodo que busca una empresa por la id
	 * @param id Es el NIT de la empresa
	 * @return Objeto de la empresa encontrada
	 */
	public Empresa empresaPorId(int id) {
		
		return dao.readEmpresaPorId(id);
		
	}
	
	/**
	 * Metodo que busca una empresa por su nombre
	 * @param nombre Es el nombre de la empresa
	 * @return Objeto de la empresa encontrado
	 */
	public Empresa empresaPorNombre(String nombre) {
		
		return dao.readEmpresaPorNombre(nombre);
		
	}
	
	/**
	 * Metodo que valida el nombre y la clave del usuario empresa
	 * @param nombre Es el nombre de la empresa
	 * @param contrasena Es la contraseña con la que se registro
	 * @return Objeto de la empresa encontrada
	 */
	public Empresa validarEmpresaClave(String nombre, String contrasena) {
		
		Empresa encontrado = empresaPorNombre(nombre);
		
		if(encontrado != null) {
			
			if(encontrado.getContrasena().equals(contrasena)) {
				
				return encontrado;
			} else {
				
				return null;
			}
		} else {
			
			return null;
		}
		
	}

}
