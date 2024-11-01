package com.saswat23.shorturl.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.saswat23.shorturl.security.CustomUserDetailsService;

@Configuration
@EnableWebSecurity
public class AppSecurityConfig {
	
	@Bean
	public SecurityFilterChain securityFilterChain (HttpSecurity httpSecurity) throws Exception {
		
		// Authorize all the Requests
		// Skip the registration endpoint
		httpSecurity.authorizeHttpRequests(request -> {
			request.requestMatchers("/","/home","/user/register","/shorten/**","/redirect/**").permitAll()
					.anyRequest().authenticated();
		});

		
		
		//Enable BasicAuth - (Using username and pwd from the properties file)
		httpSecurity.httpBasic(Customizer.withDefaults());
		
		// Disable CSRF (to allow Post requests)
		httpSecurity.csrf(csrfCustomizer -> {
			csrfCustomizer.disable();
		});
		
		return httpSecurity.build();
	}
	
	@Bean
	PasswordEncoder passwordEncoder() {
//		return NoOpPasswordEncoder.getInstance() ;
		return new BCryptPasswordEncoder(12);
	}
	
	
	@Bean
	public AuthenticationProvider authenticationProvider(CustomUserDetailsService userDetailsService) {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider(passwordEncoder());
		authProvider.setUserDetailsService(userDetailsService);
		return authProvider;
	}
	
}
