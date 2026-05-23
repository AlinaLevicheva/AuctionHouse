package com.auction.auctionhouse.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "uchastnik")
public class Uchastnik {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_uchastnika")
    private Integer id;

    @Column(name = "familiya", nullable = false)
    private String familiya;

    @Column(name = "imya", nullable = false)
    private String imya;

    @Column(name = "otchestvo")
    private String otchestvo;

    @Column(name = "kolichestvo_kuplennyh_tovarov", nullable = false)
    private Integer kolichestvoKuplennyhTovarov;

    // Геттеры и сеттеры
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getFamiliya() { return familiya; }
    public void setFamiliya(String familiya) { this.familiya = familiya; }
    public String getImya() { return imya; }
    public void setImya(String imya) { this.imya = imya; }
    public String getOtchestvo() { return otchestvo; }
    public void setOtchestvo(String otchestvo) { this.otchestvo = otchestvo; }
    public Integer getKolichestvoKuplennyhTovarov() { return kolichestvoKuplennyhTovarov; }
    public void setKolichestvoKuplennyhTovarov(Integer kolichestvoKuplennyhTovarov) { this.kolichestvoKuplennyhTovarov = kolichestvoKuplennyhTovarov; }
}