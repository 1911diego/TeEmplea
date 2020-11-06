package com.edu.ubosque.mb;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.edu.ubosque.logica.UsuarioLogica;
import com.edu.ubosque.model.Usuarios;

@ManagedBean
@SessionScoped
public class UsuarioMB {

	private UsuarioLogica ul; 
	private List<Usuarios> listaUsuarios;
	private Usuarios usr;
	
	public UsuarioMB() {
		
		ul = new UsuarioLogica();
		listaUsuarios = ul.readUsuario();
		
	}
	
	public String validarUsuario() {
		
		for (int i = 0; i < listaUsuarios.size(); i++) {
			if(usr.getNombreUsuario().equalsIgnoreCase(listaUsuarios.get(i).getNombreUsuario()) && usr.getContrasena().equalsIgnoreCase(listaUsuarios.get(i).getContrasena())) {
				return "Ingreso";
			}
		}
		
		return null;
	}

	public List<Usuarios> getListaUsuarios() {
		return listaUsuarios;
	}

	public void setListaUsuarios(List<Usuarios> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}

	public Usuarios getUsr() {
		return usr;
	}

	public void setUsr(Usuarios usr) {
		this.usr = usr;
	}

}
