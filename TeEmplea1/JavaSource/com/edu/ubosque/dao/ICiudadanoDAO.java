package com.edu.ubosque.dao;

import java.util.List;

import com.edu.ubosque.model.Ciudadano;


public interface ICiudadanoDAO {
	
boolean createCiudadano(Ciudadano ciudadanoACrear);
	
	List<Ciudadano> readCiudadano();
	
	boolean updateCiudadano(Ciudadano ciudadanoAModificar);
	
	boolean deleteCiudadano(Ciudadano ciudadanoAEliminar);
}
