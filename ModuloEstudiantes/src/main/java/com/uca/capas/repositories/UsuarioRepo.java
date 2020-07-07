package com.uca.capas.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.uca.capas.domain.Usuario;

public interface UsuarioRepo extends JpaRepository<Usuario, Integer> {
	
	@Query(nativeQuery=true, value="Select * from public.usuario where username = ?1")
	Optional <Usuario> findyByUserName(String username);
	
}
