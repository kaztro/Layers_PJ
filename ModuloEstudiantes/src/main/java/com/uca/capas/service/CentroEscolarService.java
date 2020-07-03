package com.uca.capas.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.uca.capas.domain.CentroEscolar;

public interface CentroEscolarService {
	
	//Buscar todos
	public List<CentroEscolar> findAll() throws DataAccessException;
	
	//Agregar - Editar
	public void save(CentroEscolar centroEscolar) throws DataAccessException;
	
	public CentroEscolar findOne(Integer code) throws DataAccessException;

}