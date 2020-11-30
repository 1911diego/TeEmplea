package com.edu.ubosque.logica;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.edu.ubosque.dao.ICiudadanoDAO;
import com.edu.ubosque.dao.impl.CiudadanoDAOHibernate;
import com.edu.ubosque.model.Ciudadano;
import com.edu.ubosque.model.InformacionAcademica;

/**
 * Clase logica de ciudadano
 * @author Nicolás Ávila, Sebastián Moncaleano, Diego Torres | Universidad El Bosque
 *
 */
public class CiudadanoLogica {

	private ICiudadanoDAO dao;
	private ResourceBundle rs;
	
	/**
	 * Metodo constructor de CiudadanoLogica
	 */
	public CiudadanoLogica() {
		
		dao = new CiudadanoDAOHibernate();
		
	}

	
	/**
	 * Metodo que crea un ciudadano
	 * @param ciudadanoACrear objeto de ciudadano a crear
	 * @return true si lo creo, false si ocurrio algun error
	 */
	public boolean createCiudadano(Ciudadano ciudadanoACrear)
	{
		boolean resultado = dao.createCiudadano(ciudadanoACrear);
		
		return resultado;
	}
	
	/**
	 * Metodo que lista a los ciudadanos
	 * @return Lista de los ciudadanos
	 */
	public List<Ciudadano> readCiudadano()
	{
		return dao.readCiudadano();
	}
	
	
	/**
	 * Metodo que busca un ciudadano por su id
	 * @param id id del ciudadano
	 * @return objeto del ciudadano encontrado
	 */
	public Ciudadano buscarCiudadanoPorId(int id)
	{
		
		return dao.buscarCiudadanoPorId(id);
	}
	
	/**
	 * Metodo que busca un ciudadano por su usuario
	 * @param usuario el usuario del ciudadano
	 * @return objeto de ciudadano encontrado
	 */
	public Ciudadano buscarCiudadanoPorUsuario(String usuario)
	{
		
		return dao.buscarCiudadanoPorUsuario(usuario);
	}
	
	
	/**
	 * Metodo que modifica un ciudadano
	 * @param ciudadanoAModificar objeto de ciudadano a modificar
	 * @return true si lo modifico, false si ocurrio algun error
	 */
	public boolean updateCiudadano(Ciudadano ciudadanoAModificar)
	{
		boolean resultado = dao.updateCiudadano(ciudadanoAModificar);
		return resultado;
	}
	
	/**
	 * Metodo que elimina un ciudadano
	 * @param ciudadanoAEliminar objeto de ciudadano a eliminar
	 * @return true si lo elimino, false si ocurrio algun error
	 */
	public boolean deleteSector(Ciudadano ciudadanoAEliminar)
	{
		boolean resultado = dao.deleteCiudadano(ciudadanoAEliminar);
		return resultado;
	}
	
	/**
	 * Metodo que valida un ciudadano por su usuario y contraseña
	 * @param usuario el usuario del ciudadano
	 * @param clave contraseña del ciudadano
	 * @return objeto de ciudadano encontrado
	 */
	public Ciudadano validarUsuarioClave(String usuario, String clave)
	{
		Ciudadano ciudadanoEncontrado = buscarCiudadanoPorUsuario(usuario);
		
		if(ciudadanoEncontrado!=null)
		{
			if(ciudadanoEncontrado.getClave().equals(clave))
			{
				return ciudadanoEncontrado;
			}
			else
			{
				return null;
			}
		}
		else
		{
			return null;
		}
		
	}
	

	
	
}
