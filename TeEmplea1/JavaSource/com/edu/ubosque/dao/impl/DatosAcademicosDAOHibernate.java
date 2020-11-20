package com.edu.ubosque.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.edu.ubosque.baseDatos.SesionHibernate;
import com.edu.ubosque.dao.IDatosAcademicosDAO;
import com.edu.ubosque.model.Ciudadano;
import com.edu.ubosque.model.InformacionAcademica;

public class DatosAcademicosDAOHibernate implements IDatosAcademicosDAO {

	public DatosAcademicosDAOHibernate() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean createInfoAcademica(InformacionAcademica infoAcademicaACrear) {
		Session session = SesionHibernate.getSf().getCurrentSession();
		session.beginTransaction();
		session.persist(infoAcademicaACrear);
		session.getTransaction().commit();
		return true;
	}

	@Override
	public List<InformacionAcademica> readInfoAcademica(int idCiudadano) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateInfoAcademica(InformacionAcademica infoAcademicaAModificar) {
		Session session = SesionHibernate.getSf().getCurrentSession();
		session.beginTransaction();
		session.update(infoAcademicaAModificar);
		session.getTransaction().commit();
		return true;
	}

	@Override
	public boolean deleteInfoAcademica(InformacionAcademica inforAcademicaAEliminar) {
		System.out.println(inforAcademicaAEliminar.getId());
		Session session = SesionHibernate.getSf().getCurrentSession();
		session.beginTransaction();
		session.remove(inforAcademicaAEliminar);
		session.getTransaction().commit();
		session.close();
		return true;
	}

	@Override
	public InformacionAcademica buscarInfoAcademicaPorId(int idInfoAcademica) {
		String hql = "Select i FROM InformacionAcademica i WHERE i.id = "+idInfoAcademica;
		Session session = SesionHibernate.getSf().getCurrentSession();
		session.beginTransaction();
		
		try {
		Query<InformacionAcademica> query = session.createQuery(hql);
		InformacionAcademica infoAcademicaBuscada = query.getSingleResult();
		
		session.getTransaction().commit();
		session.close();
		
		return infoAcademicaBuscada;
		}
		catch(Exception e)
		{
			session.close();
			return null;
		}
		
	}

}
