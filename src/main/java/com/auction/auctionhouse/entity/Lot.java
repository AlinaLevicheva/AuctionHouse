package com.auction.auctionhouse.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "lot")
public class Lot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_lota")
    private Integer id;

    @Column(name = "nazvanie", nullable = false)
    private String nazvanie;

    @Column(name = "opisanie", nullable = false)
    private String opisanie;

    @Column(name = "startovaya_tsena", nullable = false)
    private Integer startovayaTsena;

    @Column(name = "rezervnaya_tsena", nullable = false)
    private Integer rezervnayaTsena;

    @Column(name = "status", nullable = false)
    private String status;

    // Геттеры и сеттеры
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getNazvanie() { return nazvanie; }
    public void setNazvanie(String nazvanie) { this.nazvanie = nazvanie; }
    public String getOpisanie() { return opisanie; }
    public void setOpisanie(String opisanie) { this.opisanie = opisanie; }
    public Integer getStartovayaTsena() { return startovayaTsena; }
    public void setStartovayaTsena(Integer startovayaTsena) { this.startovayaTsena = startovayaTsena; }
    public Integer getRezervnayaTsena() { return rezervnayaTsena; }
    public void setRezervnayaTsena(Integer rezervnayaTsena) { this.rezervnayaTsena = rezervnayaTsena; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}