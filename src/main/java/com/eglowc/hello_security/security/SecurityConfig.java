package com.eglowc.hello_security.security;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.*;
import org.springframework.security.config.annotation.authentication.builders.*;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.*;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * <pre>
     * ??? ???? Java Configuration configureGlobal ??? ??? ???? ???,
     * ??? @EnableWebSecurity ? ???? ??? ???? {@link AuthenticationManagerBuilder}?
     * ???? ??? ???.
     * </pre>
     *
     * @param auth
     * @throws Exception
     * @see EnableWebSecurity
     */
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("user").password("password").roles("USER");
    }

    /**
     * {@link WebSecurityConfigurerAdapter}? ?????? ?? {@link #configure(HttpSecurity)} ???? ???? ?? ???,
     * ??? ?? ??? ??? ????? ??? ????? ??? ???.
     */
    /*
    protected void configure(HttpSecurity http) throws Exception {
		logger.debug("Using default configure(HttpSecurity). If subclassed this will potentially override subclass configure(HttpSecurity).");

		http
			.authorizeRequests()
				.anyRequest().authenticated()
				.and()
			.formLogin().and()
			.httpBasic();
	}
    */
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .anyRequest()
                .authenticated() // ??? ?????? ??? ????.
                .and()
                .formLogin() // form ???
                .loginProcessingUrl("/login")
                .loginPage("/index.html") // ??? ??? ??
                .permitAll(); // ?? ???? ??? ??
    }
}
