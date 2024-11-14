package com.example.mysql.repository.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.mysql.model.product.ProductType;

@Repository
public interface ProductTypeRepository extends JpaRepository<ProductType, Integer>{
    
}
