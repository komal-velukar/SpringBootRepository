package com.soft.service;


import com.soft.dto.ProductDTO;
import com.soft.entity.Product;
import com.soft.repository.ProductRepository;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

   
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAll() {
        return productRepository.findAll();
    }

    public Product save(ProductDTO productDTO) {
       
        Product product = new Product();
        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setPrice(productDTO.getPrice().doubleValue()); 

       
        return productRepository.save(product);
    }
}