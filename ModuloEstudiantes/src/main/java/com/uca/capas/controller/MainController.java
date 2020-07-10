package com.uca.capas.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.domain.Departamento;
import com.uca.capas.domain.Municipio;
import com.uca.capas.domain.Roles;
import com.uca.capas.domain.Usuario;
import com.uca.capas.service.DepartamentoService;
import com.uca.capas.service.EstudianteService;
import com.uca.capas.service.MateriaService;
import com.uca.capas.service.MunicipioService;
import com.uca.capas.service.RolesService;
import com.uca.capas.service.UsuarioService;

@Controller
public class MainController {
	
	
	
	@Autowired
	private EstudianteService estudianteService;
	
	@Autowired
	private DepartamentoService departamento;
	
	@Autowired
	private MateriaService materia;
	
	@Autowired
	private MunicipioService municipio;
	
	@Autowired
	private DepartamentoService departamentoService;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private RolesService rolesService;
	
	
	/*-------------GUARDAR USUARIOS NUEVOS-----------*/
	
	@RequestMapping("/login")
	public ModelAndView login() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("login");
		return mav;
	}

	@RequestMapping("/crearUsuario")
	public ModelAndView crearUsuario() {
		ModelAndView mav = new ModelAndView();
		Usuario usuario = new Usuario();
		
		List<Roles> roles = null;
		List<Municipio> municipios = null;
		List<Departamento> departamentos = null;
		try {roles = rolesService.findAll();
			 municipios = municipio.findAll();
			 departamentos = departamentoService.findAll();
			 
		}
		catch(Exception e) {e.printStackTrace();}
		
		mav.addObject("departamentos", departamentos);
		mav.addObject("municipios", municipios);
		mav.addObject("roles",roles);
		mav.addObject("usuario", usuario);
		mav.setViewName("createUsuario");
		
		
		return mav;
	}
	
	@PostMapping("/ingresarUsuario")
	public ModelAndView guardar(@Valid @ModelAttribute Usuario usuario, BindingResult result) {
		ModelAndView mav = new ModelAndView();
		
		if(result.hasErrors()) {
			mav.setViewName("createUsuario");
			List<Roles> roles = null;
			List<Municipio> municipios = null;
			List<Departamento> departamentos = null;
			try {roles = rolesService.findAll();
				 municipios = municipio.findAll();
				 departamentos = departamentoService.findAll();
				}
			catch(Exception e) {e.printStackTrace();}
			
			mav.addObject("departamentos", departamentos);
			mav.addObject("municipios", municipios);
			mav.addObject("roles", roles);
			mav.addObject("usuario", usuario);
			mav.setViewName("createUsuario");
		}else {
			try {
				usuarioService.save(usuario);
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			
			mav.setViewName("redirect:/");
		}
		
		return mav;
		
	}
	
	@RequestMapping("/admin")
	public ModelAndView admin() {
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("redirect:/");
		return mav;
		
	}
	
	@RequestMapping("/403")
	public ModelAndView error() {
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("403");
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
}
