package com.juanSpring.SeguridadSpring.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
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
		auth.inMemoryAuthentication().withUser(usuarios.username("Juan").password("123").roles("usuario","administrador"));
		auth.inMemoryAuthentication().withUser(usuarios.username("Ana").password("456").roles("usuario","ayudante"));
		auth.inMemoryAuthentication().withUser(usuarios.username("Laura").password("789").roles("usuario"));
		auth.inMemoryAuthentication().withUser(usuarios.username("Martin").password("000").roles("usuario","administrador"));
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// indicamos que envie un formulario cuando ingrese una peticion de un usuario que no esta autenticado, el loginPage va a ser la url por donde ingrese la peticion y el processingURL es el accion del form de ese formulario de login
	// indicamos que permita el logout.
		//http.authorizeRequests().anyRequest().authenticated().and().formLogin()
		
		// indicamos quien puede ingresar a "/" que deben ser todos los roles, es como una piramide primero son usuarios y luego se dice q tipo ej administador ayudante o solo usuarios comunes.
		/*
		 * antMatchers define la ruta y lugo con hasRole indica que rol puede ingresar
		  Si en la url de antmatcher senialamos /url/** los que solamente pueden ingresar a /administrador/suburl van a poder ser los que esten indicados en hasRole().
		 */
				http.authorizeRequests()
				.antMatchers("/").hasRole("usuario")
				.antMatchers("/administradores/**").hasRole("administrador")
				.and().formLogin().loginPage("/loginform").loginProcessingUrl("/autenticacionUsuario").permitAll().and().logout().permitAll()
				.and().exceptionHandling().accessDeniedPage("/acceso-denegado");
	}
	
	

}
