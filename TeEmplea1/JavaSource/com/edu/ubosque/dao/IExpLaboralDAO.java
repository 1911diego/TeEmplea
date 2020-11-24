package com.edu.ubosque.dao;

import java.util.List;

import com.edu.ubosque.model.ExperienciaLaboral;

public interface IExpLaboralDAO {
	
	boolean createExperienciaLaboral(ExperienciaLaboral crearExpLaboral);
	
	List<ExperienciaLaboral> readExperienciaLaboral(int idExpLaboral);
	
	boolean updateExperienciaLaboral(ExperienciaLaboral modificarExpLaboral);
	
	boolean deleteExperienciaLaboral(ExperienciaLaboral deleteExpLaboral);
	
	ExperienciaLaboral buscarExperienciaLaboral(int idExpLaboral);

}
