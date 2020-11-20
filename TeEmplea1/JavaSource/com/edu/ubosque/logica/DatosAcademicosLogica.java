package com.edu.ubosque.logica;

import java.util.ArrayList;
import java.util.List;

import com.edu.ubosque.dao.IDatosAcademicosDAO;
import com.edu.ubosque.dao.impl.DatosAcademicosDAOHibernate;
import com.edu.ubosque.model.Ciudadano;
import com.edu.ubosque.model.InformacionAcademica;

public class DatosAcademicosLogica {

	private IDatosAcademicosDAO dao;
	
	public DatosAcademicosLogica()
	{
		dao = new DatosAcademicosDAOHibernate();
	}
	
	public boolean createDatoAcademico(InformacionAcademica crearInfoAcademica)
	{
		boolean resultado = dao.createInfoAcademica(crearInfoAcademica);
		
		return resultado;
	}
	
	public List<InformacionAcademica> readInfoAcademica()
	{
		return null;
	}
	
	
	public boolean updateInfoAcademica(InformacionAcademica DatoAcademicoAModificar)
	{
		boolean resultado = dao.updateInfoAcademica(DatoAcademicoAModificar);
		return resultado;
	}
	
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
	
	public InformacionAcademica buscarInfoAcademicaPorId(int idInfoAcademicaBuscada)
	{
		InformacionAcademica infoAcademicaBuscada = dao.buscarInfoAcademicaPorId(idInfoAcademicaBuscada);
		return infoAcademicaBuscada;
	}

}
