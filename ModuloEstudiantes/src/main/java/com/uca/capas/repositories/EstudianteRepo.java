package com.uca.capas.repositories;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.uca.capas.domain.Estudiante;

public interface EstudianteRepo extends JpaRepository<Estudiante, Integer> {

	@Query(nativeQuery=true, value="Select * from public.estudiante where nombres = ?1")
	public List<Estudiante> findByName(String name) throws DataAccessException;
	
	@Query(nativeQuery=true, value="Select * from public.estudiante where apellidos = ?1")
	public List<Estudiante> findByLastname(String lastname) throws DataAccessException;
	
}
