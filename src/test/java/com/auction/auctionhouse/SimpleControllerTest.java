package com.auction.auctionhouse;

import com.auction.auctionhouse.controller.*;
import com.auction.auctionhouse.entity.*;
import com.auction.auctionhouse.repository.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SimpleControllerTest {

    @Autowired private SotrydnikController sotrydnikController;
    @Autowired private UchastnikController uchastnikController;
    @Autowired private AuktsionController auktsionController;
    @Autowired private LotController lotController;
    @Autowired private SdelkaController sdelkaController;
    @Autowired private StavkaController stavkaController;
    @Autowired private RegistratsiyaController registratsiyaController;

    @Autowired private SotrydnikRepository sotrydnikRepository;
    @Autowired private UchastnikRepository uchastnikRepository;
    @Autowired private AuktsionRepository auktsionRepository;
    @Autowired private LotRepository lotRepository;
    @Autowired private SdelkaRepository sdelkaRepository;
    @Autowired private StavkaRepository stavkaRepository;
    @Autowired private RegistratsiyaRepository registratsiyaRepository;

    @Test
    public void testSotrydnikController() {
        Sotrydnik s = new Sotrydnik();
        s.setFamiliya("ТестСотр");
        s.setImya("Тест");
        s.setEmail("test@test.ru");
        s.setNomerTelefona("+79991112233");
        Sotrydnik saved = sotrydnikController.create(s);
        assert saved.getId() != null;
        assert sotrydnikController.getAll() != null;
        assert sotrydnikController.getById(saved.getId()) != null;
        sotrydnikController.delete(saved.getId());
        System.out.println("✅ SotrydnikController протестирован");
    }

    @Test
    public void testUchastnikController() {
        Uchastnik u = new Uchastnik();
        u.setFamiliya("ТестУчаст");
        u.setImya("Тест");
        u.setKolichestvoKuplennyhTovarov(0);
        Uchastnik saved = uchastnikController.create(u);
        assert saved.getId() != null;
        assert uchastnikController.getAll() != null;
        assert uchastnikController.getById(saved.getId()) != null;
        uchastnikController.delete(saved.getId());
        System.out.println("✅ UchastnikController протестирован");
    }

    @Test
    public void testAuktsionController() {
        Sotrydnik s = new Sotrydnik();
        s.setFamiliya("ТестСотр2");
        s.setImya("Тест");
        s.setEmail("test2@test.ru");
        s.setNomerTelefona("+79991112233");
        Sotrydnik savedSotr = sotrydnikRepository.save(s);

        Auktsion a = new Auktsion();
        a.setSotrydnik(savedSotr);
        a.setNazvanie("ТестАукцион");
        a.setDataProvedeniya(java.time.LocalDate.now());
        a.setStatus("Тест");
        Auktsion saved = auktsionController.create(a);
        assert saved.getId() != null;
        assert auktsionController.getAll() != null;
        assert auktsionController.getById(saved.getId()) != null;
        auktsionController.delete(saved.getId());
        sotrydnikRepository.deleteById(savedSotr.getId());
        System.out.println("✅ AuktsionController протестирован");
    }

    @Test
    public void testLotController() {
        Lot l = new Lot();
        l.setNazvanie("ТестЛот");
        l.setOpisanie("Описание");
        l.setStartovayaTsena(1000);
        l.setRezervnayaTsena(2000);
        l.setStatus("Тест");
        Lot saved = lotController.create(l);
        assert saved.getId() != null;
        assert lotController.getAll() != null;
        assert lotController.getById(saved.getId()) != null;
        lotController.delete(saved.getId());
        System.out.println("✅ LotController протестирован");
    }

    @Test
    public void testSdelkaController() {
        Sdelka sd = new Sdelka();
        sd.setFinalnayaTsena(10000);
        sd.setSummaKOpate(11000);
        sd.setSummaKVyplate(9000);
        sd.setStatus("Тест");
        Sdelka saved = sdelkaController.create(sd);
        assert saved.getId() != null;
        assert sdelkaController.getAll() != null;
        assert sdelkaController.getById(saved.getId()) != null;
        sdelkaController.delete(saved.getId());
        System.out.println("✅ SdelkaController протестирован");
    }

    @Test
    public void testStavkaController() {
        // Создаём нужные зависимости
        Sotrydnik s = new Sotrydnik();
        s.setFamiliya("ТестСотр3");
        s.setImya("Тест");
        s.setEmail("test3@test.ru");
        s.setNomerTelefona("+79991112233");
        Sotrydnik savedSotr = sotrydnikRepository.save(s);

        Uchastnik u = new Uchastnik();
        u.setFamiliya("ТестУчаст2");
        u.setImya("Тест");
        u.setKolichestvoKuplennyhTovarov(0);
        Uchastnik savedUch = uchastnikRepository.save(u);

        Lot l = new Lot();
        l.setNazvanie("ТестЛот2");
        l.setOpisanie("Описание");
        l.setStartovayaTsena(1000);
        l.setRezervnayaTsena(2000);
        l.setStatus("Тест");
        Lot savedLot = lotRepository.save(l);

        Sdelka sd = new Sdelka();
        sd.setFinalnayaTsena(10000);
        sd.setSummaKOpate(11000);
        sd.setSummaKVyplate(9000);
        Sdelka savedSd = sdelkaRepository.save(sd);

        Stavka stavka = new Stavka();
        stavka.setSdelka(savedSd);
        stavka.setLot(savedLot);
        stavka.setUchastnik(savedUch);
        stavka.setSummaStavki(5000);
        stavka.setVremyaStavki(java.time.LocalTime.now());

        Stavka saved = stavkaController.create(stavka);
        assert saved.getId() != null;
        assert stavkaController.getAll() != null;
        assert stavkaController.getById(saved.getId()) != null;
        stavkaController.delete(saved.getId());

        sdelkaRepository.deleteById(savedSd.getId());
        lotRepository.deleteById(savedLot.getId());
        uchastnikRepository.deleteById(savedUch.getId());
        sotrydnikRepository.deleteById(savedSotr.getId());
        System.out.println("✅ StavkaController протестирован");
    }

    @Test
    public void testRegistratsiyaController() {
        Sotrydnik s = new Sotrydnik();
        s.setFamiliya("ТестСотр4");
        s.setImya("Тест");
        s.setEmail("test4@test.ru");
        s.setNomerTelefona("+79991112233");
        Sotrydnik savedSotr = sotrydnikRepository.save(s);

        Uchastnik u = new Uchastnik();
        u.setFamiliya("ТестУчаст3");
        u.setImya("Тест");
        u.setKolichestvoKuplennyhTovarov(0);
        Uchastnik savedUch = uchastnikRepository.save(u);

        Auktsion a = new Auktsion();
        a.setSotrydnik(savedSotr);
        a.setNazvanie("ТестАукц");
        a.setDataProvedeniya(java.time.LocalDate.now());
        a.setStatus("Тест");
        Auktsion savedAuk = auktsionRepository.save(a);

        Registratsiya r = new Registratsiya();
        r.setAuktsion(savedAuk);
        r.setUchastnik(savedUch);
        r.setNomerUchastnika(999);
        r.setStatusDostupa("Тест");
        r.setSummaZadatka(5000);

        Registratsiya saved = registratsiyaController.create(r);
        assert saved.getId() != null;
        assert registratsiyaController.getAll() != null;
        assert registratsiyaController.getById(saved.getId()) != null;
        registratsiyaController.delete(saved.getId());

        auktsionRepository.deleteById(savedAuk.getId());
        uchastnikRepository.deleteById(savedUch.getId());
        sotrydnikRepository.deleteById(savedSotr.getId());
        System.out.println("✅ RegistratsiyaController протестирован");
    }
}