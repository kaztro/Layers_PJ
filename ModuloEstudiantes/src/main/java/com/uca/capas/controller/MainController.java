package com.uca.capas.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.domain.CentroEscolar;
import com.uca.capas.domain.Departamento;
import com.uca.capas.domain.Estudiante;
import com.uca.capas.domain.Materia;
import com.uca.capas.domain.Municipio;
import com.uca.capas.domain.Usuario;
import com.uca.capas.service.CentroEscolarService;
import com.uca.capas.service.DepartamentoService;
import com.uca.capas.service.EstudianteService;
import com.uca.capas.service.MateriaService;
import com.uca.capas.service.MunicipioService;
import com.uca.capas.service.UsuarioService;

@Controller
public class MainController {
	
	@Autowired
	private EstudianteService estudianteService;
	
	@Autowired
	private DepartamentoService departamento;
	
	//@Autowired
	//private CentroEscolarService cEscolar;
	
	@Autowired
	private MateriaService materia;
	
	@Autowired
	private MunicipioService municipio;
	
	@Autowired
	private UsuarioService usuario;
	
	/*--------LISTAS QUE SE MOSTRARAN-----------*/
	@RequestMapping("/listEstud")
	public ModelAndView listEstud() {
		ModelAndView mav = new ModelAndView();
		
		List<Estudiante> estudiantes = null;
		try { estudiantes = estudianteService.findAll(); }
		catch (Exception e) { e.printStackTrace(); }
		
		mav.addObject("estudiantes", estudiantes);
		mav.setViewName("listEstud");
		
		return mav;
	}
	/*----------------------------------------------*/
	
	/*--------INGRESAR CAMPOS A TABLAS-----------*/
	//Probablemente en AdminController
	
	@RequestMapping("/ingresarMat")
	public ModelAndView ingresarMat() {
		ModelAndView mav = new ModelAndView();
		Materia materia = new Materia();
		mav.addObject("materia", materia);
		mav.setViewName("ingresarMat");
		return mav;
	}
	
	@RequestMapping("/admin")
	public ModelAndView admin() {
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("admin");
		return mav;
		
	}
	
	
	public ModelAndView ingresarUser() {
		ModelAndView mav = new ModelAndView();
		Usuario usuario = new Usuario();
		usuario.setfNac((new java.util.Date()));;
		
		List<Departamento> departamentos = null;
		try { departamentos = departamento.findAll(); }
		catch(Exception e) { e.printStackTrace(); }
		
		List<Municipio> municipios = null;
		try { municipios = municipio.findAll(); }
		catch(Exception e) { e.printStackTrace(); }
		
		mav.addObject("departamentos", departamentos);
		mav.addObject("municipios", municipios);
		mav.addObject("usuario", usuario);
		mav.setViewName("ingresarUser");
		return mav;
	}
	/*----------------------------------------------*/
	
}
