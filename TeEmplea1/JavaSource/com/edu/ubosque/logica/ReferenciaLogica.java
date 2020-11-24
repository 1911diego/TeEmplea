package com.edu.ubosque.logica;

import java.util.ArrayList;
import java.util.List;


import com.edu.ubosque.dao.IReferenciaDAO;
import com.edu.ubosque.dao.impl.ReferenciaDAOHibernate;
import com.edu.ubosque.model.Ciudadano;	
import com.edu.ubosque.model.Referencias;

public class ReferenciaLogica {
	
	private IReferenciaDAO dao;

	public ReferenciaLogica() {
		dao = new ReferenciaDAOHibernate();
	}

	public boolean createReferencia(Referencias crearReferencia)
	{
		boolean resultado = dao.createReferencia(crearReferencia);
		
		return resultado;
	}
	
	public List<Referencias> readReferencia()
	{
		return null;
	}
	
	
	public boolean updateReferencia(Referencias referenciaAModificar)
	{
		boolean resultado = dao.updateReferencia(referenciaAModificar);
		return resultado;
	}
	
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
	
	public Referencias buscarReferencia(int idReferencia)
	{
		Referencias expLaboralBuscada = dao.buscarReferencia(idReferencia);
		return expLaboralBuscada;
	}

}
