package com.auction.auctionhouse.repository;

import com.auction.auctionhouse.entity.Auktsion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuktsionRepository extends JpaRepository<Auktsion, Integer> {
}