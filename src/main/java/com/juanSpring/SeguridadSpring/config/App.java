package com.juanSpring.SeguridadSpring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.juanSpring.SeguridadSpring")

public class App {

	/*
	 * ViewResolver: se encarga de resolver las vistas de los recursos internos,
	 * aqui se almacenara la vista que queremos q nos devuelva, hay que indicarle la
	 * ruta donde se van a encontrar esas vistas que nos va a devolver y tambien la
	 * extension que van a tener esas vistas.
	 */
	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		// marcamos a nuestro proyecto que antes del nombre de la vista tiene q estar esta ruta	
		viewResolver.setPrefix("WEB-INF/view/");
		// marcamos a nuestro proyecto que depsues del nombre de la vista tiene q estar
		// esta extension
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}
}
