package com.uca.capas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.uca.capas.domain.Roles;
import com.uca.capas.repositories.RolesRepo;

@Service
public class RolesServiceImpl implements RolesService{

	@Autowired
	RolesRepo rolesRepo;
	
	
	@Override
	public List<Roles> findAll() throws DataAccessException {
		return rolesRepo.findAll();
	}

	@Override
	public void save(Roles roles) throws DataAccessException {
		rolesRepo.save(roles);
		
	}

}
