package com.edu.ubosque.dao;

import java.util.List;


import com.edu.ubosque.model.PostulacionLaboral;

public interface IPostulacionLaboralDAO {

	boolean createPostulacionLaboral(PostulacionLaboral crearPostulacionLaboral);
	
	List<PostulacionLaboral> readPostulacionLaboral(int idPostulacionLaboral);
	
	boolean updatePostulacionLaboral(PostulacionLaboral modificarPostulacionLaboral);
	
	boolean deletePostulacionLaboral(PostulacionLaboral eliminarPostulacionLaboral);
	
	PostulacionLaboral buscarPostulacionLaboralPorId(int idOferta,int idCiudadano, int opcion);
	
	List<PostulacionLaboral> buscarPostulacionLaboralPorCiudadanoOEmpresa(int idCiudadano, int opcion);
	
}
