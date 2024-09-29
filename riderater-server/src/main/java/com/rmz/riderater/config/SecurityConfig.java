package com.rmz.riderater.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf().disable() // Disable CSRF protection
                .authorizeHttpRequests( auth -> {
//                    auth.requestMatchers("/api/attractions/createAttraction").authenticated();
//                    auth.requestMatchers("/api/attractions/deleteAttraction").authenticated();
//                    auth.requestMatchers("/loginSuccess").authenticated();
//                    auth.requestMatchers("/oauth2/authorization/google").permitAll();
//                    auth.requestMatchers("/api/attractions/{id}/create").permitAll(); // implement authorization
                    auth.requestMatchers("/api/attractions/CALIFORNIA").permitAll(); // implement authorization
                        auth.anyRequest().permitAll();
                })
                .oauth2Login(oauth2 -> oauth2 // oauth2 default providers using 3rd party apps (check app.prop for supported)
                        .loginPage("/oauth2/authorization/google")
                        .defaultSuccessUrl("/loginSuccess", true))
                .build();
    }


}
