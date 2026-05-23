package com.auction.auctionhouse;

import com.auction.auctionhouse.config.JwtFilter;
import com.auction.auctionhouse.config.JwtUtil;
import com.auction.auctionhouse.config.SecurityConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
public class SimpleConfigTest {

    @Autowired
    private ApplicationContext context;

    @Test
    public void testJwtUtilExists() {
        assert context.getBean(JwtUtil.class) != null;
        System.out.println("✅ JwtUtil загружен");
    }

    @Test
    public void testJwtFilterExists() {
        assert context.getBean(JwtFilter.class) != null;
        System.out.println("✅ JwtFilter загружен");
    }

    @Test
    public void testSecurityConfigExists() {
        assert context.getBean(SecurityConfig.class) != null;
        System.out.println("✅ SecurityConfig загружен");
    }
}