package com.h066it.myLittleCrawler.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import com.h066it.myLittleCrawler.serviceImpl.SecurityServiceImpl;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled=true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private SecurityServiceImpl service;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.formLogin()
				.loginPage("/login")
				.failureUrl("/login?error")
				.defaultSuccessUrl("/")
			.and()
				.logout()
					.logoutUrl("/logout")
					.deleteCookies("JSESSIONID")
					.logoutSuccessUrl("/?logout")
					.invalidateHttpSession(true)
			.and()
				.rememberMe()
					.tokenValiditySeconds(604800)
					.key("rememberMeKey")
					.rememberMeParameter("remember-me")
					.rememberMeCookieName("RM_CK")
					.userDetailsService(service)
					.tokenRepository(persistentTokenRepository())
			.and()
				.authorizeRequests()
					.antMatchers("/**/write*", "/**/update*", "/**/delete*").authenticated()
					//.antMatchers("/admin/*").hasAuthority("ROLE_ADMIN")
					.antMatchers("/**").permitAll()
			.and()
				.sessionManagement()
					.maximumSessions(1);
	}

	@Bean
	public PersistentTokenRepository persistentTokenRepository() {
		JdbcTokenRepositoryImpl db = new JdbcTokenRepositoryImpl();
		db.setDataSource(dataSource);
		
		return db;
	}	
		
}
