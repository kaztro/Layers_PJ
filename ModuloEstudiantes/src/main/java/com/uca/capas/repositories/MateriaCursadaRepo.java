package com.uca.capas.repositories;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.uca.capas.domain.MateriaCursada;

public interface MateriaCursadaRepo extends JpaRepository<MateriaCursada, Integer> {
	
	@Query(nativeQuery=true, value="SELECT e.nombres, e.apellidos, ma.aprobadas, COUNT(mc.nota) AS Reprobadas, sal.promedio "+
			"FROM( "+
				"SELECT mc.id_estudiante, COUNT(nota) AS Aprobadas "+
				"FROM public.materia_cursada AS mc "+
				"INNER JOIN public.estudiante AS e "+
				"ON mc.id_estudiante = e.id_estudiante "+
				"WHERE mc.nota >= 6 "+
				"GROUP BY mc.id_estudiante "+
			") AS ma "+
			"INNER JOIN public.materia_cursada AS mc "+
			"ON mc.id_estudiante = ma.id_estudiante "+
			"INNER JOIN public.estudiante AS e "+
			"ON ma.id_estudiante = e.id_estudiante "+
			"INNER JOIN( "+
				"SELECT e.id_estudiante, ROUND(SUM(mc.nota)/COUNT(mc.nota), 2) as promedio "+
				"FROM public.estudiante AS e "+
				"INNER JOIN public.materia_cursada as mc "+
				"ON e.id_estudiante = mc.id_estudiante "+
				"INNER JOIN public.materia AS m "+
				"ON mc.id_materia = m.id_materia "+
				"GROUP BY e.id_estudiante "+
			") AS sal "+
			"ON e.id_estudiante = sal.id_estudiante "+
			"GROUP BY e.nombres, e.apellidos, ma.aprobadas, sal.promedio")
	public List<Object[]> registroDTO() throws DataAccessException;

}
