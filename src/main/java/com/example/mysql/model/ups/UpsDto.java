package com.example.mysql.model.ups;

import java.time.LocalDateTime;

public class UpsDto {

    private Integer brandId;
    private Integer modelId;
    private String serie;
    private LocalDateTime entryDate;
    private LocalDateTime saleDate;
    private Integer state;


    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    public Integer getModelId() {
        return modelId;
    }

    public void setModelId(Integer modelId) {
        this.modelId = modelId;
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

    public Integer getState(){
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

}
