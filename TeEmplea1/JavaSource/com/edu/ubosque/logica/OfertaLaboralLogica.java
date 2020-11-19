package com.edu.ubosque.logica;

import java.util.List;

import com.edu.ubosque.dao.IOfertaLaboralDAO;
import com.edu.ubosque.dao.impl.OfertaLaboralDAOHibernate;
import com.edu.ubosque.model.OfertaLaboral;

public class OfertaLaboralLogica {

	private IOfertaLaboralDAO dao;
	
	public OfertaLaboralLogica() {
		dao = new OfertaLaboralDAOHibernate();
	}
	
	public boolean createOferta(OfertaLaboral ofertaACrear) {
		
		return dao.createOferta(ofertaACrear);
		
	}
	
	public List<OfertaLaboral> readOferta(){
		
		return dao.readOferta();
		
	}
	
	public boolean updateOferta(OfertaLaboral ofertaAModificar) {
		
		return dao.updateOferta(ofertaAModificar);
		
	}
	
	public boolean deleteOferta(OfertaLaboral ofertaAEliminar) {
		
		return dao.deleteOferta(ofertaAEliminar);
		
	}

}
