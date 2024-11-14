package com.example.mysql.model.ups;

import java.time.LocalDateTime;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Ups {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "brand", nullable = false)
    private UpsBrand brand;

    @ManyToOne
    @JoinColumn(name = "model", nullable = false)
    private UpsModel model;

    private String serie;
    private LocalDateTime entryDate = LocalDateTime.now();
    private LocalDateTime saleDate;
    private Integer state;

    public Integer getId() {
        return id;
    }

    public UpsBrand getBrand() {
        return brand;
    }

    public void setBrand(UpsBrand brand) {
        this.brand = brand;
    }

    public UpsModel getModel() {
        return model;
    }

    public void setModel(UpsModel model) {
        this.model = model;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public LocalDateTime getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(LocalDateTime entryDate) {
        this.entryDate = entryDate;
    }

    public LocalDateTime getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(LocalDateTime saleDate) {
        this.saleDate = saleDate;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}
