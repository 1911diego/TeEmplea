package com.edu.ubosque.mb;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.edu.ubosque.logica.UsuarioLogica;
import com.edu.ubosque.model.Usuarios;

@ManagedBean
//@SessionScoped
public class UsuarioMB {

	private UsuarioLogica ul; 
	private List<Usuarios> listaUsuarios;
	private String usuario;
	private String clave;
	
	public UsuarioMB() {
		
		ul = new UsuarioLogica();
		listaUsuarios = ul.readUsuario();
		
		
	}
	
	public String validarUsuario() {
		
		if(usuario != null && clave != null) {
			for (int i = 0; i < listaUsuarios.size(); i++) {
				System.out.println(listaUsuarios);
				if(usuario.equalsIgnoreCase(listaUsuarios.get(i).getNombreUsuario()) && clave.equals(listaUsuarios.get(i).getContrasena())) {
					return "ingreso";
				}
			}
		}
		System.out.println("No entro");
		return null;
	}

	public List<Usuarios> getListaUsuarios() {
		return listaUsuarios;
	}

	public void setListaUsuarios(List<Usuarios> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	

}
