package com.edu.ubosque.logica;

import java.util.ArrayList;
import java.util.List;

import com.edu.ubosque.dao.IExpLaboralDAO;
import com.edu.ubosque.dao.impl.ExperienciaLaboralDAOHibernate;
import com.edu.ubosque.model.Ciudadano;
import com.edu.ubosque.model.ExperienciaLaboral;
import com.edu.ubosque.model.InformacionAcademica;

/**
 * Clase logica de la experiencia laboral
 * @author Nicolás Ávila, Sebastián Moncaleano, Diego Torres | Universidad El Bosque
 *
 */
public class ExperienciaLaboralLogica {

	private IExpLaboralDAO dao;
	
	/**
	 * Metodo contructor de ExperienciaLaboralLogica
	 */
	public ExperienciaLaboralLogica()
	{
		dao = new ExperienciaLaboralDAOHibernate();
	}
	
	/**
	 * Metodo que guarda la info de la exp laboral en la base de datos
	 * @param crearExplaboral Objeto de la exp a guardar
	 * @return true sí la guardo, false si ocurrio algún error 
	 */
	public boolean createExperienciaLaboral(ExperienciaLaboral crearExplaboral)
	{
		boolean resultado = dao.createExperienciaLaboral(crearExplaboral);
		
		return resultado;
	}
	
	
	/**
	 * Metodo qe modifica la exp laboral
	 * @param ExpLaboralAModificar Objeto de la exp laboral a modificar
	 * @return true sí la modificó, false sí ocurrio algún error
	 */
	public boolean updateExperienciaLaboral(ExperienciaLaboral ExpLaboralAModificar)
	{
		boolean resultado = dao.updateExperienciaLaboral(ExpLaboralAModificar);
		return resultado;
	}
	
	/**
	 * Metodo que elimina una exp laboral
	 * @param idExpLaboral id de la exp laboral
	 * @param ciudadanoRelacionado Ciudadano relacionado a la exp laboral
	 * @return true sí la eliminó, false si ucurrio algún error
	 */
	public boolean deleteExperienciaLaboral(int idExpLaboral, Ciudadano ciudadanoRelacionado)
	{
		List<ExperienciaLaboral> listaExpLaboral = new ArrayList<ExperienciaLaboral> (ciudadanoRelacionado.getExperienciaLaborals());
		ExperienciaLaboral expLaboralAEliminar = null;
		for(int i=0;i<listaExpLaboral.size();i++)
		{
			if(listaExpLaboral.get(i).getId() == idExpLaboral)
			{
				expLaboralAEliminar = listaExpLaboral.get(i);
			}
		}
		
		boolean resultado = dao.deleteExperienciaLaboral(expLaboralAEliminar);
		
		return resultado;
	}
	
	/**
	 * Metodo que busca la exp laboral por la id
	 * @param idExperienciaLaboral ide la exp laboral
	 * @return Objeto de la exp laboral
	 */
	public ExperienciaLaboral buscarInfoAcademicaPorId(int idExperienciaLaboral)
	{
		ExperienciaLaboral expLaboralBuscada = dao.buscarExperienciaLaboral(idExperienciaLaboral);
		return expLaboralBuscada;
	}

}
