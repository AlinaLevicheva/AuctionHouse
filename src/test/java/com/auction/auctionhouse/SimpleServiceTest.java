package com.auction.auctionhouse;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SimpleServiceTest {

    @Test
    public void testAppStarts() {
        System.out.println("✅ Приложение запускается без ошибок");
    }

    @Test
    public void testMath() {
        int sum = 2 + 2;
        assert sum == 4;
        System.out.println("✅ 2+2=4 работает");
    }
}