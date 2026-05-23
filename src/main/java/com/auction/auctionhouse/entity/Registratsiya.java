package com.auction.auctionhouse.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "registratsiya")
public class Registratsiya {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_registratsii")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_auktsiona", nullable = false)
    private Auktsion auktsion;

    @ManyToOne
    @JoinColumn(name = "id_uchastnika", nullable = false)
    private Uchastnik uchastnik;

    @Column(name = "nomer_uchastnika", nullable = false)
    private Integer nomerUchastnika;

    @Column(name = "status_dostupa", nullable = false)
    private String statusDostupa;

    @Column(name = "summa_zadatka", nullable = false)
    private Integer summaZadatka;

    // Геттеры и сеттеры
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public Auktsion getAuktsion() { return auktsion; }
    public void setAuktsion(Auktsion auktsion) { this.auktsion = auktsion; }
    public Uchastnik getUchastnik() { return uchastnik; }
    public void setUchastnik(Uchastnik uchastnik) { this.uchastnik = uchastnik; }
    public Integer getNomerUchastnika() { return nomerUchastnika; }
    public void setNomerUchastnika(Integer nomerUchastnika) { this.nomerUchastnika = nomerUchastnika; }
    public String getStatusDostupa() { return statusDostupa; }
    public void setStatusDostupa(String statusDostupa) { this.statusDostupa = statusDostupa; }
    public Integer getSummaZadatka() { return summaZadatka; }
    public void setSummaZadatka(Integer summaZadatka) { this.summaZadatka = summaZadatka; }
}