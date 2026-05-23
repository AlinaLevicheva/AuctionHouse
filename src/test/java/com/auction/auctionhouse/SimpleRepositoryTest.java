package com.auction.auctionhouse;

import com.auction.auctionhouse.entity.Sotrydnik;
import com.auction.auctionhouse.repository.SotrydnikRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SimpleRepositoryTest {

    @Autowired
    private SotrydnikRepository sotrydnikRepository;

    @Test
    public void testCreateAndDeleteSotrydnik() {
        Sotrydnik s = new Sotrydnik();
        s.setFamiliya("Тестов");
        s.setImya("Тест");
        s.setEmail("test@test.ru");
        s.setNomerTelefona("+79991112233");

        Sotrydnik saved = sotrydnikRepository.save(s);
        System.out.println("✅ Создан сотрудник с ID: " + saved.getId());

        sotrydnikRepository.deleteById(saved.getId());
        System.out.println("✅ Удалён сотрудник с ID: " + saved.getId());
    }

    @Test
    public void testFindAll() {
        System.out.println("✅ Найдено сотрудников: " + sotrydnikRepository.count());
    }
}