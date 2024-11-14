package com.example.mysql.controller;

import java.io.Serial;
import java.lang.StackWalker.Option;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.mysql.dto.product.ProductDTO;
import com.example.mysql.dto.product.ProductSpecificationDTO;
import com.example.mysql.model.product.Brand;
import com.example.mysql.model.product.Model;
import com.example.mysql.model.product.Product;
import com.example.mysql.model.product.ProductSerial;
import com.example.mysql.model.product.ProductType;
import com.example.mysql.repository.product.BrandRepository;
import com.example.mysql.repository.product.ModelRepository;
import com.example.mysql.repository.product.ProductTypeRepository;
import com.example.mysql.service.ProductService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private BrandRepository brandRepository;
    @Autowired
    private ModelRepository modelRepository;
    @Autowired
    private ProductTypeRepository productTypeRepository;


    @PostMapping
    public Product createProduct(@RequestBody ProductDTO productDTO) {
        
        Optional<Brand> brandOptional = brandRepository.findById(productDTO.getBrandId());
        Optional<Model> modelOptional = modelRepository.findById(productDTO.getModelId());
        Optional<ProductType> productTypeOptional = productTypeRepository.findById(productDTO.getProductTypeId());

        
        Product product = new Product();
        product.setName(productDTO.getName());
        product.setPrice(productDTO.getPrice());
        product.setProductType(productTypeOptional.get());
        product.setBrand(brandOptional.get());
        product.setModel(modelOptional.get());
        product.setStock(productDTO.getStock());

        List<ProductSpecificationDTO> productSpecificationDTOs = productDTO.getProductSpecificationDTOs();
 
        return productService.createProduct(product, productSpecificationDTOs);
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}/serials")
    public ResponseEntity<List<ProductSerial>> getProductSerialsByProductId(@PathVariable Integer id) {
        List<ProductSerial> serials = productService.getProductSerialsByProductId(id);

        if(serials.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(serials);
    }
    
    
}
