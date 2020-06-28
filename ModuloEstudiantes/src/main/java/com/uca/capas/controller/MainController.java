package com.uca.capas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.domain.Estudiante;
import com.uca.capas.domain.Materia;
import com.uca.capas.service.CentroEscolarService;
import com.uca.capas.service.DepartamentoService;
import com.uca.capas.service.EstudianteService;
import com.uca.capas.service.MateriaService;
import com.uca.capas.service.MunicipioService;
import com.uca.capas.service.UsuarioService;

@Controller
public class MainController {
	
	@Autowired
	private EstudianteService estudiante;
	
	@Autowired
	private DepartamentoService departamento;
	
	@Autowired
	private CentroEscolarService cEscolar;
	
	@Autowired
	private MateriaService materia;
	
	@Autowired
	private MunicipioService municipio;
	
	@Autowired
	private UsuarioService usuario;
	
	/*--------EXPENDIENTES QUE SE MOSTRARAN-----------*/
	@RequestMapping("/listEstud")
	public ModelAndView listEstud() {
		ModelAndView mav = new ModelAndView();
		
		List<Estudiante> estudiantes = null;
		try {
			
			estudiantes = estudiante.findAll();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		mav.addObject("estudiantes", estudiantes);
		mav.setViewName("listEstud");
		
		return mav;
	}
	
	@RequestMapping("/listMat")
	public ModelAndView listMat() {
		ModelAndView mav = new ModelAndView();
		
		List<Materia> materias = null;
		try {
			
			materias = materia.findAll();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		mav.addObject("materias", materias);
		mav.setViewName("listMat");
		
		return mav;
	}
	/*----------------------------------------------*/
	
	/*---------CATALOGOS QUE SE MOSTRARAN-----------*/
	@RequestMapping("/listMat")
	public ModelAndView listMat() {
		ModelAndView mav = new ModelAndView();
		
		List<Materia> materias = null;
		try {
			
			materias = materia.findAll();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		mav.addObject("materias", materias);
		mav.setViewName("listMat");
		
		return mav;
	}
	/*----------------------------------------------*/
}

