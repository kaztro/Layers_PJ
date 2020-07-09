package com.uca.capas.domain;

import java.text.SimpleDateFormat;
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
@Table(schema="public", name="ESTUDIANTE")
public class Estudiante {
	
	@Id
	@Column(name="id_estudiante")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id_estudiante;
	
	@Size(message="El campo sobrepasa la cantidad de 80 caracteres", max=80)
	@NotEmpty(message="El campo no puede estar vacio")
	@Column(name="nombres")
	private String nombres;
	
	@Size(message="El campo sobrepasa la cantidad de 80 caracteres", max=80)
	@NotEmpty(message="El campo no puede estar vacio")
	@Column(name="apellidos")
	private String apellidos;
	
	@NotEmpty(message="El campo no puede estar vacio")
	@Column(name="cMinoridad")
	private String cMinoridad;
	
	@NotNull(message = "El campo Fecha no puede quedar vacio y el formato debe de ser dd/MM/yyyy")
	@Column(name="fNac")
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Date fNac;
	
	@NotEmpty(message="El campo no puede estar vacio")
	@Column(name="direccion")
	private String direccion;
	
	@Size(message="El campo sobrepasa la cantidad de 8 caracteres", max=8)
	@NotEmpty(message="El campo no puede estar vacio")
	@Column(name="telFijo")
	private String telFijo;
	
	@Size(message="El campo sobrepasa la cantidad de 8 caracteres", max=8)
	@NotEmpty(message="El campo no puede estar vacio")
	@Column(name="telMovil")
	private String telMovil;
	
	@Size(message="El campo sobrepasa la cantidad de 50 caracteres", max=50)
	@NotEmpty(message="El campo no puede estar vacio")
	@Column(name="nombreMadre")
	private String nombreMadre;
	
	@Size(message="El campo sobrepasa la cantidad de 50 caracteres", max=50)
	@NotEmpty(message="El campo no puede estar vacio")
	@Column(name="nombrePadre")
	private String nombrePadre;
	
	//Foreign - Centros Escolares
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_centro")
	private CentroEscolar centroEscolar;
	
	@Transient
	private Integer id_centro;

	public Integer getId_estudiante() {
		return id_estudiante;
	}

	public void setId_estudiante(Integer id_estudiante) {
		this.id_estudiante = id_estudiante;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getcMinoridad() {
		return cMinoridad;
	}

	public void setcMinoridad(String cMinoridad) {
		this.cMinoridad = cMinoridad;
	}

	public Date getfNac() {
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

	public String getNombreMadre() {
		return nombreMadre;
	}

	public void setNombreMadre(String nombreMadre) {
		this.nombreMadre = nombreMadre;
	}

	public String getNombrePadre() {
		return nombrePadre;
	}

	public void setNombrePadre(String nombrePadre) {
		this.nombrePadre = nombrePadre;
	}

	public CentroEscolar getCentroEscolar() {
		return centroEscolar;
	}

	public void setCentroEscolar(CentroEscolar centroEscolar) {
		this.centroEscolar = centroEscolar;
	}

	public Integer getId_centro() {
		return id_centro;
	}

	public void setId_centro(Integer id_centro) {
		this.id_centro = id_centro;
	}
	
}
