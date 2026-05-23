package com.auction.auctionhouse.repository;

import com.auction.auctionhouse.entity.Sotrydnik;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SotrydnikRepository extends JpaRepository<Sotrydnik, Integer> {
}