package com.edu.ubosque.logica;

import java.util.ArrayList;
import java.util.List;

import com.edu.ubosque.dao.IExpLaboralDAO;
import com.edu.ubosque.dao.impl.ExperienciaLaboralDAOHibernate;
import com.edu.ubosque.model.Ciudadano;
import com.edu.ubosque.model.ExperienciaLaboral;
import com.edu.ubosque.model.InformacionAcademica;

public class ExperienciaLaboralLogica {

	private IExpLaboralDAO dao;
	
	public ExperienciaLaboralLogica()
	{
		dao = new ExperienciaLaboralDAOHibernate();
	}
	
	public boolean createExperienciaLaboral(ExperienciaLaboral crearExplaboral)
	{
		boolean resultado = dao.createExperienciaLaboral(crearExplaboral);
		
		return resultado;
	}
	
	public List<ExperienciaLaboral> readExperienciaLaboral()
	{
		return null;
	}
	
	
	public boolean updateExperienciaLaboral(ExperienciaLaboral ExpLaboralAModificar)
	{
		boolean resultado = dao.updateExperienciaLaboral(ExpLaboralAModificar);
		return resultado;
	}
	
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
	
	public ExperienciaLaboral buscarInfoAcademicaPorId(int idExperienciaLaboral)
	{
		ExperienciaLaboral expLaboralBuscada = dao.buscarExperienciaLaboral(idExperienciaLaboral);
		return expLaboralBuscada;
	}

}
