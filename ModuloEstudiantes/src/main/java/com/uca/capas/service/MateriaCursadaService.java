package com.uca.capas.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.uca.capas.domain.MateriaCursada;

public interface MateriaCursadaService {
	
	public List<MateriaCursada> findAll() throws DataAccessException;
	
	public MateriaCursada findOne(Integer code) throws DataAccessException;
	
	public void save(MateriaCursada mC) throws DataAccessException;
}
