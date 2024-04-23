package com.yash.productservice.controllers;

import com.yash.productservice.dtos.FakeStoreProductDTO;
import com.yash.productservice.dtos.ProductResponseDTO;
import com.yash.productservice.models.Product;
import com.yash.productservice.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    private ProductService productService;

    public ProductController(@Qualifier("selfproductservice") ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/products")
    public Product createProduct(@RequestBody ProductResponseDTO productResponseDTO){
        return productService.createProduct(productResponseDTO);
    }

    @GetMapping("/products/{id}")
    public Product getProductById(@PathVariable("id") Long id){
        return productService.getSingleProduct(id);
    }

    @GetMapping("/products")
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @PutMapping("/products/{id}")
    public void updateProduct(@PathVariable Long id,@RequestBody ProductResponseDTO productResponseDTO){
        productService.updateProduct(id,productResponseDTO);
    }

    @DeleteMapping("/products/{id}")
    public void deleteProduct(@PathVariable Long id){
        productService.deleteProduct(id);
    }
}
