package com.edu.ubosque.dao;

import java.util.List;

import com.edu.ubosque.model.ExperienciaLaboral;
import com.edu.ubosque.model.Referencias;

public interface IReferenciaDAO {

	boolean createReferencia(Referencias crearReferencia);
	
	List<Referencias> readReferencia(int idReferencia);
	
	boolean updateReferencia(Referencias modificarReferencias);
	
	boolean deleteReferencia(Referencias deleteReferencias);
	
	Referencias buscarReferencia(int idReferencia);
}
