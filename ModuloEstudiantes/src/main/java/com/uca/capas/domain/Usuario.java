package com.uca.capas.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(schema="public", name="USUARIO")
public class Usuario {

	@Id
	@Column(name="id_usuario")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id_usuario;
	
	@NotEmpty(message="Este campo no puede estar vacio")
	@Size(message="El campo sobrepasa la cantidad de 50 caracteres", max=50)
	@Column(name="username")
	private String username;
	
	@NotEmpty(message="Este campo no puede estar vacio")
	@Size(message="El campo sobrepasa la cantidad de 50 caracteres", max=50)
	@Column(name="password")
	private String password;
	
	@NotNull
	@Column(name="enabled_u")
	private Boolean enabled_u;
	
	@NotEmpty(message="Este campo no puede estar vacio")
	@Size(message="El campo sobrepasa la cantidad de 50 caracteres", max=50)
	@Column(name="nombre")
	private String nombre;
	
	@NotEmpty(message="Este campo no puede estar vacio")
	@Size(message="El campo sobrepasa la cantidad de 50 caracteres", max=50)
	@Column(name="apellido")
	private String apellido;
	
	
	@NotNull
	@Column(name="fNac")
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Date fNac;
	
	@NotEmpty(message="Este campo no puede estar vacio")
	@NotNull
	@Column(name="direccion")
	private String direccion;
	
	@NotEmpty(message="Este campo no puede estar vacio")
	@Size(message="El campo sobrepasa la cantidad de 8 caracteres", max=8)
	@Column(name="telFijo")
	private String telFijo;
	
	@NotEmpty(message="Este campo no puede estar vacio")
	@Size(message="El campo sobrepasa la cantidad de 8 caracteres", max=8)
	@Column(name="telMovil")
	private String telMovil;
	
	//Foreign - Municipio
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_municipio")
	private Municipio municipio;
	
	@Transient
	private Integer id_municipio;
	
	//Foreign - roles
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_rol")
	private Roles roles;
	
	public Roles getRoles() {
		return roles;
	}

	public void setRoles(Roles roles) {
		this.roles = roles;
	}

	public Integer getId_rol() {
		return id_rol;
	}

	public void setId_rol(Integer id_rol) {
		this.id_rol = id_rol;
	}

	@Transient
	private Integer id_rol;
	
	public String getEstadoDelegate() {
		if(this.enabled_u==null) return "";
		else {
			return enabled_u == true ? "Disponible":"No Disponible";
		}
	}

	public Integer getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(Integer id_usuario) {
		this.id_usuario = id_usuario;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getEnabled_u() {
		return enabled_u;
	}

	public void setEnabled_u(Boolean enabled_u) {
		this.enabled_u = enabled_u;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Date getfNac() {
		//SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		//return formatter.format(fNac);
		return fNac;
	}

	public void setfNac(Date fNac) {
		this.fNac = fNac;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelFijo() {
		return telFijo;
	}

	public void setTelFijo(String telFijo) {
		this.telFijo = telFijo;
	}

	public String getTelMovil() {
		return telMovil;
	}

	public void setTelMovil(String telMovil) {
		this.telMovil = telMovil;
	}

	public Municipio getMunicipio() {
		return municipio;
	}

	public void setMunicipio(Municipio municipio) {
		this.municipio = municipio;
	}

	public Integer getId_municipio() {
		return id_municipio;
	}

	public void setId_municipio(Integer id_municipio) {
		this.id_municipio = id_municipio;
	}
	
	
	
}
