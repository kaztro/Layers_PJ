package com.uca.capas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uca.capas.domain.Estudiante;

public interface EstudianteRepo extends JpaRepository<Estudiante, Integer> {

}
