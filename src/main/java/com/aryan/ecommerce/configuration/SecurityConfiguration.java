package com.aryan.ecommerce.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.HttpBasicConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.http.HttpMethod;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
		return config.getAuthenticationManager();
	}

	@Bean
	UserDetailsService userDetailsService() {
		return new CustomUserDetailsService();
	}

	@Bean
	AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
		authenticationProvider.setPasswordEncoder(passwordEncoder());
		authenticationProvider.setUserDetailsService(userDetailsService());
		return authenticationProvider;
	}

	// This is the method for configuring HTTP security
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.csrf(csrf -> csrf.disable()) // Disable CSRF protection
				.authorizeHttpRequests(requests -> requests.requestMatchers(HttpMethod.POST, "/api/v1/products")
						.hasRole("ADMIN").requestMatchers(HttpMethod.DELETE, "/api/v1/products/*").hasRole("ADMIN")
						.requestMatchers(HttpMethod.PUT, "/api/v1/products/*").hasRole("ADMIN")
						.requestMatchers(HttpMethod.POST, "/api/v1/categories").hasRole("ADMIN")
						.requestMatchers(HttpMethod.DELETE, "/api/v1/categories/*").hasRole("ADMIN")
						.requestMatchers(HttpMethod.PUT, "/api/v1/categories/*").hasRole("ADMIN")
						.requestMatchers(HttpMethod.POST, "/api/v1/suppliers").hasRole("ADMIN")
						.requestMatchers(HttpMethod.DELETE, "/api/v1/suppliers/*").hasRole("ADMIN")
						.requestMatchers(HttpMethod.PUT, "/api/v1/suppliers/*").hasRole("ADMIN").anyRequest()
						.authenticated() // Any other request requires authentication
				).httpBasic(withDefaults()) // Use basic HTTP authentication
				.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)); // Stateless
																												// sessions

		return http.build();
	}

	private Customizer<HttpBasicConfigurer<HttpSecurity>> withDefaults() {
		// TODO Auto-generated method stub
		return null;
	}
}
