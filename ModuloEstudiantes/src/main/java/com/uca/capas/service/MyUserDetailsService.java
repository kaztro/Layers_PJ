package com.uca.capas.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.uca.capas.domain.Usuario;
import com.uca.capas.repositories.UsuarioRepo;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	UsuarioRepo userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional <Usuario> user = userRepository.findyByUserName(username);
		
		user.orElseThrow(() -> new UsernameNotFoundException("No se encontro: " + username));
		
		
		return user.map(MyUserDetails::new).get();
	
	}

}
