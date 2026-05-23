package com.auction.auctionhouse.controller;

import com.auction.auctionhouse.entity.Uchastnik;
import com.auction.auctionhouse.repository.UchastnikRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/uchastnik")
public class UchastnikController {

    @Autowired
    private UchastnikRepository uchastnikRepository;

    @GetMapping
    public List<Uchastnik> getAll() {
        return uchastnikRepository.findAll();
    }

    @GetMapping("/{id}")
    public Uchastnik getById(@PathVariable Integer id) {
        return uchastnikRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Uchastnik create(@RequestBody Uchastnik uchastnik) {
        return uchastnikRepository.save(uchastnik);
    }

    @PutMapping("/{id}")
    public Uchastnik update(@PathVariable Integer id, @RequestBody Uchastnik uchastnik) {
        uchastnik.setId(id);
        return uchastnikRepository.save(uchastnik);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        uchastnikRepository.deleteById(id);
    }
}