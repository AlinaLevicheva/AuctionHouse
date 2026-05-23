package com.auction.auctionhouse.controller;

import com.auction.auctionhouse.entity.Auktsion;
import com.auction.auctionhouse.repository.AuktsionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/auktsion")
public class AuktsionController {

    @Autowired
    private AuktsionRepository auktsionRepository;

    @GetMapping
    public List<Auktsion> getAll() {
        return auktsionRepository.findAll();
    }

    @GetMapping("/{id}")
    public Auktsion getById(@PathVariable Integer id) {
        return auktsionRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Auktsion create(@RequestBody Auktsion auktsion) {
        return auktsionRepository.save(auktsion);
    }

    @PutMapping("/{id}")
    public Auktsion update(@PathVariable Integer id, @RequestBody Auktsion auktsion) {
        auktsion.setId(id);
        return auktsionRepository.save(auktsion);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        auktsionRepository.deleteById(id);
    }
}