package com.uca.capas.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.domain.CentroEscolar;
import com.uca.capas.domain.Estudiante;
import com.uca.capas.dto.MateriaCursadaDTO;
import com.uca.capas.service.CentroEscolarService;
import com.uca.capas.service.EstudianteService;
import com.uca.capas.service.MateriaCursadaService;

@Controller
public class CoordinadorController {
	
	@Autowired
	private EstudianteService estudianteService;
	
	@Autowired
	private MateriaCursadaService materiaCursadaService;
	
	@Autowired
	private CentroEscolarService cEscolar;
	
	//Mostrar todos los expedientes
	@RequestMapping(value="/expedientes")
	public ModelAndView expedientes() {
		ModelAndView mav = new ModelAndView();
		List<MateriaCursadaDTO> expedientes = null;
		try {
			expedientes = materiaCursadaService.regitroDto();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		mav.addObject("expedientes", expedientes);
		mav.setViewName("listExpedientes");
		return mav;
	}
	
	//Agregar nuevo expediente
	
	@RequestMapping(value="/principal")
	public ModelAndView coordinadorMain() {
		ModelAndView mav = new ModelAndView();
		
		String mensaje ="";
		mav.addObject("mensaje", mensaje);
		mav.setViewName("main");
		return mav;
	}
	
	@RequestMapping("/ingresarEst")
	public ModelAndView ingresarEst() {
		ModelAndView mav = new ModelAndView();
		Estudiante estudiante = new Estudiante();
		estudiante.setfNac(new java.util.Date());
		
		List<CentroEscolar> cEscolares = null;
		try { cEscolares = cEscolar.findAll(); }
		catch(Exception e) { e.printStackTrace(); }
		
		mav.addObject("cEscolares", cEscolares);
		mav.addObject("estudiante", estudiante);
		mav.setViewName("ingresarEst");
		return mav;
	}
	
	@PostMapping("/validarEst")
	public ModelAndView validarEst(@Valid @ModelAttribute Estudiante estudiante, BindingResult result) {
		ModelAndView mav = new ModelAndView();
		if(result.hasErrors()) {
			estudiante.setfNac(new java.util.Date());
			
			List<CentroEscolar> cEscolares = null;
			try { cEscolares = cEscolar.findAll(); }
			catch(Exception e) { e.printStackTrace(); }
			
			mav.addObject("cEscolares", cEscolares);
			mav.addObject("estudiante", estudiante);
			mav.setViewName("ingresarEst");
		}else {
			try {
				estudianteService.save(estudiante);
			}catch(Exception e) {
				e.printStackTrace();
			}
			String mensaje ="Expediente creado con éxito";
			mav.addObject("mensaje", mensaje);
			mav.setViewName("main");
		}
		return mav;
	}
	
	
	//Actualizar Expediente
	
	@RequestMapping("/editar/expediente")
	public ModelAndView updateEst(@RequestParam(value= "id_estudiante") String id) {
		ModelAndView mav = new ModelAndView();
		Estudiante estudiante = null;
		List<CentroEscolar> cEscolares = null;
		Integer my_id = Integer.parseInt(id);
		try {
			cEscolares = cEscolar.findAll();
			estudiante = estudianteService.findOne(my_id);
		}catch(Exception e) {
			e.printStackTrace();
		}
		mav.addObject("cEscolares", cEscolares);
		mav.addObject("estudiante", estudiante);
		mav.setViewName("updateE");
		return mav;
	}
	
	@GetMapping("/actualizar/expediente/{id_estudiante}")
	public ModelAndView validarUpdateEst(@Valid @ModelAttribute Estudiante estudiante, BindingResult result, Model model) {
		ModelAndView mav = new ModelAndView();
		if(result.hasErrors()) {
			
			List<CentroEscolar> cEscolares = null;
			try { cEscolares = cEscolar.findAll(); }
			catch(Exception e) { e.printStackTrace(); }
			
			mav.addObject("cEscolares", cEscolares);
			mav.addObject("estudiante", estudiante);
			mav.setViewName("updateE");
		}else {
			try {
				estudianteService.save(estudiante);
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			List<MateriaCursadaDTO> expedientes = null;
			try {
				expedientes = materiaCursadaService.regitroDto();
			}catch(Exception e) {
				e.printStackTrace();
			}
			mav.addObject("expedientes", expedientes);
			mav.setViewName("listExpedientes");
		}
		return mav;
	}
	
	//Mostrar por nombre
	@RequestMapping(value="/busqueda", params="action=buscarnombre")
	public ModelAndView BuscarNom(@RequestParam(value="valNombre") String nombres) {
		ModelAndView mav = new ModelAndView();
		List<MateriaCursadaDTO> expedientes = null;
		try {
			expedientes = materiaCursadaService.buscarNombres(nombres);
		}catch(Exception e) {
			e.printStackTrace();
		}
		mav.addObject("expedientes", expedientes);
		mav.setViewName("listExpedientes");
		return mav;
	}
	
	@RequestMapping(value="/busqueda", params="action=buscarapellido")
	public ModelAndView BuscarApe(@RequestParam(value="valApellido") String apellidos) {
		ModelAndView mav = new ModelAndView();
		List<MateriaCursadaDTO> expedientes = null;
		try {
			expedientes = materiaCursadaService.buscarApellidos(apellidos);
		}catch(Exception e) {
			e.printStackTrace();
		}
		mav.addObject("expedientes", expedientes);
		mav.setViewName("listExpedientes");
		return mav;
	}
	
	
	

}
