package com.auction.auctionhouse.repository;

import com.auction.auctionhouse.entity.Sdelka;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SdelkaRepository extends JpaRepository<Sdelka, Integer> {
}