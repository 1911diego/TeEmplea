package com.edu.ubosque.logica;

import java.util.List;
import java.util.ResourceBundle;

import com.edu.ubosque.dao.ICiudadanoDAO;
import com.edu.ubosque.dao.impl.CiudadanoDAOHibernate;
import com.edu.ubosque.model.Ciudadano;

public class CiudadanoLogica {

	private ICiudadanoDAO dao;
	private ResourceBundle rs;
	
	public CiudadanoLogica() {
		
		dao = new CiudadanoDAOHibernate();
		
	}

	
	public boolean createSector(Ciudadano ciudadanoACrear)
	{
		boolean resultado = dao.createCiudadano(ciudadanoACrear);
		
		return resultado;
	}
	
	public List<Ciudadano> readCiudadano()
	{
		return dao.readCiudadano();
	}
	
	public boolean updateCiudadano(Ciudadano ciudadanoAModificar)
	{
		boolean resultado = dao.updateCiudadano(ciudadanoAModificar);
		return resultado;
	}
	
	public boolean deleteSector(Ciudadano ciudadanoAEliminar)
	{
		boolean resultado = dao.deleteCiudadano(ciudadanoAEliminar);
		return resultado;
	}
	
}
