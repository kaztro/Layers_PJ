package com.uca.capas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;

import com.uca.capas.domain.Materia;
import com.uca.capas.repositories.MateriaRepo;

public class MateriaServiceImpl implements MateriaService{
	
	@Autowired
	MateriaRepo materiaRepo;

	@Override
	public List<Materia> findAll() throws DataAccessException {
		return materiaRepo.findAll();
	}

	@Override
	public void save(Materia materia) throws DataAccessException {
		materiaRepo.save(materia);
		
	}

}
