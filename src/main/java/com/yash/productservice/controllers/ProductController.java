package com.yash.productservice.controllers;

import com.yash.productservice.models.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @PostMapping("/products")
    public void createProduct(){

    }

    @GetMapping("/products/{id}")
    public Product getProductById(@PathVariable("id") int id){
        return null;
    }

    @GetMapping("/products")
    public void getAllProducts(){

    }
}
