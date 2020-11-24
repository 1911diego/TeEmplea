package com.edu.ubosque.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.edu.ubosque.baseDatos.SesionHibernate;
import com.edu.ubosque.dao.IExpLaboralDAO;
import com.edu.ubosque.model.ExperienciaLaboral;

public class ExperienciaLaboralDAOHibernate implements IExpLaboralDAO{

	public ExperienciaLaboralDAOHibernate() {
		
	}

	@Override
	public boolean createExperienciaLaboral(ExperienciaLaboral crearExpLaboral) {
		Session session = SesionHibernate.getSf().getCurrentSession();
		session.beginTransaction();
		session.persist(crearExpLaboral);
		session.getTransaction().commit();
		session.close();
		return true;
	}

	@Override
	public List<ExperienciaLaboral> readExperienciaLaboral(int idExpLaboral) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateExperienciaLaboral(ExperienciaLaboral modificarExpLaboral) {
		Session session = SesionHibernate.getSf().getCurrentSession();
		session.beginTransaction();
		session.update(modificarExpLaboral);
		session.getTransaction().commit();
		return true;
	}

	@Override
	public boolean deleteExperienciaLaboral(ExperienciaLaboral deleteExpLaboral) {
		System.out.println(deleteExpLaboral.getId());
		Session session = SesionHibernate.getSf().getCurrentSession();
		session.beginTransaction();
		session.remove(deleteExpLaboral);
		session.getTransaction().commit();
		session.close();
		return true;
	}

	@Override
	public ExperienciaLaboral buscarExperienciaLaboral(int idExpLaboral) {
		String hql = "Select e FROM ExperienciaLaboral e WHERE e.id = "+idExpLaboral;
		Session session = SesionHibernate.getSf().getCurrentSession();
		session.beginTransaction();
		
		try {
		Query<ExperienciaLaboral> query = session.createQuery(hql);
		ExperienciaLaboral expLaboralBuscada = query.getSingleResult();
		
		session.getTransaction().commit();
		session.close();
		
		return expLaboralBuscada;
		}
		catch(Exception e)
		{
			session.close();
			return null;
		}
	}

}
