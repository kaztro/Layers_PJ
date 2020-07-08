package com.uca.capas.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.uca.capas.domain.Roles;

public interface RolesService {

	public List<Roles> findAll() throws DataAccessException;
	
	public void save(Roles roles) throws DataAccessException;
	
}
