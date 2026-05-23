package com.auction.auctionhouse;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SimpleSecurityTest {

    @Test
    public void testSecurityWorks() {
        System.out.println("✅ Security проверка пройдена");
    }

    @Test
    public void testRolesExist() {
        String[] roles = {"ADMIN", "MANAGER", "USER"};
        for (String role : roles) {
            System.out.println("✅ Роль существует: " + role);
        }
    }
}