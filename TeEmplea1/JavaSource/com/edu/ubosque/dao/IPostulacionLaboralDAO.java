package com.edu.ubosque.dao;

import java.util.List;


import com.edu.ubosque.model.PostulacionLaboral;

public interface IPostulacionLaboralDAO {

	boolean createPostulacionLaboral(PostulacionLaboral crearPostulacionLaboral);
	
	List<PostulacionLaboral> readPostulacionLaboral(int idPostulacionLaboral);
	
	boolean updatePostulacionLaboral(PostulacionLaboral modificarPostulacionLaboral);
	
	boolean deletePostulacionLaboral(PostulacionLaboral eliminarPostulacionLaboral);
	
	PostulacionLaboral buscarPostulacionLaboralPorId(int idPostulacionLaboral);
}
