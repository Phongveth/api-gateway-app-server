package com.la.apigatewayappserver.config;
import javax.sql.DataSource;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import java.util.Collections;

@Configuration
@EnableWebSecurity
@EnableAutoConfiguration(exclude = { SecurityAutoConfiguration.class })
//@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
public class ProjectSecurityConfig extends WebSecurityConfigurerAdapter {




	/**
	 * /myAccount - Secured /myBalance - Secured /myLoans - Secured /myCards -
	 * Secured /notices - Not Secured /contact - Not Secured
	 */


	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.cors().configurationSource(new CorsConfigurationSource() {
					@Override
					public CorsConfiguration getCorsConfiguration(HttpServletRequest request) {
						CorsConfiguration config = new CorsConfiguration();
						config.setAllowedOrigins(Collections.singletonList("http://localhost:4200"));
						config.setAllowedMethods(Collections.singletonList("*"));
						config.setAllowCredentials(true);
						config.setAllowedHeaders(Collections.singletonList("*"));
						config.setMaxAge(3600L);
						return config;
					}
				}).and().csrf().ignoringAntMatchers("/noAuth").csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()).and().
				authorizeRequests().antMatchers("/consumer/message").authenticated().antMatchers("/employee/message").authenticated()
				.antMatchers("/myLoans").authenticated().antMatchers("/myCards").authenticated()
				.antMatchers("/user").authenticated().antMatchers("/notices").permitAll()
				.antMatchers("/noAuth").permitAll().and().httpBasic();
	}

//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http
//				.authorizeRequests()
//				.antMatchers("/", "/noAuth").permitAll() // (3)
//				.anyRequest().authenticated() // (4)
//				.and()
//				.formLogin() // (5)
//				.loginPage("/login") // (5)
//				.permitAll()
//				.and()
//				.logout() // (6)
//				.permitAll()
//				.and()
//				.httpBasic(); // (7)
//
//	}



//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http.
//				httpBasic()
//				.and()
//				.authorizeRequests()
//				.antMatchers("/delete").hasRole("admin_role")
//				.and()
//				.formLogin();
//	}

//	@Override protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//	 auth.inMemoryAuthentication().withUser("admin").password("12345").authorities
//	 ("admin").and(). withUser("user").password("12345").authorities("read").and()
//	 .passwordEncoder(NoOpPasswordEncoder.getInstance()); }


//
//	  @Override protected void configure(AuthenticationManagerBuilder auth) throws
//	  Exception { InMemoryUserDetailsManager userDetailsService = new
//	 InMemoryUserDetailsManager(); UserDetails user =
//	 User.withUsername("admin").password("12345").authorities("admin").build();
//	 UserDetails user1 = User.withUsername("user").password("12345").authorities("read").build();
//	 userDetailsService.createUser(user); userDetailsService.createUser(user1);
//	 auth.userDetailsService(userDetailsService); }
//

	/*
	 * @Bean public UserDetailsService userDetailsService(DataSource dataSource) {
	 * return new JdbcUserDetailsManager(dataSource); }
	 */

//	@Override
//	public void configure(WebSecurity web) {
//		web.ignoring().antMatchers("/consumer/message");
//	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}

	

}
