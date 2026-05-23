package com.auction.auctionhouse.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        // Разрешаем вход без авторизации
                        .requestMatchers("/api/auth/login").permitAll()
                        // Админ может всё
                        .requestMatchers("/api/sotrydnik/**").hasRole("ADMIN")
                        .requestMatchers("/api/auktsion/**", "/api/lot/**").hasAnyRole("ADMIN", "MANAGER")
                        .requestMatchers("/api/uchastnik/**", "/api/stavka/**").hasAnyRole("ADMIN", "MANAGER", "USER")
                        .anyRequest().authenticated()
                )
                .httpBasic(httpBasic -> {})
                .csrf(csrf -> csrf.disable());
        return http.build();
    }

    @Bean
    public UserDetailsService users() {
        return new InMemoryUserDetailsManager(
                // АДМИН
                User.builder()
                        .username("admin@auction.ru")
                        .password("{noop}admin123")
                        .roles("ADMIN")
                        .build(),
                // МЕНЕДЖЕР
                User.builder()
                        .username("manager@auction.ru")
                        .password("{noop}manager123")
                        .roles("MANAGER")
                        .build(),
                // УЧАСТНИК
                User.builder()
                        .username("user@auction.ru")
                        .password("{noop}user123")
                        .roles("USER")
                        .build()
        );
    }
}