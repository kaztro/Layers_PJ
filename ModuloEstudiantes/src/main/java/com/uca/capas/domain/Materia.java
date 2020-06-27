package com.uca.capas.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(schema="public", name="MATERIA")
public class Materia {
	
	@Id
	@Column(name="id_materia")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id_materia;
	
	@Size(message="El campo sobrepasa la cantidad de 10 caracteres", max=10)
	@NotEmpty(message="El campo no puede estar vacio")
	private String materia;
	
	@NotEmpty(message="El campo no puede estar vacio")
	private String descripcion;
	
	@NotNull
	@Column(name="enabled_m", nullable=false)
	private Boolean enabled_m;
	
	//Delelgate
	public String getEstadoDelegate() {
		if(this.enabled_m==null) return "";
		else {
			return enabled_m == true ? "Disponible":"No Disponible";
		}
	}

	public Integer getId_materia() {
		return id_materia;
	}

	public void setId_materia(Integer id_materia) {
		this.id_materia = id_materia;
	}

	public String getMateria() {
		return materia;
	}

	public void setMateria(String materia) {
		this.materia = materia;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Boolean getEnabled_m() {
		return enabled_m;
	}

	public void setEnabled_m(Boolean enabled_m) {
		this.enabled_m = enabled_m;
	}
	
	

}
