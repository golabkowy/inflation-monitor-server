package com.inflationmonitor.inflationmonitorserver.security;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.Set;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Bean
    public UserDetailsService userDetailsService() {
        User alt_user = new User("test-user", "test-passwd", Set.of(new SimpleGrantedAuthority("ADMIN")));

        UserDetails user1 = User.withDefaultPasswordEncoder()
                .username("user1")
                .password("user1")
                .roles("USER")
                .build();

        UserDetails user2 = User.withDefaultPasswordEncoder()
                .username("user2")
                .password("user2")
                .roles("USER")
                .build();

        UserDetails user3 = User.withDefaultPasswordEncoder()
                .username("user3")
                .password("user3")
                .roles("USER")
                .build();

        UserDetails admin = User.withDefaultPasswordEncoder()
                .username("admin")
                .password("admin")
                .roles("ADMIN")
                .build();
        return new InMemoryUserDetailsManager(admin, user1, user2, user3);
    }


    public void mockUser() {
        User user = new User("test-user", "test-passwd", Set.of(new SimpleGrantedAuthority("ADMIN")));
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .cors().disable().csrf().disable()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/testGET").permitAll()
                .antMatchers(HttpMethod.POST, "/testPOST").permitAll()
                .antMatchers("/testGETDeny").denyAll()
                .antMatchers("/testGITForm").authenticated()
                .antMatchers(HttpMethod.GET, "/auth/is-logged").fullyAuthenticated()    //what is the difference betweent this one and jusy authenticated()
                .antMatchers(HttpMethod.POST, "/auth/login").fullyAuthenticated()   //what is the difference betweent this one and jusy authenticated()
                .and()
                // now we have both methods, formLogin and basicAuth, choose what you want
                .httpBasic()
                .and()
                .formLogin()
                .and()
                .oauth2Login()
                .and()
                .logout().deleteCookies("JSESSIONID")
                .and().rememberMe().rememberMeCookieName("testRememberMeCookieKey").alwaysRemember(true).key("turboSecureSecret");

    }

}
