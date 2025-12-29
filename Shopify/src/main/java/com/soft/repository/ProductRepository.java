package com.soft.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.soft.entity.Product;


public interface ProductRepository extends JpaRepository<Product, Long> { }