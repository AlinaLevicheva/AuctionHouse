package com.auction.auctionhouse.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "sotrydnik")
public class Sotrydnik {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_sotrydnika")
    private Integer id;

    @Column(name = "familiya", nullable = false)
    private String familiya;

    @Column(name = "imya", nullable = false)
    private String imya;

    @Column(name = "otchestvo")
    private String otchestvo;

    @Column(name = "dolzhnost", length = 30)
    private String dolzhnost;

    @Column(name = "email", nullable = false, length = 30, columnDefinition = "varchar(30)")
    private String email;

    @Column(name = "nomer_telefona", nullable = false, length = 12, columnDefinition = "bpchar(12)")
    private String nomerTelefona;

    // Геттеры и сеттеры
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getFamiliya() { return familiya; }
    public void setFamiliya(String familiya) { this.familiya = familiya; }
    public String getImya() { return imya; }
    public void setImya(String imya) { this.imya = imya; }
    public String getOtchestvo() { return otchestvo; }
    public void setOtchestvo(String otchestvo) { this.otchestvo = otchestvo; }
    public String getDolzhnost() { return dolzhnost; }
    public void setDolzhnost(String dolzhnost) { this.dolzhnost = dolzhnost; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getNomerTelefona() { return nomerTelefona; }
    public void setNomerTelefona(String nomerTelefona) { this.nomerTelefona = nomerTelefona; }
}