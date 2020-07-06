package com.uca.capas.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.uca.capas.domain.Estudiante;

public interface EstudianteService {
	
	//Buscar todos
	public List<Estudiante> findAll() throws DataAccessException;
	
	//Buscar uno
	public Estudiante findOne(Integer code) throws DataAccessException;
	
	//Buscar un estudiante - nombres
	public void findOneByName(String name) throws DataAccessException;
	
	//Buscar un estudiante - apellido
	public void findOneByLastname(String lastname) throws DataAccessException;

	//Agregar - Editar
	public void save(Estudiante estudiante) throws DataAccessException;
	
}