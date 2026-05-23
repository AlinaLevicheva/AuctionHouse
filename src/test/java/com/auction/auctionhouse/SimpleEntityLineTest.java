package com.auction.auctionhouse;

import com.auction.auctionhouse.entity.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SimpleEntityLineTest {

    @Test
    public void testAllEntityGettersSetters() {
        // Sotrydnik
        Sotrydnik s = new Sotrydnik();
        s.setId(1);
        s.setFamiliya("Иванов");
        s.setImya("Иван");
        s.setOtchestvo("Иванович");
        s.setDolzhnost("Менеджер");
        s.setEmail("ivanov@test.ru");
        s.setNomerTelefona("+79101234567");

        assert s.getId() == 1;
        assert s.getFamiliya().equals("Иванов");
        assert s.getImya().equals("Иван");
        assert s.getOtchestvo().equals("Иванович");
        assert s.getDolzhnost().equals("Менеджер");
        assert s.getEmail().equals("ivanov@test.ru");
        assert s.getNomerTelefona().equals("+79101234567");
        System.out.println("✅ Sotrydnik getters/setters OK");

        // Uchastnik
        Uchastnik u = new Uchastnik();
        u.setId(2);
        u.setFamiliya("Петров");
        u.setImya("Петр");
        u.setOtchestvo("Петрович");
        u.setKolichestvoKuplennyhTovarov(10);

        assert u.getId() == 2;
        assert u.getFamiliya().equals("Петров");
        assert u.getImya().equals("Петр");
        assert u.getOtchestvo().equals("Петрович");
        assert u.getKolichestvoKuplennyhTovarov() == 10;
        System.out.println("✅ Uchastnik getters/setters OK");

        // Auktsion

        // Lot
        Lot l = new Lot();
        l.setId(4);
        l.setNazvanie("Картина");
        l.setOpisanie("Масло, холст");
        l.setStartovayaTsena(50000);
        l.setRezervnayaTsena(75000);
        l.setStatus("Активен");

        assert l.getId() == 4;
        assert l.getNazvanie().equals("Картина");
        assert l.getStartovayaTsena() == 50000;
        assert l.getRezervnayaTsena() == 75000;
        System.out.println("✅ Lot getters/setters OK");

        // Sdelka
        Sdelka sd = new Sdelka();
        sd.setId(5);
        sd.setFinalnayaTsena(100000);
        sd.setSummaKOpate(110000);
        sd.setSummaKVyplate(90000);
        sd.setStatus("Завершена");

        assert sd.getId() == 5;
        assert sd.getFinalnayaTsena() == 100000;
        assert sd.getSummaKOpate() == 110000;
        assert sd.getSummaKVyplate() == 90000;
        System.out.println("✅ Sdelka getters/setters OK");

        // Stavka
        Stavka st = new Stavka();
        st.setId(6);
        st.setSummaStavki(60000);
        st.setVremyaStavki(java.time.LocalTime.of(14, 30));

        assert st.getId() == 6;
        assert st.getSummaStavki() == 60000;
        System.out.println("✅ Stavka getters/setters OK");

        // Registratsiya
        Registratsiya r = new Registratsiya();
        r.setId(7);
        r.setNomerUchastnika(101);
        r.setStatusDostupa("Участник");
        r.setSummaZadatka(5000);

        assert r.getId() == 7;
        assert r.getNomerUchastnika() == 101;
        assert r.getStatusDostupa().equals("Участник");
        assert r.getSummaZadatka() == 5000;
        System.out.println("✅ Registratsiya getters/setters OK");
    }
}