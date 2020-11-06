package com.edu.ubosque.dao;

import java.util.List;

import com.edu.ubosque.model.Usuarios;

public interface IUsuarioDAO {

	boolean createUsuario(Usuarios sectorACrear);
	
	List<Usuarios> readUsuarios();
	
	boolean updateUsuario(Usuarios sectorAModificar);
	
	boolean deleteUsuario(Usuarios sectorAEliminar);
}
