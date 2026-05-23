package com.auction.auctionhouse.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "auktsion")
public class Auktsion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_auktsiona")
    private Integer id;  // ← поменяли Long на Integer

    @ManyToOne
    @JoinColumn(name = "id_sotrydnika", nullable = false)
    private Sotrydnik sotrydnik;

    @Column(name = "nazvanie", nullable = false)
    private String nazvanie;

    @Column(name = "data_provedeniya", nullable = false)
    private LocalDate dataProvedeniya;

    @Column(name = "status", nullable = false)
    private String status;

    // Геттеры и сеттеры
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public Sotrydnik getSotrydnik() { return sotrydnik; }
    public void setSotrydnik(Sotrydnik sotrydnik) { this.sotrydnik = sotrydnik; }
    public String getNazvanie() { return nazvanie; }
    public void setNazvanie(String nazvanie) { this.nazvanie = nazvanie; }
    public LocalDate getDataProvedeniya() { return dataProvedeniya; }
    public void setDataProvedeniya(LocalDate dataProvedeniya) { this.dataProvedeniya = dataProvedeniya; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}