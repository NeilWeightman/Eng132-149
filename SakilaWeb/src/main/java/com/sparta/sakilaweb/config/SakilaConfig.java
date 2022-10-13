package com.sparta.sakilaweb.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.SecurityBuilder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@EnableWebSecurity
@Configuration
public class SakilaConfig extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(AuthenticationManagerBuilder builder) throws Exception {
        builder.inMemoryAuthentication()
                .withUser("Malek")
                .password("{noop}secret123")
                .authorities("ADMIN");
        builder.inMemoryAuthentication()
                .withUser("Houssam")
                .password("{noop}passw0rd")
                .authorities("USER");
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/sakila/cast/*")
                .hasAnyAuthority("ADMIN")
                .antMatchers("/sakila/actor/*")
                .permitAll()
                .antMatchers("/asdad")
                .access()
                .anyRequest()
                .authenticated();
        http.formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/sakila/actor/all")
                .permitAll();
        http.exceptionHandling()
                .accessDeniedPage("/accessDenied");
    }
}
