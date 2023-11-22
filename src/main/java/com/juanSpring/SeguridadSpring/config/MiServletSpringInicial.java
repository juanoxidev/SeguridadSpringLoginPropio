package com.juanSpring.SeguridadSpring.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class MiServletSpringInicial extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// Aca indicamos las clases de la raiz 
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		// Aca debemos indicar la clase donde se encuentra la configuracion  
		return new Class[] {App.class};
	}

	@Override
	protected String[] getServletMappings() {
		// Aca debemos indicar el mapeo del servlet
		return new String[] {"/"};
	}

}
