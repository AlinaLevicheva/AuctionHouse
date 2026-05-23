package com.auction.auctionhouse.controller;

import com.auction.auctionhouse.entity.Stavka;
import com.auction.auctionhouse.repository.StavkaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stavka")
public class StavkaController {

    @Autowired
    private StavkaRepository stavkaRepository;

    @GetMapping
    public List<Stavka> getAll() {
        return stavkaRepository.findAll();
    }

    @GetMapping("/{id}")
    public Stavka getById(@PathVariable Integer id) {
        return stavkaRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Stavka create(@RequestBody Stavka stavka) {
        return stavkaRepository.save(stavka);
    }

    @PutMapping("/{id}")
    public Stavka update(@PathVariable Integer id, @RequestBody Stavka stavka) {
        stavka.setId(id);
        return stavkaRepository.save(stavka);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        stavkaRepository.deleteById(id);
    }
}