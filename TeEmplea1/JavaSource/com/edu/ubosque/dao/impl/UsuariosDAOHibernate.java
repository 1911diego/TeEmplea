package com.edu.ubosque.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import com.edu.ubosque.baseDatos.SesionHibernate;
import com.edu.ubosque.dao.IUsuarioDAO;

public class UsuariosDAOHibernate implements IUsuarioDAO{

//	@Override
//	public boolean createUsuario(Usuarios sectorACrear) {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	@Override
//	public List<Usuarios> readUsuarios() {
//		Session sesion = SesionHibernate.getSf().getCurrentSession();
//		
//		sesion.beginTransaction();
//		Query<Usuarios> query = sesion.createQuery("Select u FROM Usuarios u");
//		
//		List<Usuarios> usuarios = query.getResultList();
//		
//		sesion.getTransaction().commit();
//		
//		return usuarios;
//	}
//
//	@Override
//	public boolean updateUsuario(Usuarios sectorAModificar) {
//		
//		return false;
//	}
//
//	@Override
//	public boolean deleteUsuario(Usuarios sectorAEliminar) {
//		
//		return false;
//	}

}
