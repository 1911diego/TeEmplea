package com.edu.ubosque.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.edu.ubosque.baseDatos.SesionHibernate;
import com.edu.ubosque.dao.IEmpresaDAO;
import com.edu.ubosque.model.Empresa;

public class EmpresaDAOHibernate implements IEmpresaDAO {

	public EmpresaDAOHibernate() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean createEmpresa(Empresa empresaACrear) {
		
		Session session = SesionHibernate.getSf().getCurrentSession();
		session.beginTransaction();
		session.persist(empresaACrear);
		session.getTransaction().commit();
		return true;
	}

	@Override
	public List<Empresa> readEmpresa() {

		String hql = "Select e FROM Empresa e";
		Session session = SesionHibernate.getSf().getCurrentSession();
		session.beginTransaction();
		Query<Empresa> query = session.createQuery(hql);
		List<Empresa> lista = query.getResultList();
		return lista;
	}

	@Override
	public boolean updateEmpresa(Empresa empresaAModificar) {
		
		Session session = SesionHibernate.getSf().getCurrentSession();
		session.beginTransaction();
		session.update(empresaAModificar);
		session.getTransaction().commit();
		return true;
	}

	@Override
	public boolean deleteEmpresa(Empresa empresaAEliminar) {
		
		Session session = SesionHibernate.getSf().getCurrentSession();
		session.beginTransaction();
		session.delete(empresaAEliminar);
		session.getTransaction();
		return true;
	}

}
