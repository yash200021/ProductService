package com.yash.productservice.services;

import com.yash.productservice.dtos.FakeStoreProductDTO;
import com.yash.productservice.models.Product;

import java.util.List;

public interface ProductService {
    public Product getSingleProduct(Long id);
    public List<Product> getAllProducts();
}
