package com.example.ELtonSmartWare.config;

import com.example.ELtonSmartWare.filters.JwtRequestFilter;
import com.example.ELtonSmartWare.service.UserDetailsServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig {


   private  final JwtRequestFilter jwtRequestFilter;

   public WebSecurityConfig(JwtRequestFilter jwtRequestFilter, UserDetailsServiceImpl userDetailsServiceImpl) {
      this.jwtRequestFilter = jwtRequestFilter;
      this.userDetailsServiceImpl = userDetailsServiceImpl;
   }

   private  final UserDetailsServiceImpl userDetailsServiceImpl;




   @Bean
   public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
      return http
              .csrf(AbstractHttpConfigurer::disable)
              .authorizeHttpRequests(
                      auth -> auth
                              .requestMatchers("/login/**", "/register/**")
                              .permitAll()
                              .anyRequest()
                              .authenticated()
              ).userDetailsService(userDetailsServiceImpl)
              .sessionManagement(session->session
                      .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
              .addFilterBefore(jwtRequestFilter , UsernamePasswordAuthenticationFilter.class)
              .build();
   }
   @Bean
   public PasswordEncoder passwordEncoder(){return new BCryptPasswordEncoder();
   }

   @Bean
   public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws  Exception{
      return config.getAuthenticationManager();

   }

}
