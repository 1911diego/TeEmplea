package com.edu.ubosque.dao;

import java.util.List;

import com.edu.ubosque.model.Empresa;

public interface IEmpresaDAO {
	
	boolean createEmpresa(Empresa empresaACrear);
	
	List<Empresa> readEmpresa();
	
	boolean updateEmpresa(Empresa empresaAModificar);
	
	boolean deleteEmpresa(Empresa empresaAEliminar);
	
}
