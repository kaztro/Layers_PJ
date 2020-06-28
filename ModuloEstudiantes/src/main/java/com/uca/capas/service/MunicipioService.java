package com.uca.capas.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.uca.capas.domain.Municipio;

public interface MunicipioService {

	// Buscar todos
	public List<Municipio> findAll() throws DataAccessException;

	// Agregar - Editar
	public void save(Municipio municipio) throws DataAccessException;

}
