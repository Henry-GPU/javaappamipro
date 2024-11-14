package com.example.mysql.dto.product;

public class ProductSpecificationDTO {
    private Integer specificationId;
    private String value;

    public Integer getSpecificationId() {
        return specificationId;
    }
    public void setSpecificationId(Integer specificationId) {
        this.specificationId = specificationId;
    }
    public String getValue() {
        return value;
    }
    public void setValue(String value) {
        this.value = value;
    }
}
