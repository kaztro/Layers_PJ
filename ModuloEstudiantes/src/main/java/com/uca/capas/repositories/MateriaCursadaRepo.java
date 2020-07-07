package com.uca.capas.repositories;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.uca.capas.domain.MateriaCursada;

public interface MateriaCursadaRepo extends JpaRepository<MateriaCursada, Integer> {

	@Query(nativeQuery = true, value = "SELECT e.id_estudiante, e.nombres, e.apellidos, CASE WHEN ma.aprobadas IS NULL THEN 0 ELSE ma.aprobadas END, CASE WHEN ma.reprobadas IS NULL THEN 0 ELSE ma.reprobadas END, CASE WHEN ROUND(AVG(mc.nota),2) IS NULL THEN 0.0 ELSE ROUND(AVG(mc.nota),2) END AS promedio "
			+ "FROM( "
			+ "SELECT cru.id_estudiante, CASE WHEN COUNT(cru.nota) IS NULL THEN 0 ELSE COUNT(cru.nota) END AS Aprobadas, CASE WHEN fir.reprobadas IS NULL THEN 0 ELSE fir.reprobadas END AS Reprobadas "
			+ "FROM( "
			+ "SELECT mc.id_estudiante, CASE WHEN COUNT(mc.nota) IS NULL THEN 0 ELSE COUNT(mc.nota) end AS Reprobadas "
			+ "FROM public.materia_cursada AS mc " + "FULL OUTER JOIN public.estudiante AS e "
			+ "ON mc.id_estudiante = e.id_estudiante " + "WHERE mc.nota < 6 AND mc.nota >0 "
			+ "GROUP BY mc.id_estudiante " + ") AS fir " + "FULL OUTER JOIN public.materia_cursada AS cru "
			+ "ON fir.id_estudiante = cru.id_estudiante " + "FULL OUTER JOIN public.estudiante AS es "
			+ "ON fir.id_estudiante = es.id_estudiante " + "WHERE cru.nota >= 6 AND cru.nota <=10 "
			+ "GROUP BY cru.id_estudiante, fir.Reprobadas " + ") AS ma "
			+ "FULL OUTER JOIN public.materia_cursada AS mc " + "ON ma.id_estudiante = mc.id_estudiante "
			+ "FULL OUTER JOIN public.estudiante AS e " + "ON mc.id_estudiante = e.id_estudiante "
			+ "GROUP BY e.id_estudiante, mc.id_estudiante, e.nombres, e.apellidos, ma.aprobadas, ma.reprobadas "
			+ "ORDER BY e.id_estudiante DESC")
	public List<Object[]> registroDTO() throws DataAccessException;

	@Query(nativeQuery = true, value = "SELECT e.id_estudiante, e.nombres, e.apellidos, CASE WHEN ma.aprobadas IS NULL THEN 0 ELSE ma.aprobadas END, CASE WHEN ma.reprobadas IS NULL THEN 0 ELSE ma.reprobadas END, CASE WHEN ROUND(AVG(mc.nota),2) IS NULL THEN 0.0 ELSE ROUND(AVG(mc.nota),2) END AS promedio "
			+ "FROM( "
			+ "SELECT cru.id_estudiante, CASE WHEN COUNT(cru.nota) IS NULL THEN 0 ELSE COUNT(cru.nota) END AS Aprobadas, CASE WHEN fir.reprobadas IS NULL THEN 0 ELSE fir.reprobadas END AS Reprobadas "
			+ "FROM( "
			+ "SELECT mc.id_estudiante, CASE WHEN COUNT(mc.nota) IS NULL THEN 0 ELSE COUNT(mc.nota) end AS Reprobadas "
			+ "FROM public.materia_cursada AS mc " + "FULL OUTER JOIN public.estudiante AS e "
			+ "ON mc.id_estudiante = e.id_estudiante " + "WHERE mc.nota < 6 AND mc.nota >0 "
			+ "GROUP BY mc.id_estudiante " + ") AS fir " + "FULL OUTER JOIN public.materia_cursada AS cru "
			+ "ON fir.id_estudiante = cru.id_estudiante " + "FULL OUTER JOIN public.estudiante AS es "
			+ "ON fir.id_estudiante = es.id_estudiante " + "WHERE cru.nota >= 6 AND cru.nota <=10 "
			+ "GROUP BY cru.id_estudiante, fir.Reprobadas " + ") AS ma "
			+ "FULL OUTER JOIN public.materia_cursada AS mc " + "ON ma.id_estudiante = mc.id_estudiante "
			+ "FULL OUTER JOIN public.estudiante AS e " + "ON mc.id_estudiante = e.id_estudiante "
			+ "WHERE e.nombres = :nombres "
			+ "GROUP BY e.id_estudiante, mc.id_estudiante, e.nombres, e.apellidos, ma.aprobadas, ma.reprobadas, e.id_estudiante")
	public List<Object[]> buscarNombres(String nombres) throws DataAccessException;

	@Query(nativeQuery = true, value = "SELECT e.id_estudiante, e.nombres, e.apellidos, CASE WHEN ma.aprobadas IS NULL THEN 0 ELSE ma.aprobadas END, CASE WHEN ma.reprobadas IS NULL THEN 0 ELSE ma.reprobadas END, CASE WHEN ROUND(AVG(mc.nota),2) IS NULL THEN 0.0 ELSE ROUND(AVG(mc.nota),2) END AS promedio "
			+ "FROM( "
			+ "SELECT cru.id_estudiante, CASE WHEN COUNT(cru.nota) IS NULL THEN 0 ELSE COUNT(cru.nota) END AS Aprobadas, CASE WHEN fir.reprobadas IS NULL THEN 0 ELSE fir.reprobadas END AS Reprobadas "
			+ "FROM( "
			+ "SELECT mc.id_estudiante, CASE WHEN COUNT(mc.nota) IS NULL THEN 0 ELSE COUNT(mc.nota) end AS Reprobadas "
			+ "FROM public.materia_cursada AS mc " + "FULL OUTER JOIN public.estudiante AS e "
			+ "ON mc.id_estudiante = e.id_estudiante " + "WHERE mc.nota < 6 AND mc.nota >0 "
			+ "GROUP BY mc.id_estudiante " + ") AS fir " + "FULL OUTER JOIN public.materia_cursada AS cru "
			+ "ON fir.id_estudiante = cru.id_estudiante " + "FULL OUTER JOIN public.estudiante AS es "
			+ "ON fir.id_estudiante = es.id_estudiante " + "WHERE cru.nota >= 6 AND cru.nota <=10 "
			+ "GROUP BY cru.id_estudiante, fir.Reprobadas " + ") AS ma "
			+ "FULL OUTER JOIN public.materia_cursada AS mc " + "ON ma.id_estudiante = mc.id_estudiante "
			+ "FULL OUTER JOIN public.estudiante AS e " + "ON mc.id_estudiante = e.id_estudiante "
			+ "WHERE e.apellidos = :apellidos "
			+ "GROUP BY e.id_estudiante, mc.id_estudiante, e.nombres, e.apellidos, ma.aprobadas, ma.reprobadas, e.id_estudiante")
	public List<Object[]> buscarApellidos(String apellidos) throws DataAccessException;
	
	@Query(nativeQuery=true, value="SELECT mc.id_materiacursada, m.materia, mc.anho, mc.ciclo, mc.nota, CASE WHEN mc.nota >= 6 THEN 'Aprobada' ELSE 'Reprobada' END AS Respuesta "+
			"FROM public.materia_cursada AS mc "+
			"INNER JOIN public.materia AS m "+
			"ON mc.id_materia = m.id_materia "+
			"WHERE id_estudiante= :id")
	public List<Object[]> mostrarMaterias(Integer id) throws DataAccessException;

}
