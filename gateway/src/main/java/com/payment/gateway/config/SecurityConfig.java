package com.payment.gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
@EnableWebFluxSecurity
public class SecurityConfig {

    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {
        http
                .csrf(ServerHttpSecurity.CsrfSpec::disable)
                .authorizeExchange(auth -> auth
                        .pathMatchers("/auth/login", "/users/register").permitAll()
                        .pathMatchers("/users/**").hasAnyAuthority("USER", "ADMIN")
                        .pathMatchers("/accounts/**").hasAuthority("USER")
                        .pathMatchers("/balances/**").hasAuthority("USER")
                        .pathMatchers("/transactions/**").hasAuthority("USER")
                        .anyExchange().authenticated()
                );
        return http.build();
    }
}
