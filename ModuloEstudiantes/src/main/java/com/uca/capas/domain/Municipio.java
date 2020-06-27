package com.uca.capas.domain;

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

@Entity
@Table(schema="public", name="MUNICIPIO")
public class Municipio {

	@Id
	@Column(name="id_municipio")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id_municipio;

	@Column(name="municipio")
	private String municipio;
	
	//FOREIGN - DEPARTAMENTO
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_depart")
	private Departamento departamento;
	
	@Transient
	private Integer id_depart;

	public Integer getId_municipio() {
		return id_municipio;
	}

	public void setId_municipio(Integer id_municipio) {
		this.id_municipio = id_municipio;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public Integer getId_depart() {
		return id_depart;
	}

	public void setId_depart(Integer id_depart) {
		this.id_depart = id_depart;
	}
	
	
}
