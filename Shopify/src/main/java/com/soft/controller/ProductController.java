



package com.soft.controller;

import com.soft.dto.ProductDTO;
import com.soft.entity.Product;
import com.soft.service.ProductService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<ProductDTO> list() {
        return productService.getAll().stream()
                .map(p -> new ProductDTO(
                    p.getId(),
                    p.getName(),
                    p.getDescription(),
                    BigDecimal.valueOf(p.getPrice())
                ))
                .collect(Collectors.toList());
    }

    
    @PostMapping
    public ResponseEntity<ProductDTO> create(@RequestBody ProductDTO productDTO) {
        Product savedProduct = productService.save(productDTO);
        ProductDTO response = new ProductDTO(
            savedProduct.getId(),
            savedProduct.getName(),
            savedProduct.getDescription(),
            BigDecimal.valueOf(savedProduct.getPrice())
        );
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
