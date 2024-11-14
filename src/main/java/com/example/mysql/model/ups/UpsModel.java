package com.example.mysql.model.ups;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class UpsModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "brand", nullable = false)
    private UpsBrand brand;

    private String name;
    private Integer capacity;
    private Integer voltIn;
    private Integer voltOut;
    private Integer doubleConversion;
    private double price;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public UpsBrand getBrand() {
        return brand;
    }

    public void setBrand(UpsBrand brand) {
        this.brand = brand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Integer getVoltIn() {
        return voltIn;
    }

    public void setVoltIn(Integer voltIn) {
        this.voltIn = voltIn;
    }

    public Integer getVoltOut() {
        return voltOut;
    }

    public void setVoltOut(Integer voltOut) {
        this.voltOut = voltOut;
    }

    public Integer getDoubleConversion() {
        return doubleConversion;
    }

    public void setDoubleConversion(Integer doubleConversion) {
        this.doubleConversion = doubleConversion;
    }
}
