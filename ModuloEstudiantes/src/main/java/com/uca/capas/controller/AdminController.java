package com.uca.capas.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.domain.CentroEscolar;
import com.uca.capas.domain.Materia;
import com.uca.capas.domain.Usuario;
import com.uca.capas.service.CentroEscolarService;
import com.uca.capas.service.MateriaService;
import com.uca.capas.service.UsuarioService;

@Controller
public class AdminController {

	@Autowired
	private CentroEscolarService centroEscolarService;

	@Autowired
	private MateriaService materiaService;

	@Autowired
	private UsuarioService usuarioService;

	/*--------LISTAS QUE SE MOSTRARAN-----------*/

	@RequestMapping("/listMaterias")
	public ModelAndView listMaterias() {
		ModelAndView mav = new ModelAndView();

		List<Materia> materiasL = null;
		try {
			materiasL = materiaService.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}

		mav.addObject("materia", new Materia());
		mav.addObject("materiasL", materiasL);
		mav.setViewName("listMat");

		return mav;
	}

	@RequestMapping("/listCEscolares")
	public ModelAndView listCEscolares() {
		ModelAndView mav = new ModelAndView();

		List<CentroEscolar> cEscolares = null;
		try {
			cEscolares = centroEscolarService.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}

		mav.addObject("centroEscolar", new CentroEscolar());
		mav.addObject("cEscolares", cEscolares);
		mav.setViewName("listCEsc");

		return mav;
	}

	@RequestMapping("/listUsuarios")
	public ModelAndView listUsuarios() {
		ModelAndView mav = new ModelAndView();

		List<Usuario> usuarios = null;
		try {
			usuarios = usuarioService.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}

		mav.addObject("usuario", new Usuario());
		mav.addObject("usuarios", usuarios);
		mav.setViewName("listUsers");

		return mav;
	}
	
	//UPDATE - Materia

	@GetMapping("editar/materia/{id_materia}")
	public String formularioActualizacion(@PathVariable("id_materia") int id, Model model) {
		Materia materia = this.materiaService.findOne(id);

		model.addAttribute("materia", materia);
		return "updateMat";
	}

	@GetMapping("actualizar/materia/{id_materia}")
	public ModelAndView update(@Valid Materia materia,
			BindingResult result, Model model) {
		ModelAndView mav = new ModelAndView();
		if(result.hasErrors()) {
			mav.setViewName("actualizar");
		}else {
		materiaService.save(materia);
		
		model.addAttribute("materias", this.materiaService.findAll());

		List<Materia> materiasL = null;
		try {
			materiasL = materiaService.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}

		mav.addObject("materia", new Materia());
		mav.addObject("materiasL", materiasL);
		mav.setViewName("listMat");
		}
		return mav;
	}
	
	//update - Centros escolaares
	
	@GetMapping("editar/centro/{id_materia}")
	public String formularioActualizacionCE(@PathVariable("id_centro") int id, Model model) {
		CentroEscolar centroEscolar = this.centroEscolarService.findOne(id);

		model.addAttribute("centroEscolar", centroEscolar);
		return "updateCE";
	}

	@GetMapping("actualizar/centro/{id_materia}")
	public ModelAndView updateCE(@Valid Materia materia,
			BindingResult result, Model model) {
		ModelAndView mav = new ModelAndView();
		
		if(result.hasErrors()) {
			mav.setViewName("actualizar");
		}else {
		materiaService.save(materia);
		
		model.addAttribute("centrosEscolares", this.centroEscolarService.findAll());

		List<CentroEscolar> centrosL = null;
		try {
			centrosL = centroEscolarService.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}

		mav.addObject("centroEscolar", new CentroEscolar());
		mav.addObject("centroL", centrosL);
		mav.setViewName("listCEsc");
		}
		return mav;
	}
	
	//update - Usuarios

}
