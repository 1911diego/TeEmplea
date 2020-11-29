package com.edu.ubosque.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.edu.ubosque.baseDatos.SesionHibernate;
import com.edu.ubosque.dao.IPostulacionLaboralDAO;
import com.edu.ubosque.model.OfertaLaboral;
import com.edu.ubosque.model.PostulacionLaboral;

public class PostulacionLaboralDAOHibernate implements IPostulacionLaboralDAO {

	public PostulacionLaboralDAOHibernate() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean createPostulacionLaboral(PostulacionLaboral crearPostulacionLaboral) {
		Session session = SesionHibernate.getSf().getCurrentSession();
		session.beginTransaction();
		try
		{
			session.persist(crearPostulacionLaboral);
			session.getTransaction().commit();
			session.close();
			return true;
		}
		catch(Exception e)
		{
			session.close();
			return false;
		}
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
	public PostulacionLaboral buscarPostulacionLaboralPorId(int id, int opcion) {
		String hql = null;
		switch(opcion)
			{
				case 1:
				{
					hql = "SELECT p FROM PostulacionLaboral p WHERE p.id = "+id;
					break;
				}
		
				case 2:
				{
					hql = "SELECT p FROM PostulacionLaboral p WHERE p.ofertaLaboral = "+id;
					System.out.println("entra al case 2");
					System.out.println("id= "+id);
					break;
				}
			}
			
		Session session = SesionHibernate.getSf().getCurrentSession();
		session.beginTransaction();
		
		try {
		Query<PostulacionLaboral> query = session.createQuery(hql);
		PostulacionLaboral postulacionLaboralBuscada = query.getSingleResult();
		System.out.println("postulacion buscada = "+postulacionLaboralBuscada.getId());
		
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

	@Override
	public List<PostulacionLaboral> buscarPostulacionLaboralPorCiudadanoOEmpresa(int id,int opcion) {
		String hql = null;
		switch(opcion)
		{
			case 1:
			{
				hql = "SELECT p FROM PostulacionLaboral p WHERE p.ciudadano = "+id;
				break;
			}
			
			case 2:
			{
				hql = "SELECT p FROM PostulacionLaboral p WHERE p.ofertaLaboral.empresa.idempresa = "+id;
				System.out.println("Entra en el case 2 empresaid");
				break;
			}
		}
		
		Session session = SesionHibernate.getSf().getCurrentSession();
		session.beginTransaction();
		
		try {
		Query<PostulacionLaboral> query = session.createQuery(hql);
		List<PostulacionLaboral> lista = query.getResultList();
		session.getTransaction().commit();
		session.close();
		return lista;
		}
		catch(Exception e)
		{
			session.close();
			return null;
		}
		
	}
	
	
	

	

}
