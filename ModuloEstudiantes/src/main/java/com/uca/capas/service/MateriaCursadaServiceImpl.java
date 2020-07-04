package com.uca.capas.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.uca.capas.domain.MateriaCursada;
import com.uca.capas.dto.MateriaCursadaDTO;
import com.uca.capas.repositories.MateriaCursadaRepo;

@Service
public class MateriaCursadaServiceImpl implements MateriaCursadaService {
	
	@Autowired
	MateriaCursadaRepo materiaCursadaRepo;

	@Override
	public List<MateriaCursada> findAll() throws DataAccessException {
		
		return null;
	}

	@Override
	public MateriaCursada findOne(Integer code) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(MateriaCursada mC) throws DataAccessException {
		// TODO Auto-generated method stub
		
	}
	
	//DTO - mapear respuesta en forma de JSON
	@Override
	public List<MateriaCursadaDTO> regitroDto() throws DataAccessException{
		List<MateriaCursadaDTO> expedientes = materiaCursadaRepo.registroDTO().stream().map(obj->{
				MateriaCursadaDTO mc = new MateriaCursadaDTO();
				mc.setNombre(obj[0].toString());
				mc.setApellido(obj[1].toString());
				mc.setAprovadas(obj[2].toString());
				mc.setReprobadas(obj[3].toString());
				mc.setPromedio(obj[4].toString());
				return mc;
		}).collect(Collectors.toList());
		return expedientes;
	}
	
	
}
