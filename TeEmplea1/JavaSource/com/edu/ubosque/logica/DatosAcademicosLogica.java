package com.edu.ubosque.logica;

import java.util.List;

import com.edu.ubosque.dao.IDatosAcademicosDAO;
import com.edu.ubosque.dao.impl.DatosAcademicosDAOHibernate;
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
	
	public boolean deleteSector(InformacionAcademica datoAcademicoAEliminar)
	{
		boolean resultado = dao.deleteInfoAcademica(datoAcademicoAEliminar);
		return resultado;
	}

}
