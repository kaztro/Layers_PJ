package com.uca.capas.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.uca.capas.domain.MateriaCursada;
import com.uca.capas.dto.ExpedienteDTO;
import com.uca.capas.dto.MateriaCursadaDTO;

public interface MateriaCursadaService {
	
	public List<MateriaCursada> findAll() throws DataAccessException;
	
	public MateriaCursada findOne(Integer code) throws DataAccessException;
	
	public void save(MateriaCursada mC) throws DataAccessException;

	List<ExpedienteDTO> regitroDto() throws DataAccessException;

	List<ExpedienteDTO> buscarNombres(String nombre) throws DataAccessException;

	List<ExpedienteDTO> buscarApellidos(String nombre) throws DataAccessException;

	List<MateriaCursadaDTO> mostrarMaterias(Integer id) throws DataAccessException;
}
