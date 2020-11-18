package com.edu.ubosque.dao.impl;

import java.util.List;

import org.hibernate.Session;

import com.edu.ubosque.baseDatos.SesionHibernate;
import com.edu.ubosque.dao.IDatosAcademicosDAO;
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
		Session session = SesionHibernate.getSf().getCurrentSession();
		session.beginTransaction();
		session.delete(inforAcademicaAEliminar);
		session.getTransaction().commit();
		return true;
	}

}
