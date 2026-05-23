package com.auction.auctionhouse;

import com.auction.auctionhouse.controller.AuthController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
public class SimpleSecurityControllerTest {

    @Autowired
    private AuthController authController;

    @Test
    public void testAuthControllerLogin() {
        Map<String, String> request = new HashMap<>();
        request.put("username", "admin@auction.ru");
        request.put("password", "admin123");

        var response = authController.login(request);
        assert response.containsKey("token");
        assert response.containsKey("role");
        System.out.println("✅ AuthController.login работает");
    }
}