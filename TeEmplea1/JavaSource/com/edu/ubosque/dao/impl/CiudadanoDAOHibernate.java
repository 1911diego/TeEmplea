package com.edu.ubosque.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.edu.ubosque.baseDatos.SesionHibernate;
import com.edu.ubosque.dao.ICiudadanoDAO;
import com.edu.ubosque.model.Ciudadano;

public class CiudadanoDAOHibernate implements ICiudadanoDAO {

	
	
	public CiudadanoDAOHibernate() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean createCiudadano(Ciudadano ciudadanoACrear) {
		Session session = SesionHibernate.getSf().getCurrentSession();
		session.beginTransaction();
		session.persist(ciudadanoACrear);
		session.getTransaction().commit();
		return true;
	}

	@Override
	public List<Ciudadano> readCiudadano() {
		String hql = "Select c FROM Ciudadano c";
		Session session = SesionHibernate.getSf().getCurrentSession();
		session.beginTransaction();
		
		Query<Ciudadano> query = session.createQuery(hql);
		List<Ciudadano> lista = query.getResultList();
		
		session.getTransaction().commit();
		
		return lista;
	}

	@Override
	public boolean updateCiudadano(Ciudadano ciudadanoAModificar) {

		Session session = SesionHibernate.getSf().getCurrentSession();
		session.beginTransaction();
		session.update(ciudadanoAModificar);
		session.getTransaction().commit();
		return true;
	}

	@Override
	public boolean deleteCiudadano(Ciudadano ciudadanoAEliminar) {
		Session session = SesionHibernate.getSf().getCurrentSession();
		session.beginTransaction();
		session.delete(ciudadanoAEliminar);
		session.getTransaction().commit();
		return true;
	}

	@Override
	public Ciudadano buscarCiudadanoPorId(int id) {
		String hql = "Select c FROM Ciudadano c WHERE c.id = "+id;
		Session session = SesionHibernate.getSf().getCurrentSession();
		session.beginTransaction();
		
		try {
		Query<Ciudadano> query = session.createQuery(hql);
		Ciudadano ciudadanoBuscado = query.getSingleResult();
		
		session.getTransaction().commit();
		session.close();
		
		return ciudadanoBuscado;
		}
		catch(Exception e)
		{
			session.close();
			return null;
		}
	}


	@Override
	public Ciudadano buscarCiudadanoPorUsuario(String usuario) {
		String hql = "Select c FROM Ciudadano c WHERE c.usuario= '"+usuario+"'";
		Session session = SesionHibernate.getSf().getCurrentSession();
		session.beginTransaction();
		
		try {
		Query<Ciudadano> query = session.createQuery(hql);
		Ciudadano ciudadanoBuscado = query.getSingleResult();
		
		session.getTransaction().commit();
		session.close();
		
		return ciudadanoBuscado;
		}
		catch(Exception e)
		{
			session.close();
			return null;
		}
	}

}
