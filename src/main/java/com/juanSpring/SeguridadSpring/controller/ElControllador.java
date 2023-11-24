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
	
	// agregando Mapping a administradores
	
	@RequestMapping("/administradores")
	public String muestraAdministradores() {
		// nombre JSP
		return "paneladmin";
	}
	
	@RequestMapping("/acceso-denegado")
	public String muestraAccesoDenegado() {
		// nombre JSP
		return "acceso-denegado";
	}
	
	
}
