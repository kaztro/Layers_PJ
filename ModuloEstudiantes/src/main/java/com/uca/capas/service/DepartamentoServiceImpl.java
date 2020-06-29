package com.uca.capas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.uca.capas.domain.Departamento;
import com.uca.capas.repositories.DepartamentoRepo;

@Service
public class DepartamentoServiceImpl implements DepartamentoService{
	
	@Autowired
	DepartamentoRepo departamentoRepo;

	@Override
	public List<Departamento> findAll() throws DataAccessException {
		return departamentoRepo.findAll();
	}

	@Override
	public void save(Departamento departamento) throws DataAccessException {
		departamentoRepo.save(departamento);
		
	}
	
}
