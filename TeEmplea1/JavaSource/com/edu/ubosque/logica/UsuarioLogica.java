package com.edu.ubosque.logica;

import java.util.List;

import com.edu.ubosque.dao.IUsuarioDAO;
import com.edu.ubosque.dao.impl.UsuariosDAOHibernate;
import com.edu.ubosque.model.Usuarios;

public class UsuarioLogica {

	private IUsuarioDAO dao;
	
	public UsuarioLogica() {
		dao = new UsuariosDAOHibernate();
	}
	
	public List<Usuarios> readUsuario() {
		
		return dao.readUsuarios();
		
	}

}
