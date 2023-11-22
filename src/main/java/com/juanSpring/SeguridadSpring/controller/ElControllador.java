package com.juanSpring.SeguridadSpring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ElControllador {
// URL 
	@RequestMapping("/")
	public String muestraInicio() {
		// nombre JSP
		return "inicio";
	}
}
