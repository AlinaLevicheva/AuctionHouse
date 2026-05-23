package com.auction.auctionhouse.controller;

import com.auction.auctionhouse.entity.Registratsiya;
import com.auction.auctionhouse.repository.RegistratsiyaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/registratsiya")
public class RegistratsiyaController {

    @Autowired
    private RegistratsiyaRepository registratsiyaRepository;

    @GetMapping
    public List<Registratsiya> getAll() {
        return registratsiyaRepository.findAll();
    }

    @GetMapping("/{id}")
    public Registratsiya getById(@PathVariable Integer id) {
        return registratsiyaRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Registratsiya create(@RequestBody Registratsiya registratsiya) {
        return registratsiyaRepository.save(registratsiya);
    }

    @PutMapping("/{id}")
    public Registratsiya update(@PathVariable Integer id, @RequestBody Registratsiya registratsiya) {
        registratsiya.setId(id);
        return registratsiyaRepository.save(registratsiya);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        registratsiyaRepository.deleteById(id);
    }
}