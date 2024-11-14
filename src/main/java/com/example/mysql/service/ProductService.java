package com.example.mysql.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mysql.dto.product.ProductSpecificationDTO;
import com.example.mysql.model.product.Product;
import com.example.mysql.model.product.ProductSerial;
import com.example.mysql.model.product.ProductSpecification;
import com.example.mysql.model.product.Specification;
import com.example.mysql.repository.product.BrandRepository;
import com.example.mysql.repository.product.ModelRepository;
import com.example.mysql.repository.product.ProductRepository;
import com.example.mysql.repository.product.ProductSerialRepository;
import com.example.mysql.repository.product.ProductSpecificationRepository;
import com.example.mysql.repository.product.ProductTypeRepository;
import com.example.mysql.repository.product.SpecificationRepository;

import jakarta.transaction.Transactional;

@Service
public class ProductService {
    
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductTypeRepository productTypeRepository;
    @Autowired
    private ModelRepository modelRepository;
    @Autowired
    private BrandRepository brandRepository;
    @Autowired
    private SpecificationRepository specificationRepository;
    @Autowired
    private ProductSpecificationRepository productSpecificationRepository;
    @Autowired
    private ProductSerialRepository productSerialRepository;

    @Transactional
    public Product createProduct(Product product, List<ProductSpecificationDTO> productSpecificationDTOs){

        Product savedProduct = productRepository.save(product);

        for(ProductSpecificationDTO productSpecificationDTO : productSpecificationDTOs){
            Specification specification = specificationRepository.findById(productSpecificationDTO.getSpecificationId())
            .orElseThrow(() -> new RuntimeException("Especificacion no encontrada."));

            if(specification.getProductType().equals(savedProduct.getProductType())){
                ProductSpecification productSpecification = new ProductSpecification();
                productSpecification.setProduct(savedProduct);
                productSpecification.setSpecification(specification);
                productSpecification.setValue(productSpecificationDTO.getValue());
                productSpecificationRepository.save(productSpecification);
            }
            else{
                throw new RuntimeException("La especificación no corresponde al tipo de producto. " + specification.getProductType() + "   " + savedProduct.getProductType());
            }
        }
        return savedProduct;
    }

    public List<ProductSerial> getProductSerialsByProductId(Integer productId){
            return productSerialRepository.findByProductId(productId);
    }

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

}
