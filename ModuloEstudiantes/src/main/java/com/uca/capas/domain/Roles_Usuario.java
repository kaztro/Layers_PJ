package com.uca.capas.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(schema="public", name="ROLES")
public class Roles_Usuario {
	
	private Integer id_rolesUser;
	
	//Foreign - Usuario
	private Integer id_usuario;
	
	//Foreign - ROLES
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_rol")
	private Roles roles;
	
	@Transient
	private Integer id_rol;

	public Integer getId_rolesUser() {
		return id_rolesUser;
	}

	public void setId_rolesUser(Integer id_rolesUser) {
		this.id_rolesUser = id_rolesUser;
	}

	public Integer getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(Integer id_usuario) {
		this.id_usuario = id_usuario;
	}

	public Roles getRoles() {
		return roles;
	}

	public void setRoles(Roles roles) {
		this.roles = roles;
	}

	public Integer getId_rol() {
		return id_rol;
	}

	public void setId_rol(Integer id_rol) {
		this.id_rol = id_rol;
	}

	
}
