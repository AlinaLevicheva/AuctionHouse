package com.auction.auctionhouse.repository;

import com.auction.auctionhouse.entity.Stavka;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StavkaRepository extends JpaRepository<Stavka, Integer> {
}