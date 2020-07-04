package com.uca.capas.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.uca.capas.domain.MateriaCursada;
import com.uca.capas.dto.MateriaCursadaDTO;

public interface MateriaCursadaService {
	
	public List<MateriaCursada> findAll() throws DataAccessException;
	
	public MateriaCursada findOne(Integer code) throws DataAccessException;
	
	public void save(MateriaCursada mC) throws DataAccessException;

	List<MateriaCursadaDTO> regitroDto() throws DataAccessException;
}
