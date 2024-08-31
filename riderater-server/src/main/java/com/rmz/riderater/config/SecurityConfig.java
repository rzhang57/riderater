//package com.rmz.riderater.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.web.SecurityFilterChain;
//
//public class SecurityConfig {
//
//    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        return http
//                .authorizeHttpRequests( auth -> {
//                    auth.anyRequest().permitAll();
//                })
//                .oauth2Login(Customizer.withDefaults()) // oauth2 default providers using 3rd party apps (check app.prop for supported)
//                .build();
//    }
//
//
//}
