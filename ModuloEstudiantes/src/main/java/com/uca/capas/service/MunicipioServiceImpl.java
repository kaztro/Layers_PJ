package com.uca.capas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.uca.capas.domain.Municipio;
import com.uca.capas.repositories.MunicipioRepo;

@Service
public class MunicipioServiceImpl implements MunicipioService{
	
	@Autowired
	MunicipioRepo municipioRepo;

	@Override
	public List<Municipio> findAll() throws DataAccessException {
		return municipioRepo.findAll();
	}

	@Override
	public void save(Municipio municipio) throws DataAccessException {
		municipioRepo.save(municipio);
		
	}

}
