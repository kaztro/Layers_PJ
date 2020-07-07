package com.uca.capas.dto;

public class ExpedienteDTO {
	
	private String id_estudiante;
	private String nombre;
	private String apellido;
	private String aprobadas;
	private String reprobadas;
	private String promedio;
	
	public String getId_estudiante() {
		return id_estudiante;
	}
	public void setId_estudiante(String id_estudiante) {
		this.id_estudiante = id_estudiante;
	}
	public String getNombre() {
		return nombre;
	}
	public String getAprobadas() {
		return aprobadas;
	}
	public void setAprobadas(String aprobadas) {
		this.aprobadas = aprobadas;
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
	public String getAprovadas() {
		return aprobadas;
	}
	public void setAprovadas(String aprobadas) {
		this.aprobadas = aprobadas;
	}
	public String getReprobadas() {
		return reprobadas;
	}
	public void setReprobadas(String reprobadas) {
		this.reprobadas = reprobadas;
	}
	public String getPromedio() {
		return promedio;
	}
	public void setPromedio(String promedio) {
		this.promedio = promedio;
	}
	

}
