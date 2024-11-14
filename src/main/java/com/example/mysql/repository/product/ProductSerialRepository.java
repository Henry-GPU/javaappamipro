package com.example.mysql.repository.product;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.mysql.model.product.ProductSerial;

@Repository
public interface ProductSerialRepository extends JpaRepository<ProductSerial, Integer>{
    List<ProductSerial> findByProductId(Integer productId);
}
