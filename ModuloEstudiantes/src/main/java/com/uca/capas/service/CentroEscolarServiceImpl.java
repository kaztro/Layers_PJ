package com.uca.capas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.uca.capas.domain.CentroEscolar;
import com.uca.capas.repositories.CentroEscolarRepo;

@Service
public class CentroEscolarServiceImpl implements CentroEscolarService{
	
	@Autowired
	CentroEscolarRepo centroEscolarRepo;

	@Override
	public List<CentroEscolar> findAll() throws DataAccessException {
		return centroEscolarRepo.findAll();
	}

	@Override
	public void save(CentroEscolar centroEscolar) throws DataAccessException {
		centroEscolarRepo.save(centroEscolar);
		
	}

}
