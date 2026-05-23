package com.auction.auctionhouse.controller;

import com.auction.auctionhouse.entity.Lot;
import com.auction.auctionhouse.repository.LotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lot")
public class LotController {

    @Autowired
    private LotRepository lotRepository;

    @GetMapping
    public List<Lot> getAll() {
        return lotRepository.findAll();
    }

    @GetMapping("/{id}")
    public Lot getById(@PathVariable Integer id) {
        return lotRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Lot create(@RequestBody Lot lot) {
        return lotRepository.save(lot);
    }

    @PutMapping("/{id}")
    public Lot update(@PathVariable Integer id, @RequestBody Lot lot) {
        lot.setId(id);
        return lotRepository.save(lot);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        lotRepository.deleteById(id);
    }
}