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
     * 스프링 시큐리티 Java Configuration configureGlobal 이라는 이름이 중요한건 아니다,
     * 반드시 @EnableWebSecurity 를 붙인 클래스 내부에서 {@link AuthenticationManagerBuilder}를
     * 구현해야 한다.
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
     * {@link WebSecurityConfigurerAdapter}가 기본값으로 구현하고 있는 {@link #configure(HttpSecurity)} 설정 값이다.
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
                .authenticated() // 인증을 요구
                .and()
                .formLogin() // form 인증
                .loginProcessingUrl("/login")
                .loginPage("/index.html") // login page 지정
                .permitAll(); // 모두 접근 가능
    }
}
