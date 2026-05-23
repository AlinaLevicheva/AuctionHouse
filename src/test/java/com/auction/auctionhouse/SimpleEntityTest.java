package com.auction.auctionhouse;

import com.auction.auctionhouse.entity.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SimpleEntityTest {

    @Test
    public void testSotrydnikEntity() {
        Sotrydnik s = new Sotrydnik();
        s.setId(1);
        s.setFamiliya("Тест");
        s.setImya("Тест");
        s.setOtchestvo("Тестович");
        s.setDolzhnost("Тестировщик");
        s.setEmail("test@test.ru");
        s.setNomerTelefona("+79991112233");

        assert s.getId() == 1;
        assert s.getFamiliya().equals("Тест");
        assert s.getEmail().equals("test@test.ru");
        System.out.println("✅ Sotrydnik entity протестирован");
    }

    @Test
    public void testUchastnikEntity() {
        Uchastnik u = new Uchastnik();
        u.setId(1);
        u.setFamiliya("Тестов");
        u.setImya("Тест");
        u.setOtchestvo("Тестович");
        u.setKolichestvoKuplennyhTovarov(5);

        assert u.getId() == 1;
        assert u.getKolichestvoKuplennyhTovarov() == 5;
        System.out.println("✅ Uchastnik entity протестирован");
    }

    @Test
    public void testAuktsionEntity() {
        Auktsion a = new Auktsion();
        a.setId(1);
        a.setNazvanie("Тестовый аукцион");
        a.setDataProvedeniya(java.time.LocalDate.now());
        a.setStatus("Активен");

        assert a.getId() == 1;
        assert a.getStatus().equals("Активен");
        System.out.println("✅ Auktsion entity протестирован");
    }

    @Test
    public void testLotEntity() {
        Lot l = new Lot();
        l.setId(1);
        l.setNazvanie("Тестовый лот");
        l.setOpisanie("Описание");
        l.setStartovayaTsena(1000);
        l.setRezervnayaTsena(2000);
        l.setStatus("Активен");

        assert l.getStartovayaTsena() == 1000;
        assert l.getRezervnayaTsena() == 2000;
        System.out.println("✅ Lot entity протестирован");
    }

    @Test
    public void testSdelkaEntity() {
        Sdelka sd = new Sdelka();
        sd.setId(1);
        sd.setFinalnayaTsena(10000);
        sd.setSummaKOpate(11000);
        sd.setSummaKVyplate(9000);
        sd.setStatus("Завершена");

        assert sd.getFinalnayaTsena() == 10000;
        System.out.println("✅ Sdelka entity протестирован");
    }

    @Test
    public void testStavkaEntity() {
        Stavka st = new Stavka();
        st.setId(1);
        st.setSummaStavki(5000);
        st.setVremyaStavki(java.time.LocalTime.now());

        assert st.getSummaStavki() == 5000;
        System.out.println("✅ Stavka entity протестирован");
    }

    @Test
    public void testRegistratsiyaEntity() {
        Registratsiya r = new Registratsiya();
        r.setId(1);
        r.setNomerUchastnika(100);
        r.setStatusDostupa("Участник");
        r.setSummaZadatka(10000);

        assert r.getNomerUchastnika() == 100;
        assert r.getSummaZadatka() == 10000;
        System.out.println("✅ Registratsiya entity протестирован");
    }
}