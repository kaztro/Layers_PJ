package com.uca.capas.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.domain.CentroEscolar;
import com.uca.capas.domain.Departamento;
import com.uca.capas.domain.Materia;
import com.uca.capas.domain.Municipio;
import com.uca.capas.domain.Usuario;
import com.uca.capas.service.CentroEscolarService;
import com.uca.capas.service.DepartamentoService;
import com.uca.capas.service.MateriaService;
import com.uca.capas.service.MunicipioService;
import com.uca.capas.service.UsuarioService;

@Controller
public class AdminController {

	@Autowired
	private CentroEscolarService centroEscolarService;

	@Autowired
	private MateriaService materiaService;

	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	private MunicipioService municipioService;
	
	@Autowired
	private DepartamentoService departamentoService;

	/*--------LISTAS QUE SE MOSTRARAN-----------*/

	
	
	
	@RequestMapping("/admin/listMaterias")
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

	@RequestMapping("/admin/listCEscolares")
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

	@RequestMapping("/admin/listUsuarios")
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
	
	
	@RequestMapping("/admin/ingresarMateria")
	public ModelAndView ingresarMateria() {
		ModelAndView mav = new ModelAndView();
		Materia materia =  new Materia();
		mav.addObject("materia", materia);
		mav.setViewName("ingresarMateriaNueva");
		return mav;
	}
	
	@RequestMapping("/admin/ingresarMateriaNueva")
	public ModelAndView ingresarMateriaNueva(@Valid @ModelAttribute Materia materia, BindingResult  result) {
		ModelAndView mav = new ModelAndView();
		if(result.hasErrors()) {
			mav.setViewName("ingresarMateriaNueva");
		}else {
			
			materiaService.save(materia);
			mav.setViewName("redirect:/admin/listMaterias");
		}
		
		return mav;
	}

	// UPDATE - Materia

	@GetMapping("editar/materia/{id_materia}")
	public String formularioActualizacionMat(@PathVariable("id_materia") int id, Model model) {
		Materia materia = this.materiaService.findOne(id);

		model.addAttribute("materia", materia);
		return "updateMat";
	}

	@GetMapping("actualizar/materia/{id_materia}")
	public ModelAndView updateMat(@Valid Materia materia, BindingResult result, Model model) {
		ModelAndView mav = new ModelAndView();
		if (result.hasErrors()) {
			mav.setViewName("updateMat");
		} else {
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

	// update - Centros escolaares

	@GetMapping("editar/centro/{id_centro}")
	public ModelAndView formularioActualizacionCE(@PathVariable("id_centro") int id, Model model) {

		ModelAndView mav = new ModelAndView();
		CentroEscolar centroEscolar = this.centroEscolarService.findOne(id);

		List<Municipio> municipios = municipioService.findAll();

		model.addAttribute("centroEscolar", centroEscolar);
		mav.addObject("municipios", municipios);
		mav.setViewName("updateCE");
		return mav;
	}

	@GetMapping("actualizar/centro/{id_centro}")
	public ModelAndView updateCE(@Valid CentroEscolar centroEscolar, BindingResult result, Model model) {
		ModelAndView mav = new ModelAndView();

		if (result.hasErrors()) {
			mav.setViewName("updateCE");
		} else {
			centroEscolarService.save(centroEscolar);

			model.addAttribute("centrosEscolares", this.centroEscolarService.findAll());

			List<CentroEscolar> cEscolares = null;
			try {
				cEscolares = centroEscolarService.findAll();
			} catch (Exception e) {
				e.printStackTrace();
			}

			mav.addObject("centroEscolar", new CentroEscolar());
			mav.addObject("cEscolares", cEscolares);
			mav.setViewName("listCEsc");
		}
		return mav;
	}

	// update - Usuarios

	@GetMapping("editar/usuario/{id_usuario}")
	public String formularioActualizacionU(@PathVariable("id_usuario") int id, Model model) {
		Usuario usuario = this.usuarioService.findOne(id);

		model.addAttribute("usuario", usuario);
		return "updateU";
	}

	@GetMapping("actualizar/usuario/{id_usuario}")
	public ModelAndView updateU(@Valid Usuario usuario, BindingResult result, Model model) {
		ModelAndView mav = new ModelAndView();
		if (result.hasErrors()) {
			mav.setViewName("updateU");
		} else {
			usuarioService.save(usuario);

			model.addAttribute("usuarios", this.usuarioService.findAll());

			List<Usuario> usuariosL = null;
			try {
				usuariosL = usuarioService.findAll();
			} catch (Exception e) {
				e.printStackTrace();
			}

			mav.addObject("usuario", new Usuario());
			mav.addObject("usuariosL", usuariosL);
			mav.setViewName("listUsers");
		}
		return mav;
	}
	
	// Add - CE
	@RequestMapping("/admin/ingresarCE")
	public ModelAndView ingresarCE() {
		ModelAndView mav = new ModelAndView();
			List<Departamento> departamentos = null;
			List<Municipio> municipios = null;
			departamentos = departamentoService.findAll();
			municipios = municipioService.findAll();
			
			mav.addObject("departamentos", departamentos);
			mav.addObject("municipios", municipios);
			mav.addObject("centroEscolar", new CentroEscolar());
			mav.setViewName("addCE");
		
		return mav;
	}
	
	@RequestMapping("/admin/validar/ingresarCE")
	public ModelAndView validarrCE(@Valid CentroEscolar centroEscolar, BindingResult result) {
		ModelAndView mav = new ModelAndView();
		if(result.hasErrors()) {
			List<Departamento> departamentos = null;
			List<Municipio> municipios = null;
			departamentos = departamentoService.findAll();
			municipios = municipioService.findAll();
			
			mav.addObject("departamentos", departamentos);
			mav.addObject("municipios", municipios);
			
			mav.setViewName("addCE");
		} else {	
			List<CentroEscolar> cEscolares = null;
			try {
				centroEscolarService.save(centroEscolar);
				cEscolares = centroEscolarService.findAll();
			} catch (Exception e) {
				e.printStackTrace();
			}

			mav.addObject("centroEscolar", new CentroEscolar());
			mav.addObject("cEscolares", cEscolares);
			mav.setViewName("listCEsc");
		}
		return mav;
	}
}
