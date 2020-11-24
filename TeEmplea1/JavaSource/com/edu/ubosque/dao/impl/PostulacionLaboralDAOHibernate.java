package com.edu.ubosque.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.edu.ubosque.baseDatos.SesionHibernate;
import com.edu.ubosque.dao.IPostulacionLaboralDAO;
import com.edu.ubosque.model.PostulacionLaboral;

public class PostulacionLaboralDAOHibernate implements IPostulacionLaboralDAO {

	public PostulacionLaboralDAOHibernate() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean createPostulacionLaboral(PostulacionLaboral crearPostulacionLaboral) {
		Session session = SesionHibernate.getSf().getCurrentSession();
		session.beginTransaction();
		session.persist(crearPostulacionLaboral);
		session.getTransaction().commit();
		session.close();
		return true;
	}

	@Override
	public List<PostulacionLaboral> readPostulacionLaboral(int idPostulacionLaboral) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updatePostulacionLaboral(PostulacionLaboral modificarPostulacionLaboral) {
		Session session = SesionHibernate.getSf().getCurrentSession();
		session.beginTransaction();
		session.update(modificarPostulacionLaboral);
		session.getTransaction().commit();
		return true;
	}

	@Override
	public boolean deletePostulacionLaboral(PostulacionLaboral eliminarPostulacionLaboral) {
		Session session = SesionHibernate.getSf().getCurrentSession();
		session.beginTransaction();
		session.remove(eliminarPostulacionLaboral);
		session.getTransaction().commit();
		session.close();
		return true;
	}

	@Override
	public PostulacionLaboral buscarPostulacionLaboralPorId(int idPostulacionLaboral) {
		String hql = "Select p FROM PostulacionLaboral p WHERE p.id = "+idPostulacionLaboral;
		Session session = SesionHibernate.getSf().getCurrentSession();
		session.beginTransaction();
		
		try {
		Query<PostulacionLaboral> query = session.createQuery(hql);
		PostulacionLaboral postulacionLaboralBuscada = query.getSingleResult();
		
		session.getTransaction().commit();
		session.close();
		
		return postulacionLaboralBuscada;
		}
		catch(Exception e)
		{
			session.close();
			return null;
		}
	}

}
