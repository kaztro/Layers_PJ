package com.uca.capas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uca.capas.domain.Usuario;

public interface UsuarioRepo extends JpaRepository<Usuario, Integer> {

}
