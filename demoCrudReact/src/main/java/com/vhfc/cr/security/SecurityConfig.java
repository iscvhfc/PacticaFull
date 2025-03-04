package com.vhfc.cr.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.SessionManagementConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
 /*establecemos el Compartamiento de acceso a la APP como una atentication basica */
	@Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
                               
                .csrf(Customizer.withDefaults())
                .authorizeHttpRequests(authorize -> {                	               
                authorize.requestMatchers("/producto").permitAll();
                authorize.anyRequest().authenticated();
                })
                
                .sessionManagement(session -> {
                    session.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
                })
                
                .httpBasic(Customizer.withDefaults())
                .formLogin(Customizer.withDefaults());
            return http.build();
               
              

	}
	// Autentication basic en memoria, con ususrio registrado en memoria, que se administra atravez de AutenticationManager 
	@Bean
	UserDetailsService userDetailsService () {
		InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
		manager.createUser(User.withUsername("fulano")// usuario, username 
				.password("2357")// Password clave de acceso 
				.roles()
				.build());
		return manager;
	}
	
	@SuppressWarnings("deprecation")
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@SuppressWarnings("removal")
	@Bean
	AuthenticationManager auteAuthenticationManager(HttpSecurity httpSecurity, PasswordEncoder passwordEncoder) throws Exception{
		return httpSecurity.getSharedObject(AuthenticationManagerBuilder.class)
			.userDetailsService(userDetailsService())
			.passwordEncoder(passwordEncoder)
			.and()
			.build();
	}
}
