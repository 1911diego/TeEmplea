package com.edu.ubosque.logica;

import java.util.ArrayList;
import java.util.List;

import com.edu.ubosque.dao.IDatosAcademicosDAO;
import com.edu.ubosque.dao.impl.DatosAcademicosDAOHibernate;
import com.edu.ubosque.model.Ciudadano;
import com.edu.ubosque.model.InformacionAcademica;

/**
 * Clase logica de los datos academicos
 * @author Nicolás Ávila, Sebastián Moncaleano, Diego Torres | Universidad El Bosque
 *
 */
public class DatosAcademicosLogica {

	private IDatosAcademicosDAO dao;
	
	/**
	 * Metodo constructor de la clase DatosAcademicosLogica
	 */
	public DatosAcademicosLogica()
	{
		dao = new DatosAcademicosDAOHibernate();
	}
	
	/**
	 * Metodo que guarda la info academica en la base de datos
	 * @param crearInfoAcademica informacion academica a crear
	 * @return true si se logro guardar, false si ocurrio algun error
	 */
	public boolean createDatoAcademico(InformacionAcademica crearInfoAcademica)
	{
		boolean resultado = dao.createInfoAcademica(crearInfoAcademica);
		
		return resultado;
	}
	
	
	/**
	 * Metodo que modifica una info academica
	 * @param DatoAcademicoAModificar info academica a modificar
	 * @return true si logro modificarla, false si ocurrio algun error
	 */
	public boolean updateInfoAcademica(InformacionAcademica DatoAcademicoAModificar)
	{
		boolean resultado = dao.updateInfoAcademica(DatoAcademicoAModificar);
		return resultado;
	}
	
	/**
	 * Metodo que elimina una info academica
	 * @param idInfoAcademica id de la info academica
	 * @param ciudadanoRelacionado ciudadano relacionado a la info
	 * @return true si logro eliminarla, false si ocurrio algun error
	 */
	public boolean deleteInfoAcademica(int idInfoAcademica, Ciudadano ciudadanoRelacionado)
	{
		List<InformacionAcademica> listaInfoAcademica = new ArrayList<InformacionAcademica>(ciudadanoRelacionado.getInformacionAcademicas());
		InformacionAcademica datoAcademicoAEliminar = null;
		for(int i=0;i<listaInfoAcademica.size();i++)
		{
			if(listaInfoAcademica.get(i).getId() == idInfoAcademica)
			{
				datoAcademicoAEliminar = listaInfoAcademica.get(i);
			}
		}
		
		boolean resultado = dao.deleteInfoAcademica(datoAcademicoAEliminar);
		
		return resultado;
	}
	
	/**
	 * Metodo que buscar una info academica por su id
	 * @param idInfoAcademicaBuscada id de la info academica
	 * @return devuelve la info academica encontrada
	 */
	public InformacionAcademica buscarInfoAcademicaPorId(int idInfoAcademicaBuscada)
	{
		InformacionAcademica infoAcademicaBuscada = dao.buscarInfoAcademicaPorId(idInfoAcademicaBuscada);
		return infoAcademicaBuscada;
	}

}
