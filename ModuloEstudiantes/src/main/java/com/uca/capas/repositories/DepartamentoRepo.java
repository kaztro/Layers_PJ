package com.uca.capas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uca.capas.domain.Departamento;

public interface DepartamentoRepo extends JpaRepository<Departamento, Integer> {

}
