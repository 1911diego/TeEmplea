package com.edu.ubosque.logica;

import java.util.List;

import com.edu.ubosque.dao.IEmpresaDAO;
import com.edu.ubosque.dao.impl.EmpresaDAOHibernate;
import com.edu.ubosque.model.Empresa;

public class EmpresaLogica {

	private IEmpresaDAO dao;
	
	public EmpresaLogica() {
		dao = new EmpresaDAOHibernate();
	}
	
	public boolean createEmpresa(Empresa empresaACrear) {
		
		return dao.createEmpresa(empresaACrear);
		
	}
	
	public List<Empresa> readEmpresa() {
		
		return dao.readEmpresa();
		
	}
	
	public boolean updateEmpresa(Empresa empresaAModificar) {
		
		return dao.updateEmpresa(empresaAModificar);
		
	}
	
	public boolean deleteEmpresa(Empresa empresaAEliminar) {
		
		return dao.deleteEmpresa(empresaAEliminar);
		
	}
	
	public Empresa empresaPorId(int id) {
		
		return dao.readEmpresaPorId(id);
		
	}
	
	public Empresa empresaPorNombre(String nombre) {
		
		return dao.readEmpresaPorNombre(nombre);
		
	}

}
