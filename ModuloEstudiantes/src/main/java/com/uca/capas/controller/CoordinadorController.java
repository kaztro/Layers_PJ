package com.uca.capas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.dto.MateriaCursadaDTO;
import com.uca.capas.service.MateriaCursadaService;

@Controller
public class CoordinadorController {
	
	@Autowired
	private MateriaCursadaService materiaCursadaService;
	
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

}
