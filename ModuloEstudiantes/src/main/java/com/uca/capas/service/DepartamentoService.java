package com.uca.capas.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.uca.capas.domain.Departamento;

public interface DepartamentoService {

	// Buscar todos
	public List<Departamento> findAll() throws DataAccessException;

	// Agregar - Editar
	public void save(Departamento departamento) throws DataAccessException;
}
