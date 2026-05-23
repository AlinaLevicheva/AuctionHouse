package com.auction.auctionhouse.repository;

import com.auction.auctionhouse.entity.Registratsiya;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistratsiyaRepository extends JpaRepository<Registratsiya, Integer> {
}