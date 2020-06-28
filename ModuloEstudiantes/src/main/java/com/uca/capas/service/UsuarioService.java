package com.uca.capas.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.uca.capas.domain.Usuario;

public interface UsuarioService {

	//Buscar todos
	public List<Usuario> findAll() throws DataAccessException;
	
	//Agregar - Editar
	public void save(Usuario usuario) throws DataAccessException;
	
}