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
	
	@Query(nativeQuery=true, value="SELECT COUNT(M.materia) FROM PUBLIC.MATERIA AS M, PUBLIC.MATERIA_CURSADA AS MC, PUBLIC.ESTUDIANTE AS E WHERE MC.nota >= 6 AND MC.id_estudiante=?1")
	public Integer materiasAprobadas(Integer id_estudiante) throws DataAccessException;
	
	@Query(nativeQuery=true, value="SELECT COUNT(M.materia) FROM PUBLIC.MATERIA AS M, PUBLIC.MATERIA_CURSADA AS MC, PUBLIC.ESTUDIANTE AS E WHERE MC.nota < 6 AND MC.id_estudiante=?1")
	public Integer materiasReprobadas(Integer id_estudiante) throws DataAccessException;
	
	@Query(nativeQuery=true, value="SELECT (SUM(MC.nota)/COUNT(M.materia)) FROM PUBLIC.MATERIA AS M, PUBLIC.MATERIA_CURSADA AS MC, PUBLIC.ESTUDIANTE AS E WHERE MC.id_estudiante=?1")
	public Float promedioNota(Integer id_estudiante) throws DataAccessException;
	
}
