package com.edu.ubosque.logica;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.edu.ubosque.dao.ICiudadanoDAO;
import com.edu.ubosque.dao.impl.CiudadanoDAOHibernate;
import com.edu.ubosque.model.Ciudadano;
import com.edu.ubosque.model.InformacionAcademica;

public class CiudadanoLogica {

	private ICiudadanoDAO dao;
	private ResourceBundle rs;
	
	public CiudadanoLogica() {
		
		dao = new CiudadanoDAOHibernate();
		
	}

	
	public boolean createCiudadano(Ciudadano ciudadanoACrear)
	{
		boolean resultado = dao.createCiudadano(ciudadanoACrear);
		
		return resultado;
	}
	
	public List<Ciudadano> readCiudadano()
	{
		return dao.readCiudadano();
	}
	
	
	public Ciudadano buscarCiudadanoPorId(int id)
	{
		
		return dao.buscarCiudadanoPorId(id);
	}
	
	public Ciudadano buscarCiudadanoPorUsuario(String usuario)
	{
		
		return dao.buscarCiudadanoPorUsuario(usuario);
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
