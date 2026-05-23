package com.auction.auctionhouse.controller;

import com.auction.auctionhouse.entity.Sdelka;
import com.auction.auctionhouse.repository.SdelkaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sdelka")
public class SdelkaController {

    @Autowired
    private SdelkaRepository sdelkaRepository;

    @GetMapping
    public List<Sdelka> getAll() {
        return sdelkaRepository.findAll();
    }

    @GetMapping("/{id}")
    public Sdelka getById(@PathVariable Integer id) {
        return sdelkaRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Sdelka create(@RequestBody Sdelka sdelka) {
        return sdelkaRepository.save(sdelka);
    }

    @PutMapping("/{id}")
    public Sdelka update(@PathVariable Integer id, @RequestBody Sdelka sdelka) {
        sdelka.setId(id);
        return sdelkaRepository.save(sdelka);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        sdelkaRepository.deleteById(id);
    }
}