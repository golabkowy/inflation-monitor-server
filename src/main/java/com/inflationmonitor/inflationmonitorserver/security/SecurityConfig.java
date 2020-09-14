package com.inflationmonitor.inflationmonitorserver.security;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

// some of tutorials says that @Configure could be enough...
@EnableWebSecurity
// why not to extends OAuth2WebSecurityConfigurerAdapter???
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    //why not to override webSecurity or auhenticationSecManager or sth related with oAuth2...
    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.antMatcher("/**").authorizeRequests()
                .antMatchers("/").permitAll()
                .anyRequest().authenticated()
                .and()
                .oauth2Login();
    }
}
