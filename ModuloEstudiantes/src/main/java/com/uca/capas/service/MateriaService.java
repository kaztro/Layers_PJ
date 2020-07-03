package com.uca.capas.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.uca.capas.domain.Materia;

public interface MateriaService {
	
	//Buscar todos
	public List<Materia> findAll() throws DataAccessException;
	
	//Agregar - Editar
	public void save(Materia materia) throws DataAccessException;
	
	public Materia findOne(Integer code) throws DataAccessException;

}