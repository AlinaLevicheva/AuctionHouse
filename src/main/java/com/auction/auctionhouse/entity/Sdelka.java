package com.auction.auctionhouse.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "sdelka")
public class Sdelka {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_sdelki")
    private Integer id;

    @Column(name = "finalnaya_tsena", nullable = false)
    private Integer finalnayaTsena;

    @Column(name = "summa_k_oplate", nullable = false)
    private Integer summaKOpate;

    @Column(name = "summa_k_vyplate", nullable = false)
    private Integer summaKVyplate;

    @Column(name = "status")
    private String status;

    // Геттеры и сеттеры
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public Integer getFinalnayaTsena() { return finalnayaTsena; }
    public void setFinalnayaTsena(Integer finalnayaTsena) { this.finalnayaTsena = finalnayaTsena; }
    public Integer getSummaKOpate() { return summaKOpate; }
    public void setSummaKOpate(Integer summaKOpate) { this.summaKOpate = summaKOpate; }
    public Integer getSummaKVyplate() { return summaKVyplate; }
    public void setSummaKVyplate(Integer summaKVyplate) { this.summaKVyplate = summaKVyplate; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
