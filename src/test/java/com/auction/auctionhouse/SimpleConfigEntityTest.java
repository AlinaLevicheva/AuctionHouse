package com.auction.auctionhouse;

import com.auction.auctionhouse.config.JwtUtil;
import com.auction.auctionhouse.config.SecurityConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetailsService;

@SpringBootTest
public class SimpleConfigEntityTest {

    @Autowired(required = false)
    private JwtUtil jwtUtil;

    @Autowired(required = false)
    private SecurityConfig securityConfig;

    @Autowired(required = false)
    private UserDetailsService userDetailsService;

    @Test
    public void testJwtUtilGeneration() {
        if (jwtUtil != null) {
            String token = jwtUtil.generateToken("test@test.ru", "ADMIN");
            assert token != null && !token.isEmpty();
            System.out.println("✅ JWT токен создаётся: " + token.substring(0, 20) + "...");
        } else {
            System.out.println("⚠️ JwtUtil не найден");
        }
    }

    @Test
    public void testSecurityConfigExists() {
        assert securityConfig != null;
        System.out.println("✅ SecurityConfig существует");
    }

    @Test
    public void testUserDetailsServiceExists() {
        assert userDetailsService != null;
        var user = userDetailsService.loadUserByUsername("admin@auction.ru");
        assert user != null;
        assert user.getUsername().equals("admin@auction.ru");
        System.out.println("✅ UserDetailsService работает: найден пользователь " + user.getUsername());
    }
}

