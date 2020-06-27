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
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(schema="public", name="CENTROS_ESCOLARES")
public class CentroEscolar {
	
	@Id
	@Column(name="id_centro")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id_centro;
	
	@Size(message="El campo no debe contener mas de 80 caractares", max=80)
	@NotEmpty(message="Este campo no puede estar vacio")
	@Column(name="nombre")
	private String nombre;
	
	@NotEmpty(message="Este campo no puede estar vacio")
	@Column(name="descripcion")
	private String descripcion;
	
	@NotNull
	@Column(name="enabled_ce", nullable=false)
	private Boolean enabled_ce;
	
	//Foreign - MUNICIPIO
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_municipio")
	private Municipio municipio;
	
	@Transient
	private Integer id_municipio;

	//Delegate
	public String getEstadoDelegate() {
		if(this.enabled_ce==null) return "";
		else {
			return enabled_ce == true ? "Disponible":"No Disponible";
		}
	}
	
	public Integer getId_centro() {
		return id_centro;
	}

	public void setId_centro(Integer id_centro) {
		this.id_centro = id_centro;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Boolean getEnabled_ce() {
		return enabled_ce;
	}

	public void setEnabled_ce(Boolean enabled_ce) {
		this.enabled_ce = enabled_ce;
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
