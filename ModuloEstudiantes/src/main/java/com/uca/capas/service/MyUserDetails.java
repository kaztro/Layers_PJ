package com.uca.capas.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.uca.capas.domain.Usuario;

public class MyUserDetails implements UserDetails {

	private String userName;
	private String password;
	private boolean enabled_u;
	private List<GrantedAuthority> authorities;
	
	public MyUserDetails(Usuario user) {
		this.userName = user.getUsername();
		this.password = user.getPassword();
		this.enabled_u = user.getEnabled_u();
		this.authorities = Arrays.stream(user.getRoles().getRol().split(","))
								.map(SimpleGrantedAuthority::new)
								.collect(Collectors.toList());
		
		System.out.println(this.authorities);
		System.out.println(user.getUsername());
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return authorities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return userName;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return enabled_u;
	}
	
	
	
	
	
}
