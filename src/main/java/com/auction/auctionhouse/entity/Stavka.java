package com.auction.auctionhouse.entity;

import jakarta.persistence.*;
import java.time.LocalTime;

@Entity
@Table(name = "stavka")
public class Stavka {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_stavki")
    private Integer id;  // ← Long → Integer

    @ManyToOne
    @JoinColumn(name = "id_sdelki", nullable = false)
    private Sdelka sdelka;

    @ManyToOne
    @JoinColumn(name = "id_lota", nullable = false)
    private Lot lot;

    @ManyToOne
    @JoinColumn(name = "id_uchastnika", nullable = false)
    private Uchastnik uchastnik;

    @Column(name = "summa_stavki", nullable = false)
    private Integer summaStavki;

    @Column(name = "vremya_stavki", nullable = false)
    private LocalTime vremyaStavki;

    // Геттеры и сеттеры
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public Sdelka getSdelka() { return sdelka; }
    public void setSdelka(Sdelka sdelka) { this.sdelka = sdelka; }
    public Lot getLot() { return lot; }
    public void setLot(Lot lot) { this.lot = lot; }
    public Uchastnik getUchastnik() { return uchastnik; }
    public void setUchastnik(Uchastnik uchastnik) { this.uchastnik = uchastnik; }
    public Integer getSummaStavki() { return summaStavki; }
    public void setSummaStavki(Integer summaStavki) { this.summaStavki = summaStavki; }
    public LocalTime getVremyaStavki() { return vremyaStavki; }
    public void setVremyaStavki(LocalTime vremyaStavki) { this.vremyaStavki = vremyaStavki; }
}