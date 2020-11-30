package com.edu.ubosque.logica;

import java.util.ArrayList;
import java.util.List;


import com.edu.ubosque.dao.IReferenciaDAO;
import com.edu.ubosque.dao.impl.ReferenciaDAOHibernate;
import com.edu.ubosque.model.Ciudadano;	
import com.edu.ubosque.model.Referencias;

/**
 * Clase logica de las referencias
 * @author Nicolás Ávila, Sebastián Moncaleano, Diego Torres | Universidad El Bosque
 *
 */
public class ReferenciaLogica {
	
	private IReferenciaDAO dao;

	/**
	 * Metodo contructor de ReferenciaLogica
	 */
	public ReferenciaLogica() {
		dao = new ReferenciaDAOHibernate();
	}

	/**
	 * Metodo que crea una nueva referencia
	 * @param crearReferencia Objeto de referencia a crear
	 * @return true si la creo, false si ocurrio algun error
	 */
	public boolean createReferencia(Referencias crearReferencia)
	{
		boolean resultado = dao.createReferencia(crearReferencia);
		
		return resultado;
	}
	
	/**
	 * Metodo que modifica un referencia
	 * @param referenciaAModificar objeto de referencia a modificar
	 * @return true si la modifico, false si ocurrio algun error
	 */
	public boolean updateReferencia(Referencias referenciaAModificar)
	{
		boolean resultado = dao.updateReferencia(referenciaAModificar);
		return resultado;
	}
	
	/**
	 * Metodo que elimina una referencia
	 * @param idReferencia id de la referencia
	 * @param ciudadanoRelacionado Ciudadano relacionado a la referencia
	 * @return true si la elimino, false si ocurrio algun error
	 */
	public boolean deleteReferencia(int idReferencia, Ciudadano ciudadanoRelacionado)
	{
		List<Referencias> listaReferencias = new ArrayList<Referencias> (ciudadanoRelacionado.getReferenciases());
		Referencias referenciaAEliminar = null;
		for(int i=0;i<listaReferencias.size();i++)
		{
			if(listaReferencias.get(i).getId() == idReferencia)
			{
				referenciaAEliminar = listaReferencias.get(i);
			}
		}
		
		boolean resultado = dao.deleteReferencia(referenciaAEliminar);
		
		return resultado;
	}
	
	/**
	 * Metodo que buscar una referencia por la id
	 * @param idReferencia id de la referencia
	 * @return objeto de la referencia encontrada
	 */
	public Referencias buscarReferencia(int idReferencia)
	{
		Referencias expLaboralBuscada = dao.buscarReferencia(idReferencia);
		return expLaboralBuscada;
	}

}
