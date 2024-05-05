package com.example.ELtonSmartWare.config;

import com.example.ELtonSmartWare.filters.JwtRequestFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration {

    private final JwtRequestFilter jwtRequestFilter;

    public WebSecurityConfiguration(JwtRequestFilter jwtRequestFilter) {
        this.jwtRequestFilter = jwtRequestFilter;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
/**
    @Bean
    public JwtRequestFilter jwtRequestFilter() {
        return new JwtRequestFilter();
    }

    @Bean
    public WebSecurityConfigurerAdapter webSecurityConfigurerAdapter() {
        return new WebSecurityConfigurerAdapter() {
            @Override
            protected void configure(HttpSecurity http) throws Exception {
                http.
                        .authorizeRequests()
                        .antMatchers("/authenticate", "/sign-up", "/order/**").permitAll() // Permit access to specified endpoints without authentication
                        .antMatchers("/api/**").authenticated() // Authenticate all requests to /api/** endpoint
                        .anyRequest().authenticated() // Authenticate all other requests
                        .and()
                        .formLogin() // Configure form-based login
                        .loginPage("/login") // Custom login page URL
                        .permitAll() // Allow access to login page without authentication
                        .and()
                        .logout() // Configure logout
                        .logoutSuccessUrl("/login?logout") // Redirect to login page after logout
                        .permitAll(); // Allow access to logout endpoint without authentication

                http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class); // Add JWT filter before UsernamePasswordAuthenticationFilter
                http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS); // Configure stateless session management
            }
        };**/
    }

