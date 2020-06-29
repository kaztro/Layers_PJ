package com.uca.capas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.uca.capas.domain.Usuario;
import com.uca.capas.repositories.UsuarioRepo;

@Service
public class UsuarioServiceImpl implements UsuarioService{
	
	@Autowired
	UsuarioRepo usuarioRepo;

	@Override
	public List<Usuario> findAll() throws DataAccessException {
		return usuarioRepo.findAll();
	}

	@Override
	public void save(Usuario usuario) throws DataAccessException {
		usuarioRepo.save(usuario);
		
	}

}
