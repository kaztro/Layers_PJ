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
import com.uca.capas.domain.Departamento;
import com.uca.capas.domain.Estudiante;
import com.uca.capas.domain.Municipio;
import com.uca.capas.domain.Materia;
import com.uca.capas.domain.MateriaCursada;
import com.uca.capas.dto.ExpedienteDTO;
import com.uca.capas.dto.MateriaCursadaDTO;
import com.uca.capas.service.CentroEscolarService;
import com.uca.capas.service.DepartamentoService;
import com.uca.capas.service.EstudianteService;
import com.uca.capas.service.MateriaCursadaService;
import com.uca.capas.service.MunicipioService;
import com.uca.capas.service.MateriaService;


@Controller
public class CoordinadorController {
	
	@Autowired
	private EstudianteService estudianteService;
	
	@Autowired
	private MateriaCursadaService materiaCursadaService;
	
	@Autowired
	private CentroEscolarService cEscolar;
	
	@Autowired
	private DepartamentoService departamentoService; 
	
	@Autowired
	private MunicipioService municipioService;
	
	@Autowired
	private MateriaService materiaService;
	
	//Mostrar todos los expedientes
	@RequestMapping(value="/expedientes")
	public ModelAndView expedientes() {
		ModelAndView mav = new ModelAndView();
		List<ExpedienteDTO> expedientes = null;
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
	//INGRESAR ESTUDIANTE NUEVO
	@RequestMapping("/ingresarEst")
	public ModelAndView ingresarEst() {
		ModelAndView mav = new ModelAndView();
		Estudiante estudiante = new Estudiante();
		estudiante.setfNac(new java.util.Date());
		
		List<Departamento> departamentos = null;
		List<Municipio> municipios = null;
		List<CentroEscolar> cEscolares = null;
		try { 
			cEscolares = cEscolar.findAll();
			departamentos = departamentoService.findAll();
			municipios = municipioService.findAll();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		mav.addObject("departamentos", departamentos);
		mav.addObject("municipios", municipios);
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
	
	
	//Actualizar Expediente - POR ID
	
	@RequestMapping("/editar/expediente")
	public ModelAndView updateEst(@RequestParam(value= "id_estudiante") String id) {
		
		ModelAndView mav = new ModelAndView();
		
		List<CentroEscolar> cEscolares = null;
		List<Departamento> departamentos = null;
		List<Municipio> municipios = null;
		Estudiante estudiante = estudianteService.findOne(Integer.parseInt(id));
		try {
			cEscolares = cEscolar.findAll();
			departamentos = departamentoService.findAll();
			municipios = municipioService.findAll();
		}catch(Exception e) {
			e.printStackTrace();
		}
		mav.addObject("departamentos", departamentos);
		mav.addObject("municipios", municipios);
		mav.addObject("cEscolares", cEscolares);
		mav.addObject("estudiante", estudiante);
		
		mav.setViewName("updateE");
		return mav;
	}
	
	@RequestMapping("/actualizar/expediente/")
	public ModelAndView validarUpdateEst(@Valid @ModelAttribute Estudiante estudiante, @RequestParam(value= "id_estudiante") String id, BindingResult result) {
		ModelAndView mav = new ModelAndView();
		
		if(result.hasErrors()) {
			List<CentroEscolar> cEscolares = null;
			List<Departamento> departamentos = null;
			List<Municipio> municipios = null;
			cEscolares = cEscolar.findAll();
			departamentos = departamentoService.findAll();
			municipios = municipioService.findAll();
			estudiante = estudianteService.findOne(Integer.parseInt(id));
			
			mav.addObject("departamentos", departamentos);
			mav.addObject("municipios", municipios);
			mav.addObject("cEscolares", cEscolares);
			mav.addObject("estudiante", estudiante);
			
			mav.setViewName("updateE");
		}else {
			estudianteService.save(estudiante);
			mav.addObject("mensaje", "Estudiantes actualizado con exito");
			mav.setViewName("main");
		}
		return mav;
	}
	
	
	//Actualizar materias cursadas por id
	
	@RequestMapping("/editar/materiaCursada")
	public ModelAndView updateMatCurs(@RequestParam(value= "id_materiaCursada") String id) {
		
		ModelAndView mav = new ModelAndView();
		
		List<Materia> materias = null;
		MateriaCursada materiaCursada = materiaCursadaService.findOne(Integer.parseInt(id));
		try {
			materias = materiaService.findAll();
		}catch(Exception e) {
			e.printStackTrace();
		}
		mav.addObject("materias", materias);
		mav.addObject("materiaCursada", materiaCursada);
		
		mav.setViewName("updateMateriaCursada");
		return mav;
		
	}
	
	@RequestMapping("/add/materiaCursada")
	public ModelAndView addMatCurs(@RequestParam(value= "id_guardado") String id) {
		
		ModelAndView mav = new ModelAndView();
		
		List<Materia> materias = null;
		MateriaCursada materiaCursada = materiaCursadaService.findOne(Integer.parseInt(id));
		try {
			materias = materiaService.findAll();
		}catch(Exception e) {
			e.printStackTrace();
		}
		mav.addObject("materias", materias);
		mav.addObject("materiaCursada", materiaCursada);
		
		mav.setViewName("updateMateriaCursada");
		return mav;
		
	}
	
	
	@GetMapping("/actualizar/materiaCursada/{materiaCursada}")
	public ModelAndView validarUpdateMatCurs(@Valid @ModelAttribute MateriaCursada materiaCursada, BindingResult result) {
		ModelAndView mav = new ModelAndView();
		
		if(result.hasErrors()) {	
			List<Materia> materias = null;
			try {
				materias = materiaService.findAll();
			}catch(Exception e) {
				e.printStackTrace();
			}
			mav.addObject("materias", materias);
			mav.addObject("materiaCursada", materiaCursada);
			
			mav.setViewName("updateMateriaCursada");
		}else {
			
			materiaCursadaService.save(materiaCursada);
						
			String mensaje ="Materia cursada actualizada";
			mav.addObject("mensaje", mensaje);
			mav.setViewName("main");
		}
		return mav;
	}
	
	
	
	//VER MATERIAS CURSADAS
	@RequestMapping("/materiasCursadas")
	public ModelAndView updateEstMat(@RequestParam(value= "id_estudianteM") String id) {
		
		ModelAndView mav = new ModelAndView();
		List<MateriaCursadaDTO> expedientes = null;
		String id_guardado = id;
		
		try {
			expedientes = materiaCursadaService.mostrarMaterias(Integer.parseInt(id));
		}catch(Exception e) {
			e.printStackTrace();
		}
		mav.addObject("expedientes", expedientes);
		mav.addObject("id_guardado", id_guardado);
		mav.setViewName("MatCursadas");
		return mav;
	}
	
	//Mostrar por nombre
	@RequestMapping(value="/busqueda", params="action=buscarnombre")
	public ModelAndView BuscarNom(@RequestParam(value="valNombre") String nombres) {
		ModelAndView mav = new ModelAndView();
		List<ExpedienteDTO> expedientes = null;
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
		List<ExpedienteDTO> expedientes = null;
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
