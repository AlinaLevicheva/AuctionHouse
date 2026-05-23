package com.auction.auctionhouse.controller;

import com.auction.auctionhouse.entity.Sotrydnik;
import com.auction.auctionhouse.repository.SotrydnikRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sotrydnik")
public class SotrydnikController {

    @Autowired
    private SotrydnikRepository sotrydnikRepository;

    @GetMapping
    public List<Sotrydnik> getAll() {
        return sotrydnikRepository.findAll();
    }

    @GetMapping("/{id}")
    public Sotrydnik getById(@PathVariable Integer id) {
        return sotrydnikRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Sotrydnik create(@RequestBody Sotrydnik sotrydnik) {
        return sotrydnikRepository.save(sotrydnik);
    }

    @PutMapping("/{id}")
    public Sotrydnik update(@PathVariable Integer id, @RequestBody Sotrydnik sotrydnik) {
        sotrydnik.setId(id);
        return sotrydnikRepository.save(sotrydnik);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        sotrydnikRepository.deleteById(id);
    }
}