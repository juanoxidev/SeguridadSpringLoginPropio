package com.juanSpring.SeguridadSpring.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

@Configuration
@EnableWebSecurity
public class SeguridadAppConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		// debemos conectar con una bd donde tenemos usuarios registrados con su rol/perfil
		UserBuilder usuarios = User.withDefaultPasswordEncoder();
		auth.inMemoryAuthentication().withUser(usuarios.username("Juan").password("123").roles("administrador"));
		auth.inMemoryAuthentication().withUser(usuarios.username("Ana").password("456").roles("ayudante"));
		auth.inMemoryAuthentication().withUser(usuarios.username("Laura").password("789").roles("usuario"));
		auth.inMemoryAuthentication().withUser(usuarios.username("Martin").password("000").roles("administrador"));
	}

}
