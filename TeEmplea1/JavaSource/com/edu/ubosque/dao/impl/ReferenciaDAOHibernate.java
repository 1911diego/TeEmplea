package com.edu.ubosque.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.edu.ubosque.baseDatos.SesionHibernate;
import com.edu.ubosque.dao.IReferenciaDAO;
import com.edu.ubosque.model.ExperienciaLaboral;
import com.edu.ubosque.model.Referencias;

public class ReferenciaDAOHibernate implements IReferenciaDAO {

	public ReferenciaDAOHibernate() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean createReferencia(Referencias crearReferencia) {
		Session session = SesionHibernate.getSf().getCurrentSession();
		session.beginTransaction();
		session.persist(crearReferencia);
		session.getTransaction().commit();
		session.close();
		return true;
	}

	@Override
	public List<Referencias> readReferencia(int idReferencia) {
		return null;
	}

	@Override
	public boolean updateReferencia(Referencias modificarReferencia) {
		Session session = SesionHibernate.getSf().getCurrentSession();
		session.beginTransaction();
		session.update(modificarReferencia);
		session.getTransaction().commit();
		return true;
	}

	@Override
	public boolean deleteReferencia(Referencias deleteReferencia) {
		System.out.println(deleteReferencia.getId());
		Session session = SesionHibernate.getSf().getCurrentSession();
		session.beginTransaction();
		session.remove(deleteReferencia);
		session.getTransaction().commit();
		session.close();
		return true;
	}

	@Override
	public Referencias buscarReferencia(int idReferencia) {
		String hql = "Select r FROM Referencias r WHERE r.id = "+idReferencia;
		Session session = SesionHibernate.getSf().getCurrentSession();
		session.beginTransaction();
		
		try {
		Query<Referencias> query = session.createQuery(hql);
		Referencias referenciaBuscada = query.getSingleResult();
		
		session.getTransaction().commit();
		session.close();
		
		return referenciaBuscada;
		}
		catch(Exception e)
		{
			session.close();
			return null;
		}
	}
	
	

}
