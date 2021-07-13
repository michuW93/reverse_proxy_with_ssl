package com.example.web;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.formLogin()
                .loginPage("/login.html")
                .loginProcessingUrl("/jcheck.action")
                .and()
                .logout()
                .logoutSuccessUrl("/login.html")
                .logoutUrl("/j_logout")
                .and()
                .authorizeRequests()
                .antMatchers("/testAuthenticated.html")
                .authenticated()
                .antMatchers("/testPermitAll.html")
                .permitAll()
                .antMatchers("/login.html").permitAll()
                .anyRequest().permitAll();
    }
}