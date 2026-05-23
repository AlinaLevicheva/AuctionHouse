package com.auction.auctionhouse.repository;

import com.auction.auctionhouse.entity.Uchastnik;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UchastnikRepository extends JpaRepository<Uchastnik, Integer> {
}