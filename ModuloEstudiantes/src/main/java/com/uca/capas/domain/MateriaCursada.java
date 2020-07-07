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

@Entity
@Table(schema="public", name="MATERIA_CURSADA")
public class MateriaCursada {

	@Id
	@Column(name="id_materiaCursada")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id_materiaCursada;
	
	@NotEmpty(message="El campo no puede estar vacio")
	@Column(name="anho")
	private String anho;
	
	@NotEmpty(message="El campo no puede estar vacio")
	@Column(name="ciclo")
	private String ciclo;
	
	@NotEmpty(message="El campo no puede estar vacio")
	@Column(name="nota")
	private Float nota;
	
	//Foreign - Materia
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_materia")
	private Materia materia;
	
	@Transient
	private Integer id_materia;
	
	//Foreign - Estudiante
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_estudiante")
	private Estudiante estudiente;
	
	@Transient
	private Integer id_estudiante;

	public Integer getId_materiaCursada() {
		return id_materiaCursada;
	}

	public void setId_materiaCursada(Integer id_materiaCursada) {
		this.id_materiaCursada = id_materiaCursada;
	}

	public String getAno() {
		return anho;
	}

	public void setAno(String anho) {
		this.anho = anho;
	}

	public String getCiclo() {
		return ciclo;
	}

	public void setCiclo(String ciclo) {
		this.ciclo = ciclo;
	}

	public Float getNota() {
		return nota;
	}

	public void setNota(Float nota) {
		this.nota = nota;
	}

	public Materia getMateria() {
		return materia;
	}

	public void setMateria(Materia materia) {
		this.materia = materia;
	}

	public Integer getId_materia() {
		return id_materia;
	}

	public void setId_materia(Integer id_materia) {
		this.id_materia = id_materia;
	}

	public Estudiante getEstudiente() {
		return estudiente;
	}

	public void setEstudiente(Estudiante estudiente) {
		this.estudiente = estudiente;
	}

	public Integer getId_estudiante() {
		return id_estudiante;
	}

	public void setId_estudiante(Integer id_estudiante) {
		this.id_estudiante = id_estudiante;
	}
	
	
}
