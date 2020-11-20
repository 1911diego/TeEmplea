package com.edu.ubosque.dao;

import java.util.List;

import com.edu.ubosque.model.InformacionAcademica;

public interface IDatosAcademicosDAO {

	
	boolean createInfoAcademica(InformacionAcademica infoAcademicaACrear);
	
	List<InformacionAcademica> readInfoAcademica(int idCiudadano);
	
	boolean updateInfoAcademica(InformacionAcademica infoAcademicaAModificar);
	
	boolean deleteInfoAcademica(InformacionAcademica inforAcademicaAEliminar);
	
	InformacionAcademica buscarInfoAcademicaPorId(int idInfoAcademica);
	
}
