package com.saswat23.shorturl.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity(debug = true)
public class AppSecurityConfig {
	
	@Bean
	public SecurityFilterChain securityFilterChain (HttpSecurity httpSecurity) throws Exception {
		
		// Authorize all the Requests
		httpSecurity.authorizeHttpRequests(request -> {
			request.anyRequest().authenticated();
		});

		//Enable BasicAuth - (Using username and pwd from the properties file)
		httpSecurity.httpBasic(Customizer.withDefaults());
		
		// Disable CSRF (to allow Post requests)
		httpSecurity.csrf(csrfCustomizer -> {
			csrfCustomizer.disable();
		});
		
		return httpSecurity.build();
	}
	
}
