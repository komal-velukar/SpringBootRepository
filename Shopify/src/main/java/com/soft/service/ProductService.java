package com.soft.service;





import com.soft.dto.ProductDTO;
import com.soft.entity.Product;

import java.util.List;

public interface ProductService {

   
    List<Product> getAll();

    
    Product save(ProductDTO productDTO);
}