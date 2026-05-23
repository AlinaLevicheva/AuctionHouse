package com.auction.auctionhouse.controller;

import com.auction.auctionhouse.config.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserDetailsService userDetailsService;

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody Map<String, String> request) {
        String username = request.get("username");
        String password = request.get("password");

        // Простая проверка (для учебного проекта)
        Map<String, String> users = new HashMap<>();
        users.put("admin@auction.ru", "admin123");
        users.put("manager@auction.ru", "manager123");
        users.put("user@auction.ru", "user123");

        Map<String, String> roles = new HashMap<>();
        roles.put("admin@auction.ru", "ADMIN");
        roles.put("manager@auction.ru", "MANAGER");
        roles.put("user@auction.ru", "USER");

        if (users.containsKey(username) && users.get(username).equals(password)) {
            String token = jwtUtil.generateToken(username, roles.get(username));
            Map<String, String> response = new HashMap<>();
            response.put("token", token);
            response.put("role", roles.get(username));
            return response;
        }

        throw new RuntimeException("Неверный логин или пароль");
    }
}