package com.example.mysql.dto.product;

import java.util.List;

public class ProductDTO {
    private String name;
    private String description;
    private Double price;
    private Integer stock;
    private Integer brandId;
    private Integer modelId;
    private Integer productTypeId;
    private List<ProductSpecificationDTO> productSpecificationDTOs;
    private List<ProductSerialDTO> productSerialDTOs;

    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }
    public Integer getStock() {
        return stock;
    }
    public void setStock(Integer stock) {
        this.stock = stock;
    }
    public List<ProductSpecificationDTO> getProductSpecificationDTOs() {
        return productSpecificationDTOs;
    }
    public void setProductSpecificationDTOs(List<ProductSpecificationDTO> productSpecificationDTOs) {
        this.productSpecificationDTOs = productSpecificationDTOs;
    }
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
    public Integer getProductTypeId() {
        return productTypeId;
    }
    public void setProductTypeId(Integer productTypeId) {
        this.productTypeId = productTypeId;
    }
    public List<ProductSerialDTO> getProductSerialDTOs() {
        return productSerialDTOs;
    }
    public void setProductSerialDTOs(List<ProductSerialDTO> productSerialDTOs) {
        this.productSerialDTOs = productSerialDTOs;
    }

    
}
